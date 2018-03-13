package ru.ijava.bigadventure.actors;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.ijava.bigadventure.ifaces.GestureWaiter;

/**
 * Created by rele on 3/9/18.
 */

public class MainStage extends Stage implements GestureWaiter {

    private final float MAP_WIDTH;
    private final float MAP_HEIGHT;
    private final float MAP_DIAGONAL;

    private static final float MIN_ZOOM = 0.2f;
    private static final float MAX_ZOOM = 1.5f;

    public MainStage(float mapWidth, float mapHeight) {
        super(new FillViewport(mapWidth, mapHeight));

        MAP_WIDTH = mapWidth;
        MAP_HEIGHT = mapHeight;
        MAP_DIAGONAL = (float) Math.sqrt(MAP_WIDTH * MAP_WIDTH + MAP_HEIGHT * MAP_HEIGHT);
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
}
