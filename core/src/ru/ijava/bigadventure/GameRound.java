package ru.ijava.bigadventure;

import java.util.ArrayList;
import java.util.List;

import ru.ijava.bigadventure.ifaces.IGamer;
import ru.ijava.bigadventure.ifaces.GameMap;

/**
 * Created by levchenko on 15.03.2018.
 */

public class GameRound {
    private List<IGamer> gamerList;
    private List<IGamer> waitingMoveList = new ArrayList<IGamer>();
    private GameMap map;

    private int frameCounter = 0;

    public GameRound(GameMap map, List<IGamer> gamerList) {
        this.map = map;
        this.gamerList = gamerList;

        int position = 0;
        for (IGamer gamer: gamerList) {
            this.map.putGamerToCell(position, gamer);
        }

        fillWaitingMoveList();
    }

    public void act() {
        frameCounter++;
        if (frameCounter < 30) return;
        frameCounter = 0;

        //Let's check if any player is making a move now, break if so


        //check to see if any player is in the final cell, if it is so - the game is over


        //if the waitingMoveList is empty fill it
        //
        //get next gamer from waiting list (remove)
        //
        // this gamer throw gamedie and make steps




        for (IGamer fishka: gamerList) {
            map.moveGamer(2, fishka);
        }
    }

    private void fillWaitingMoveList() {
        for (IGamer gamer: gamerList) {
            waitingMoveList.add(gamer);
        }
    }
}
