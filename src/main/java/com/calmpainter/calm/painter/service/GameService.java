package com.calmpainter.calm.painter.service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import com.calmpainter.calm.painter.model.Color;
import com.calmpainter.calm.painter.model.Game;
import com.calmpainter.calm.painter.model.GameState;
import com.calmpainter.calm.painter.model.Grid;
import com.calmpainter.calm.painter.model.Player;
import com.calmpainter.calm.painter.model.TargetPainting;
import com.calmpainter.calm.painter.repository.GameRepository;
import com.calmpainter.calm.painter.repository.TargetPaintingRepository;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final TargetPaintingRepository targetPaintingRepository;
    private final TaskScheduler taskScheduler;

    public GameService(GameRepository gameRepository, TargetPaintingRepository targetPaintingRepository, TaskScheduler taskScheduler) {
        this.gameRepository = gameRepository;
        this.targetPaintingRepository = targetPaintingRepository;
        this.taskScheduler = taskScheduler;
    }

    public Game createGame() {

        Game game = new Game();
        List<TargetPainting> targetPaintings = targetPaintingRepository.findAll();
        TargetPainting selectedTargetPainting = targetPaintings.get(new Random().nextInt(targetPaintings.size()));
        game.setTargetPainting(selectedTargetPainting);
        return gameRepository.save(game);
    }

    public Game getGame(String gameId) {
        return gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found!"));
    }

    public Game addPlayer(String gameId, String playerName) {

        Game game = getGame(gameId);

        if (game.getState() != GameState.WAITING) {
            throw new RuntimeException("Game has already started!");
        }

        if (game.getPlayers().size() == 4) {
            throw new RuntimeException("Game is full!");
        }

        Color playerColor = null;

        for (Color color : Color.values()) {
            boolean used = false;
            for (Player player : game.getPlayers()) {
                if (player.getColor() == color) {
                    used = true;
                    break;
                }
            }

            if (!used) {
                playerColor = color;
                break;
            }
        }
        Player player = new Player(UUID.randomUUID().toString(), playerName, playerColor);
        game.getPlayers().add(player);
        gameRepository.save(game);
        
        if (game.getPlayers().size() == 4) {
            game = startPictureView(gameId);
        }
        return game;
    }

    private Game startPictureView(String gameId) {
        Game game = getGame(gameId);
        game.setState(GameState.PICTUREVIEW);
        game = gameRepository.save(game);

        taskScheduler.schedule(() -> startPlaying(gameId), new java.util.Date(System.currentTimeMillis() + 10000));

        return game;
    }

    private void startPlaying(String gameId) {
        
        Game game = getGame(gameId);
        
        if (game.getState() != GameState.PICTUREVIEW) {
            return;
        }

        game.setState(GameState.PLAYING);

        gameRepository.save(game);

        taskScheduler.schedule(() -> finishGame(gameId), new java.util.Date(System.currentTimeMillis() + 60000));
    }

    public Game finishGame(String gameId) {

        Game game = getGame(gameId);

        if (game.getState() != GameState.PLAYING) {
            throw new RuntimeException("Game is not being played!");
        }

        game.setState(GameState.FINISHED);

        return gameRepository.save(game);
    }
    
    public Game paint(String gameId, String playerId, int row, int column) {
        
        Game game = getGame(gameId);

        if (game.getState() != GameState.PLAYING) {
            throw new RuntimeException("Game is not being played!");
        }

        Player player = null;

        for (Player p : game.getPlayers()) {

            if (p.getId().equals(playerId)) {
                player = p;
                break;
            }
        }

        if (player == null) {
            throw new RuntimeException("Player does not belong to this game!");
        }

        game.getGrid().paintCell(row, column, player.getColor());
        return gameRepository.save(game);
    }

     public int calculateScore(String gameId) {

        Game game = getGame(gameId);

        Grid targetGrid = game.getTargetPainting().getGrid();
        Grid paintedGrid = game.getGrid();

        int correctCells = 0;

        for (int row = 0; row < Grid.SIZE; row++) {

            for (int column = 0; column < Grid.SIZE; column++) {

                Color targetColor = targetGrid.getCell(row, column);
                Color paintedColor = paintedGrid.getCell(row, column);

                if (targetColor == paintedColor) {
                    correctCells++;
                }
            }
        }

        return correctCells;
    }


}
