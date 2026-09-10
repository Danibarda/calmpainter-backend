package com.calmpainter.calm.painter.model;


import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "games")
public class Game {
    @Id
    private String id;
    private List<Player> players;
    private GameState state;
    private Grid grid;
    private TargetPainting targetPainting;
    private long playingStartedAt;

    public Game() {
        this.players = new ArrayList<>();
        this.state = GameState.WAITING;
        this.grid = new Grid();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public TargetPainting getTargetPainting() {
        return targetPainting;
    }

    public void setTargetPainting(TargetPainting targetPainting) {
        this.targetPainting = targetPainting;
    }

    public long getPlayingStartedAt() {
        return playingStartedAt;
    }

    public void setPlayingStartedAt(long playingStartedAt) {
        this.playingStartedAt = playingStartedAt;
    }
    
}
