package ru.ijava.bigadventure.ifaces;

/**
 * Created by rele on 3/21/18.
 */

public interface ICell {
    boolean contains(IGamer IGamer);
    void remove(IGamer IGamer);
    void put(IGamer IGamer);

    int getCenterX();
    int getCenterY();

    int getGamerX(IGamer IGamer);
    int getGamerY(IGamer IGamer);
}
