package com.calmpainter.calm.painter.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.calmpainter.calm.painter.model.Game;
import com.calmpainter.calm.painter.model.TargetPainting;
import com.calmpainter.calm.painter.repository.GameRepository;
import com.calmpainter.calm.painter.repository.TargetPaintingRepository;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final TargetPaintingRepository targetPaintingRepository;

    public GameService(GameRepository gameRepository, TargetPaintingRepository targetPaintingRepository) {
        this.gameRepository = gameRepository;
        this.targetPaintingRepository = targetPaintingRepository;
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

}
