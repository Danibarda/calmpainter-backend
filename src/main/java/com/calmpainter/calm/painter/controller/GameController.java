package com.calmpainter.calm.painter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calmpainter.calm.painter.model.Game;
import com.calmpainter.calm.painter.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/{gameId}")
    public Game getGame(@PathVariable String gameId) {
        return gameService.getGame(gameId);
    }

    @PostMapping
    public Game createGame() {
        return gameService.createGame();
    }

    @PostMapping("/{gameId}/players")
    public Game addPlayer(@PathVariable String gameId, @RequestParam String playerName) {
        return gameService.addPlayer(gameId, playerName);
    }

    @PostMapping("/{gameId}/start")
    public Game startGame(@PathVariable String gameId) {
        return gameService.startGame(gameId);
    }
    
    @PostMapping("/{gameId}/paint")
    public Game paint(@PathVariable String gameId, @RequestParam String playerId, @RequestParam int row, @RequestParam int column) {
        return gameService.paint(gameId, playerId, row, column);
    }
}
