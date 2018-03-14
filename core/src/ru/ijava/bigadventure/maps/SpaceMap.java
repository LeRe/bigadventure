package ru.ijava.bigadventure.maps;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.ijava.bigadventure.ifaces.GameMap;

/**
 * Created by rele on 3/2/18.
 */

public class SpaceMap extends Actor implements GameMap {
    private final String fileName = "big-space-adventure.jpg";
    @Override
    public String getMapFileName() {
        return fileName;
    }


    private static final int MAP_WIDTH = 3131;
    private static final int MAP_HEIGHT = 2000;

    @Override
    public float getMapWidth() {
        return MAP_WIDTH;
    }

    @Override
    public float getMapHeight() {
        return MAP_HEIGHT;
    }

    @Override
    public Actor getMapActor() {
        return (Actor) this;
    }

    TextureRegion region;
    public SpaceMap () {
        region = new TextureRegion(new Texture(fileName));
        setX(0);
        setY(0);

        setWidth(MAP_WIDTH);
        setHeight(MAP_HEIGHT);
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    @Override
    public int getCenterCellX(int indexOnMapPosition) {
        return 200;
    }

    @Override
    public int getCenterCellY(int indexOnMapPosition) {
        return 145;
    }
}
