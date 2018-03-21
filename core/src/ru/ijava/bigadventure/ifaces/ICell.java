package ru.ijava.bigadventure.ifaces;

/**
 * Created by rele on 3/21/18.
 */

public interface ICell {
    boolean contains(GameFishka gameFishka);
    void remove(GameFishka gameFishka);
    void put(GameFishka gameFishka);

    int getCenterX();
    int getCenterY();

    int getGamerX(GameFishka gameFishka);
    int getGamerY(GameFishka gameFishka);
}
