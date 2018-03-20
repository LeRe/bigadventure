package ru.ijava.bigadventure.ifaces;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by rele on 3/2/18.
 */

public interface GameMap {
    String getMapFileName();
    float getMapWidth();
    float getMapHeight();
    Actor getMapActor();

    int getMaxPositionIndex();

    int getCenterCellX(int indexOnMapPosition);
    int getCenterCellY(int indexOnMapPosition);

    int getGamerX(int indexOnMapPosition, GameFishka gameFishka);
    int getGamerY(int indexOnMapPosition, GameFishka gameFishka);

    void putGamerToCell(int indexOnMapPosition, GameFishka gameFishka);
    void getGamerFromCell(int indexOnMapPosition, GameFishka gameFishka);
}
