package ru.ijava.bigadventure;

import java.util.List;

import ru.ijava.bigadventure.ifaces.GameFishka;
import ru.ijava.bigadventure.ifaces.GameMap;

/**
 * Created by levchenko on 15.03.2018.
 */

public class GameMaker {
    private List<GameFishka> gamerList;
    private GameMap map;

    private int frameCounter = 0;

    public GameMaker(GameMap map, List<GameFishka> gamerList) {
        this.map = map;
        this.gamerList = gamerList;

        int position = 0;
        for (GameFishka fishka: gamerList) {
            fishka.setPosition(position);
            //position++;
        }
    }

    public void act() {
        frameCounter++;
        if (frameCounter < 15) return;
        frameCounter = 0;

        for (GameFishka fishka: gamerList) {
            fishka.setPosition(fishka.getPosition() + 1);
        }
    }
}
