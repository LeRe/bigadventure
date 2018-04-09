package ru.ijava.bigadventure.maps;

import java.util.ArrayList;
import java.util.List;

import ru.ijava.bigadventure.ifaces.IGamer;
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

    List<IGamer> gamersList;

    public Cell(int index, int centerX, int centerY, CellForm cellForm, int cellWidth, int cellHeight) {
        this.index = index;
        this.centerX = centerX;
        this.centerY = centerY;

        this.cellForm = cellForm;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;

        gamersList = new ArrayList<IGamer>();
    }

    @Override
    public int getCenterX() {
        return centerX;
    }

    @Override
    public int getCenterY() {
        return centerY;
    }

    @Override
    public boolean contains(IGamer IGamer) {
        return gamersList.contains(IGamer);
    }

    @Override
    public void remove(IGamer IGamer) {
        gamersList.remove(IGamer);
    }

    @Override
    public void put(IGamer iGamer) {
        //TODO bad algoritm, need remake...
//        int placeIndex;
//        do {
//            placeIndex = (int) (Math.random() * numberGamers - 1);
//        }
//        while (gamersList.get(placeIndex) != null);
//        gamersList.add(placeIndex, iGamer);

        gamersList.add(iGamer);
        iGamer.setScreenPosition(getGamerX(iGamer), getGamerY(iGamer));
    }

    @Override
    public int getGamerX(IGamer IGamer) {
        int x = 0;
        if (gamersList.contains(IGamer)) {
            switch (gamersList.indexOf(IGamer)) {
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
    public int getGamerY(IGamer IGamer) {
        int y = 0;
        if (gamersList.contains(IGamer)) {
            switch (gamersList.indexOf(IGamer)) {
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
