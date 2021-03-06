package ru.ijava.bigadventure;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

import ru.ijava.bigadventure.ifaces.GestureListener;

/**
 * Created by rele on 2/26/18.
 */

public class BigAdvGestureListener implements GestureDetector.GestureListener {
    private List<GestureListener> gestureListeners;


    public BigAdvGestureListener() {
        gestureListeners = new ArrayList<GestureListener>();
    }

    public void addWaiter(GestureListener gestureListener) {
        gestureListeners.add(gestureListener);
    }

    public void removeWaiter(GestureListener gestureListener) {
        if (gestureListeners.contains(gestureListener)) {
            gestureListeners.remove(gestureListener);
        }
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        if (gestureListeners.size() == 0) {
            return false;
        }
        for (GestureListener waiter: gestureListeners) {
            waiter.translate(deltaX,deltaY);

        }
        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        if (gestureListeners.size() == 0) {
            return false;
        }
        for (GestureListener waiter: gestureListeners) {
            waiter.zoom(initialDistance, distance);
        }
        return true;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
