package ru.ijava.bigadventure.ifaces;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by rele on 3/2/18.
 */

public interface GameMap {
    float getMapWidth();
    float getMapHeight();
    Actor getMapAsActor();

    int getMaxPositionIndex();

    int getGamerX(IGamer IGamer);
    int getGamerY(IGamer IGamer);

    void putGamerToCell(int indexOnMapPosition, IGamer IGamer);
    void moveGamer(int step, IGamer IGamer);
}
