package ru.ijava.bigadventure.maps;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.List;

import ru.ijava.bigadventure.ifaces.GameMap;

/**
 * Created by rele on 3/2/18.
 */

public class SpaceMap extends Actor implements GameMap {

    private final String fileName = "big-space-adventure.jpg";
    private static final int MAP_WIDTH = 3131;
    private static final int MAP_HEIGHT = 2000;

    private List<Cell> cellList;

    private TextureRegion region;

    public SpaceMap () {
        region = new TextureRegion(new Texture(fileName));
        setX(0);
        setY(0);

        setWidth(MAP_WIDTH);
        setHeight(MAP_HEIGHT);

        final int ROW_ONE = 1855;
        final int COLUMN_ONE = 190;
        final int ROW_DELTA = 195;
        final int COLUMN_DELTA = 340;

        cellList = new ArrayList<Cell>();
        // line 1
        cellList.add(0, new Cell(0, COLUMN_ONE + COLUMN_DELTA * 0, MAP_WIDTH - ROW_ONE - ROW_DELTA * 0));
        cellList.add(1, new Cell(1, COLUMN_ONE + COLUMN_DELTA * 1, MAP_WIDTH - ROW_ONE - ROW_DELTA * 0));
        cellList.add(2, new Cell(2, COLUMN_ONE + COLUMN_DELTA * 2, MAP_WIDTH - ROW_ONE - ROW_DELTA * 0));
        cellList.add(3, new Cell(3, COLUMN_ONE + COLUMN_DELTA * 3, MAP_WIDTH - ROW_ONE - ROW_DELTA * 0));
        cellList.add(4, new Cell(4, COLUMN_ONE + COLUMN_DELTA * 4, MAP_WIDTH - ROW_ONE - ROW_DELTA * 0));
        cellList.add(5, new Cell(5, COLUMN_ONE + COLUMN_DELTA * 5, MAP_WIDTH - ROW_ONE - ROW_DELTA * 0));
        cellList.add(6, new Cell(6, COLUMN_ONE + COLUMN_DELTA * 6, MAP_WIDTH - ROW_ONE - ROW_DELTA * 0));

        // line 2
        cellList.add(7, new Cell(7, COLUMN_ONE + COLUMN_DELTA * 6, MAP_WIDTH - ROW_ONE - ROW_DELTA * 1));
        cellList.add(8, new Cell(8, COLUMN_ONE + COLUMN_DELTA * 5, MAP_WIDTH - ROW_ONE - ROW_DELTA * 1));
        cellList.add(9, new Cell(9, COLUMN_ONE + COLUMN_DELTA * 4, MAP_WIDTH - ROW_ONE - ROW_DELTA * 1));
        cellList.add(10, new Cell(10, COLUMN_ONE + COLUMN_DELTA * 3, MAP_WIDTH - ROW_ONE - ROW_DELTA * 1));
        cellList.add(11, new Cell(11, COLUMN_ONE + COLUMN_DELTA * 2, MAP_WIDTH - ROW_ONE - ROW_DELTA * 1));
        cellList.add(12, new Cell(12, COLUMN_ONE + COLUMN_DELTA * 1, MAP_WIDTH - ROW_ONE - ROW_DELTA * 1));
        cellList.add(13, new Cell(13, COLUMN_ONE + COLUMN_DELTA * 0, MAP_WIDTH - ROW_ONE - ROW_DELTA * 1));

        // line 3
        cellList.add(14, new Cell(14, COLUMN_ONE + COLUMN_DELTA * 0, MAP_WIDTH - ROW_ONE - ROW_DELTA * 2));
        cellList.add(15, new Cell(15, COLUMN_ONE + COLUMN_DELTA * 1, MAP_WIDTH - ROW_ONE - ROW_DELTA * 2));
        cellList.add(16, new Cell(16, COLUMN_ONE + COLUMN_DELTA * 2, MAP_WIDTH - ROW_ONE - ROW_DELTA * 2));
        cellList.add(17, new Cell(17, COLUMN_ONE + COLUMN_DELTA * 3, MAP_WIDTH - ROW_ONE - ROW_DELTA * 2));
        cellList.add(18, new Cell(18, COLUMN_ONE + COLUMN_DELTA * 4, MAP_WIDTH - ROW_ONE - ROW_DELTA * 2));
        cellList.add(19, new Cell(19, COLUMN_ONE + COLUMN_DELTA * 5, MAP_WIDTH - ROW_ONE - ROW_DELTA * 2));
        cellList.add(20, new Cell(20, COLUMN_ONE + COLUMN_DELTA * 6, MAP_WIDTH - ROW_ONE - ROW_DELTA * 2));
        cellList.add(21, new Cell(21, COLUMN_ONE + COLUMN_DELTA * 7, MAP_WIDTH - ROW_ONE - ROW_DELTA * 2));
        cellList.add(22, new Cell(22, COLUMN_ONE + COLUMN_DELTA * 8, MAP_WIDTH - ROW_ONE - ROW_DELTA * 2));
        cellList.add(23, new Cell(23, COLUMN_ONE + COLUMN_DELTA * 9, MAP_WIDTH - ROW_ONE - ROW_DELTA * 2));

        // line 4
        //cellList.add(24, new Cell(24, COLUMN_ONE + COLUMN_DELTA * 3, MAP_WIDTH - ROW_ONE - ROW_DELTA * 1));
        //cellList.add(25, new Cell(25, COLUMN_ONE + COLUMN_DELTA * 2, MAP_WIDTH - ROW_ONE - ROW_DELTA * 1));
        //cellList.add(26, new Cell(26, COLUMN_ONE + COLUMN_DELTA * 1, MAP_WIDTH - ROW_ONE - ROW_DELTA * 1));
        //cellList.add(27, new Cell(27, COLUMN_ONE + COLUMN_DELTA * 0, MAP_WIDTH - ROW_ONE - ROW_DELTA * 1));

    }

    @Override
    public String getMapFileName() {
        return fileName;
    }

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

    @Override
    public int getMaxPositionIndex() {
        return cellList.size() - 1;
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
        return cellList.get(indexOnMapPosition).getCenterX();
    }

    @Override
    public int getCenterCellY(int indexOnMapPosition) {
        return cellList.get(indexOnMapPosition).getCenterY();
    }
}
