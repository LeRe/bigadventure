package ru.ijava.bigadventure.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.ijava.bigadventure.ifaces.GameFishka;
import ru.ijava.bigadventure.ifaces.GameMap;

/**
 * Created by rele on 3/5/18.
 */

public class Fishka extends Actor implements GameFishka {
    private Texture texture;

    private final int FISHKA_WIDTH = 290;
    private final int FISHKA_HEIGHT = 180;

    private int indexOnMapPosition;
    private GameMap gameMap;
    private FishkaColor fishkaColor;

    public Fishka (FishkaColor fishkaColor, GameMap gameMap) {
        indexOnMapPosition = 0;
        this.gameMap = gameMap;
        this.fishkaColor = fishkaColor;

        gameMap.putGamerToCell(indexOnMapPosition, this);

        Pixmap pixmap = new Pixmap(FISHKA_WIDTH, FISHKA_HEIGHT, Pixmap.Format.RGBA8888 );

        switch (this.fishkaColor) {
            case RED :
                pixmap.setColor(1,0,0,1);
                break;
            case GREEN :
                pixmap.setColor(0,1,0,1);
                break;
            case BLUE:
                pixmap.setColor(0,0,1,1);
                break;
            case YELLOW:
                pixmap.setColor(1,1,0,1);
                break;
        }
        pixmap.fillCircle(FISHKA_WIDTH / 2,FISHKA_HEIGHT / 2, FISHKA_HEIGHT / 2);
        pixmap.drawRectangle(0,0, FISHKA_WIDTH, FISHKA_HEIGHT);

        texture = new Texture(pixmap);

        setWidth(FISHKA_WIDTH);
        setHeight(FISHKA_HEIGHT);

        setPositionOnScreen();
    }

    private void setPositionOnScreen() {
        setX(gameMap.getGamerX(this));
        setY(gameMap.getGamerY(this));
    }

    public int getIndexOnMapPosition() {
        return indexOnMapPosition;
    }

    public void setIndexOnMapPosition(int indexOnMapPosition) {
        this.indexOnMapPosition = indexOnMapPosition;
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(texture, getX(), getY());
    }

    @Override
    public void setPosition(int position) {
        gameMap.putGamerToCell(indexOnMapPosition, this);
        if (position > gameMap.getMaxPositionIndex()) {
            indexOnMapPosition = 0;
        }
        else {
            indexOnMapPosition = position;
        }

        gameMap.putGamerToCell(indexOnMapPosition, this);

        setPositionOnScreen();
    }

    @Override
    public int getPosition() {
        return indexOnMapPosition;
    }
}
