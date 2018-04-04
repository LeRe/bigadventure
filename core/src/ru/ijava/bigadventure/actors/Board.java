package ru.ijava.bigadventure.actors;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;

import java.util.ArrayList;
import java.util.List;

import ru.ijava.bigadventure.ifaces.GameMap;
import ru.ijava.bigadventure.ifaces.GestureListener;
import ru.ijava.bigadventure.ifaces.IGamer;

/**
 * Created by rele on 3/9/18.
 */

public class Board extends Stage implements GestureListener {

    private float MAP_WIDTH;
    private float MAP_HEIGHT;
    private float MAP_DIAGONAL;

    private static final float MIN_ZOOM = 0.2f;
    private static final float MAX_ZOOM = 1.5f;

    private List<IGamer> gamerList = new ArrayList<IGamer>();
    private List<IGamer> waitingMoveList = new ArrayList<IGamer>();
    private GameMap gameMap;
    private int frameCounter = 0;

    public Board(GameMap gameMap) {
        super(new FillViewport(gameMap.getMapWidth(), gameMap.getMapHeight()));

        MAP_WIDTH = gameMap.getMapWidth();
        MAP_HEIGHT = gameMap.getMapHeight();
        MAP_DIAGONAL = (float) Math.sqrt(MAP_WIDTH * MAP_WIDTH + MAP_HEIGHT * MAP_HEIGHT);

        this.gameMap = gameMap;
    }

    @Override
    public void zoom(float initialDistance, float distance) {
        OrthographicCamera camera = (OrthographicCamera) getCamera();

        float deltaDistance = Math.abs(initialDistance - distance);
        float delta = deltaDistance / MAP_DIAGONAL;

        if (initialDistance < distance) {
            camera.zoom -= delta;
            if (camera.zoom < MIN_ZOOM) camera.zoom = MIN_ZOOM;
        }
        else if (initialDistance > distance) {
            camera.zoom += delta;
            if (camera.zoom > MAX_ZOOM) camera.zoom = MAX_ZOOM;
        }
    }

    @Override
    public void translate(float deltaX, float deltaY) {
        Camera camera = getCamera();

        deltaX = -deltaX;
        if (camera.position.x + deltaX < 0 || camera.position.x + deltaX > MAP_WIDTH) deltaX = 0;
        if (camera.position.y + deltaY < 0 || camera.position.y + deltaY > MAP_HEIGHT) deltaY = 0;
        camera.translate(deltaX, deltaY, 0);
    }

    @Override
    public void addActor(Actor actor) {
        super.addActor(actor);

        if(actor instanceof IGamer) {
            gamerList.add((IGamer) actor);
        }
    }

    @Override
    public void act() {
        frameCounter++;
        if (frameCounter < 30) return;
        frameCounter = 0;

        //TODO Move Actors fuctional from SpaceMap to Board
        //TODO Board will implements GameMap interface and proxing request to SpaceMap...

        //Let's check if any player is making a move now, break if so

        //check to see if any player is in the final cell, if it is so - the game is over

        //if the waitingMoveList is empty fill it
        //
        //get next gamer from waiting list (remove)
        //
        // this gamer throw gamedie and make steps


//
//        int position = 0;
//        for (IGamer gamer: gamerList) {
//            this.gameMap.putGamerToCell(position, gamer);
//        }
//
//        fillWaitingMoveList();


        for (IGamer fishka: gamerList) {
            gameMap.moveGamer(2, fishka);
        }
    }

    private void fillWaitingMoveList() {
        for (IGamer gamer: gamerList) {
            waitingMoveList.add(gamer);
        }
    }
}
