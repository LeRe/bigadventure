package ru.ijava.bigadventure.maps;

import java.util.ArrayList;
import java.util.List;

import ru.ijava.bigadventure.ifaces.GameFishka;
import ru.ijava.bigadventure.ifaces.ICell;

/**
 * Created by levchenko on 14.03.2018.
 */

public class Cell implements ICell {

    private int index;
    private int centerX;
    private int centerY;
    private CellForm cellForm;
    private int cellWidth;
    private int cellHeight;
    private int numberGamers = 4;

    List<GameFishka> fishkaList;

    public Cell(int index, int centerX, int centerY, CellForm cellForm, int cellWidth, int cellHeight) {
        this.index = index;
        this.centerX = centerX;
        this.centerY = centerY;

        fishkaList = new ArrayList<GameFishka>();
        for (int i = 0; i < numberGamers; i++) {
            fishkaList.add(null);
        }

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    @Override
    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }


    @Override
    public boolean contains(GameFishka gameFishka) {
        return fishkaList.contains(gameFishka);
    }

    @Override
    public void remove(GameFishka gameFishka) {
        fishkaList.remove(gameFishka);
    }

    @Override
    public void put(GameFishka gameFishka) {
        //TODO bad algoritm, need remake...
//        int placeIndex;
//        do {
//            placeIndex = (int) (Math.random() * numberGamers - 1);
//        }
//        while (fishkaList.get(placeIndex) != null);
//        fishkaList.add(placeIndex, gameFishka);

        fishkaList.add(gameFishka);
    }

    @Override
    public int getGamerX(GameFishka gameFishka) {
        int x = 0;
        if (fishkaList.contains(gameFishka)) {
            switch (fishkaList.indexOf(gameFishka)) {
                case 0:
                    x = getCenterX() - cellWidth / 4;
                    break;
                case 1:
                    x = getCenterX() + cellWidth / 4;
                    break;
                case 2:
                    x = getCenterX() - cellWidth / 4;
                    break;
                case 3:
                    x = getCenterX() + cellWidth / 4;
                    break;
                default:
                    x = getCenterX();
            }
        }
        return x;
    }

    @Override
    public int getGamerY(GameFishka gameFishka) {
        int y = 0;
        if (fishkaList.contains(gameFishka)) {
            switch (fishkaList.indexOf(gameFishka)) {
                case 0:
                    y = getCenterY() - cellHeight / 4;
                    break;
                case 1:
                    y = getCenterY() - cellHeight / 4;
                    break;
                case 2:
                    y = getCenterY() + cellHeight / 4;
                    break;
                case 3:
                    y = getCenterY() + cellHeight / 4;
                    break;
                default:
                    y = getCenterY();
            }
        }
        return y;
    }
}
