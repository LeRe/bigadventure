package ru.ijava.bigadventure.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.ijava.bigadventure.ifaces.GameMap;

/**
 * Created by rele on 3/5/18.
 */

public class Fishka extends Actor {
    private Texture texture;
    private int indexOnMapPosition;
    private GameMap gameMap;
    private FishkaColor fishkaColor;

    public Fishka (FishkaColor fishkaColor, GameMap gameMap) {
        indexOnMapPosition = 0;
        this.gameMap = gameMap;
        this.fishkaColor = fishkaColor;

        Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGBA8888 );

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
        pixmap.fillCircle(50,50, 50);
        texture = new Texture(pixmap);

        setWidth(100);
        setHeight(100);

        setPositionOnScreen();
    }

    private void setPositionOnScreen() {
        int x = gameMap.getCenterCellX(indexOnMapPosition);
        int y = gameMap.getCenterCellY(indexOnMapPosition);


        switch (fishkaColor) {
            case RED:
                x -= 200;
                break;
            case GREEN:
                x -= 100;
                break;
            case BLUE:

                break;
            case YELLOW:
                x += 100;
                break;
        }

        setX(x);
        setY(y);
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(texture, getX(), getY());
    }
}
