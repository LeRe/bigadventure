package ru.ijava.bigadventure.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ru.ijava.bigadventure.ifaces.IGamer;

/**
 * Created by rele on 3/5/18.
 */

public class Gamer extends Actor implements IGamer {
    private Texture texture;

    private final int GAMER_WIDTH = 50;
    private final int GAMER_HEIGHT = 50;

    private GamerColor gamerColor;

    public Gamer(GamerColor gamerColor) {
        this.gamerColor = gamerColor;

        Pixmap pixmap = new Pixmap(GAMER_WIDTH, GAMER_HEIGHT, Pixmap.Format.RGBA8888 );

        switch (this.gamerColor) {
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
        pixmap.fillCircle(GAMER_WIDTH / 2, GAMER_HEIGHT / 2, GAMER_HEIGHT / 2);

        texture = new Texture(pixmap);

        setWidth(GAMER_WIDTH);
        setHeight(GAMER_HEIGHT);
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(texture, getX(), getY());
    }

    @Override
    public void setScreenPosition(float x, float y) {
        setX(x);
        setY(y);
    }
}
