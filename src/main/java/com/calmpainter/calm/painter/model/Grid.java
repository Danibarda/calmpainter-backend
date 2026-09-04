package com.calmpainter.calm.painter.model;

import org.springframework.data.annotation.PersistenceCreator;

public class Grid {

    public static final int SIZE = 15;
    private final Color[][] cells;

    public Grid() {
        this.cells = new Color[SIZE][SIZE];
    }

    @PersistenceCreator 
    public Grid(Color[][] cells) {
        this.cells = cells;
    }

    public void paintCell(int row, int column, Color color) {
        if (row < 0 || row >= SIZE || column < 0 || column >= SIZE) {
            throw new IllegalArgumentException("Invalid cell coordinates");
        }
        cells[row][column] = color;
    }

    public Color getCell(int row, int column) {
        if (row < 0 || row >= SIZE || column < 0 || column >= SIZE) {
            throw new IllegalArgumentException("Invalid cell coordinates");
        }
        return cells[row][column];
    }

    public Color[][] getCells() {
        return cells;
    }
}