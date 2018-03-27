package ru.ijava.bigadventure.ifaces;

/**
 * Created by rele on 2/28/18.
 */

public interface GestureListener {
    void zoom(float initialDistance, float distance);
    void translate(float deltaX, float deltaY);
}
