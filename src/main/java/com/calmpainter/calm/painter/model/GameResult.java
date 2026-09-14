package com.calmpainter.calm.painter.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gameResults")
public class GameResult {
    @Id
    private String id;
    private Grid picture;
    private double score;
    private long time;
    private List<Player> players;

    
    public GameResult() {
    }
    
    public GameResult(Grid picture, double score, long time, List<Player> players) {
        this.picture = picture;
        this.score = score;
        this.time = time;
        this.players = players;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Grid getPicture() {
        return picture;
    }
    public void setPicture(Grid picture) {
        this.picture = picture;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    
}
