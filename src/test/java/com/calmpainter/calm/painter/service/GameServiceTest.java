package com.calmpainter.calm.painter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.TaskScheduler;

import com.calmpainter.calm.painter.model.Color;
import com.calmpainter.calm.painter.model.Game;
import com.calmpainter.calm.painter.model.GameState;
import com.calmpainter.calm.painter.model.Grid;
import com.calmpainter.calm.painter.model.Player;
import com.calmpainter.calm.painter.model.TargetPainting;
import com.calmpainter.calm.painter.repository.GameRepository;
import com.calmpainter.calm.painter.repository.GameResultRepository;
import com.calmpainter.calm.painter.repository.TargetPaintingRepository;

class GameServiceTest {

    private GameRepository gameRepository;
    private TargetPaintingRepository targetPaintingRepository;
    private GameResultRepository gameResultRepository;
    private TaskScheduler taskScheduler;
    private SimpMessagingTemplate messagingTemplate;
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameRepository = mock(GameRepository.class);
        targetPaintingRepository = mock(TargetPaintingRepository.class);
        gameResultRepository = mock(GameResultRepository.class);
        taskScheduler = mock(TaskScheduler.class);
        messagingTemplate = mock(SimpMessagingTemplate.class);

        gameService = new GameService(
                gameRepository,
                targetPaintingRepository,
                taskScheduler,
                gameResultRepository,
                messagingTemplate);
    }

    @Test
    void calculateScoreReturnsHundredWhenAllCellsMatch() {
        Grid targetGrid = new Grid();
        Grid paintedGrid = new Grid();

        for (int row = 0; row < Grid.SIZE; row++) {
            for (int col = 0; col < Grid.SIZE; col++) {
                targetGrid.paintCell(row, col, Color.RED);
                paintedGrid.paintCell(row, col, Color.RED);
            }
        }

        Game game = new Game();
        game.setId("game-1");
        game.setTargetPainting(new TargetPainting("test", targetGrid));
        game.setGrid(paintedGrid);

        when(gameRepository.findById("game-1")).thenReturn(Optional.of(game));
        double score = gameService.calculateScore("game-1");
        assertThat(score).isEqualTo(100.0);
    }

    @Test
    void calculateScoreReturnsZeroWhenNoCellsMatch() {
        Grid targetGrid = new Grid();
        Grid paintedGrid = new Grid();

        for (int row = 0; row < Grid.SIZE; row++) {
            for (int col = 0; col < Grid.SIZE; col++) {
                targetGrid.paintCell(row, col, Color.RED);
                paintedGrid.paintCell(row, col, Color.BLUE);
            }
        }

        Game game = new Game();
        game.setId("game-2");
        game.setTargetPainting(new TargetPainting("test", targetGrid));
        game.setGrid(paintedGrid);

        when(gameRepository.findById("game-2")).thenReturn(Optional.of(game));
        double score = gameService.calculateScore("game-2");
        assertThat(score).isEqualTo(0.0);
    }

    @Test
    void calculateScoreReturnsTruePercentage() {
        Grid targetGrid = new Grid();
        Grid paintedGrid = new Grid();

        for (int row = 0; row < Grid.SIZE; row++) {
            for (int col = 0; col < Grid.SIZE; col++) {
                targetGrid.paintCell(row, col, Color.RED);
                paintedGrid.paintCell(row, col, Color.RED);
            }
        }

        paintedGrid.paintCell(0, 0, Color.BLUE);

        Game game = new Game();
        game.setId("game-3");
        game.setTargetPainting(new TargetPainting("test", targetGrid));
        game.setGrid(paintedGrid);

        when(gameRepository.findById("game-3")).thenReturn(Optional.of(game));
        double score = gameService.calculateScore("game-3");
        assertThat(score).isEqualTo((224 * 100.0) / 225);
    }

    @Test
    void addPlayerThrowsExceptionWhenGameAlreadyHasFourPlayers() {
        Game game = new Game();
        game.setId("game-4");
        game.setState(GameState.WAITING);
        game.getPlayers().add(new Player("1", "Caner", Color.BLUE));
        game.getPlayers().add(new Player("2", "Rickard", Color.RED));
        game.getPlayers().add(new Player("3", "Danilo", Color.YELLOW));
        game.getPlayers().add(new Player("4", "Erik", Color.GREEN));

        when(gameRepository.findById("game-4")).thenReturn(Optional.of(game));
        assertThrows(RuntimeException.class, () -> gameService.addPlayer("game-4", "David"));
    }

    @Test
    void addPlayerThrowsExceptionWhenGameAlreadyStarted() {
        Game game = new Game();
        game.setId("game-5");
        game.setState(GameState.PLAYING);

        when(gameRepository.findById("game-5")).thenReturn(Optional.of(game));
        assertThrows(RuntimeException.class, () -> gameService.addPlayer("game-5", "David"));
    }

}