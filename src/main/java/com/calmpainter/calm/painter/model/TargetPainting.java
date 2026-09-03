package com.calmpainter.calm.painter.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "targetPaintings")
public class TargetPainting {

    @Id
    private String id;

    private String name;

    private Grid grid;

    public TargetPainting() {
    }

    public TargetPainting(String name, Grid grid) {
        this.name = name;
        this.grid = grid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }


    
}
