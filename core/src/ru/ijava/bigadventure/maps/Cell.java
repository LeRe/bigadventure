package ru.ijava.bigadventure.maps;

/**
 * Created by levchenko on 14.03.2018.
 */

public class Cell {
    private int index;
    private int centerX;
    private int centerY;

    public Cell(int index, int centerX, int centerY) {
        this.index = index;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }
}
