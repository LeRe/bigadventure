package ru.ijava.bigadventure.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rele on 3/9/18.
 */

public class GameDie extends Actor {
    private int indexValue; //realValue = indexValue++;
    private float timeInSecunds;

    private final int DIE_SIDE = 52;
    private final int VIEWPORT_SIZE = DIE_SIDE * 10;
    private final int DRAW_X = VIEWPORT_SIZE*9/10 - DIE_SIDE/2;
    private final int DRAW_Y = VIEWPORT_SIZE*7/10 - DIE_SIDE/2;

    private List<TextureRegion> textureRegions = new ArrayList<TextureRegion>();

    public GameDie() {
        Texture texture = new Texture("game-die.jpg");

        int x1 = 15;
        int x2 = 68;
        int x3 = 119;
        int x4 = 172;

        int y1 = 9;
        int y2 = 61;
        int y3 = 113;

        textureRegions.add(0, new TextureRegion(texture, x3, y2, DIE_SIDE, DIE_SIDE));
        textureRegions.add(1, new TextureRegion(texture, x4, y2, DIE_SIDE, DIE_SIDE));
        textureRegions.add(2, new TextureRegion(texture, x2, y1, DIE_SIDE, DIE_SIDE));
        textureRegions.add(3, new TextureRegion(texture, x2, y3, DIE_SIDE, DIE_SIDE));
        textureRegions.add(4, new TextureRegion(texture, x2, y2, DIE_SIDE, DIE_SIDE));
        textureRegions.add(5, new TextureRegion(texture, x1, y2, DIE_SIDE, DIE_SIDE));
    }

    public void throwDie() {
        indexValue = (int) (6 * Math.random());
    }

    public int getViewportSize() {
        return VIEWPORT_SIZE;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        timeInSecunds += delta;
        if (timeInSecunds > 0.25) {
            throwDie();
            timeInSecunds = 0;
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
            batch.draw(textureRegions.get(indexValue), DRAW_X,DRAW_Y);
    }
}
