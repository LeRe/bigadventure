package ru.ijava.bigadventure.maps;

import java.util.ArrayList;
import java.util.List;

import ru.ijava.bigadventure.ifaces.GameFishka;

/**
 * Created by levchenko on 14.03.2018.
 */

public class Cell {

    private int index;
    private int centerX;
    private int centerY;
    private CellForm cellForm;
    private int cellWidth;
    private int cellHeight;
    private int numberGamers;

    List<GameFishka> fishkaList;

    public Cell(int index, int centerX, int centerY, CellForm cellForm, int cellWidth, int cellHeight) {
        this.index = index;
        this.centerX = centerX;
        this.centerY = centerY;

        fishkaList = new ArrayList<GameFishka>();

    }

    public void putGamerToCell(GameFishka gameFishka) {
        int placeIndex;

        do {
            placeIndex = (int) (Math.random() * numberGamers - 1);
        }
        while (fishkaList.get(placeIndex) != null);

        fishkaList.add(placeIndex, gameFishka);
    }

    public void getGamerFromCell(GameFishka gameFishka) {
        if( fishkaList.contains(gameFishka) ) {
            fishkaList.remove(gameFishka);
        }
    }

    public int getGamerPlaceX(GameFishka gameFishka) {

    }

    public int getGamerPlaceY(GameFishka gameFishka) {

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
