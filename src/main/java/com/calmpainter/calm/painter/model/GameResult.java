package com.calmpainter.calm.painter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gameResults")
public class GameResult {
    @Id
    private String id;
    private Grid picture;
    private double score;
    private long time;

    
    public GameResult() {
    }
    
    public GameResult(Grid picture, double score, long time) {
        this.picture = picture;
        this.score = score;
        this.time = time;
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
    
    
}
