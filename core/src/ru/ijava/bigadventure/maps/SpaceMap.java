package ru.ijava.bigadventure.maps;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.List;

import ru.ijava.bigadventure.ifaces.IGamer;
import ru.ijava.bigadventure.ifaces.GameMap;
import ru.ijava.bigadventure.ifaces.ICell;

/**
 * Created by rele on 3/2/18.
 */

public class SpaceMap extends Actor implements GameMap {

    private final String fileName = "big-space-adventure.jpg";
    private static final int MAP_WIDTH = 3131;
    private static final int MAP_HEIGHT = 2000;

    private List<ICell> cellList;

    private CellForm cellForm = CellForm.RECT;
    private final int CELL_WIDTH = 290;
    private final int CELL_HEIGHT = 180;

    private TextureRegion region;

    public SpaceMap () {
        region = new TextureRegion(new Texture(fileName));
        setX(0);
        setY(0);
        setWidth(MAP_WIDTH);
        setHeight(MAP_HEIGHT);


        final int ROW_ONE = 1858;
        final int COLUMN_ONE = 192;

        final int ROW_DELTA = 192;
        final int COLUMN_DELTA = 306;

        cellList = new ArrayList<ICell>();
        // line 1
        int cellIndex = 0;
        int rowIndex = 0;
        for (int colIndex = 0; colIndex <= 6; colIndex++) {
            cellList.add(cellIndex, new Cell(cellIndex, COLUMN_ONE + COLUMN_DELTA * colIndex, MAP_HEIGHT - ROW_ONE + ROW_DELTA * rowIndex, cellForm, CELL_WIDTH, CELL_HEIGHT));
            cellIndex++;
        }
        rowIndex++;

        // line 2
        for (int colIndex = 6; colIndex >= 0; colIndex--) {
            cellList.add(cellIndex, new Cell(cellIndex, COLUMN_ONE + COLUMN_DELTA * colIndex, MAP_HEIGHT - ROW_ONE + ROW_DELTA * rowIndex, cellForm, CELL_WIDTH, CELL_HEIGHT));
            cellIndex++;
        }
        rowIndex++;

        // line 3
        for (int colIndex = 0; colIndex <= 9; colIndex++) {
            cellList.add(cellIndex, new Cell(cellIndex, COLUMN_ONE + COLUMN_DELTA * colIndex, MAP_HEIGHT - ROW_ONE + ROW_DELTA * rowIndex, cellForm, CELL_WIDTH, CELL_HEIGHT));
            cellIndex++;
        }
        rowIndex++;

        // line 4
        for (int colIndex = 9; colIndex >= 0; colIndex--) {
            cellList.add(cellIndex, new Cell(cellIndex, COLUMN_ONE + COLUMN_DELTA * colIndex, MAP_HEIGHT - ROW_ONE + ROW_DELTA * rowIndex, cellForm, CELL_WIDTH, CELL_HEIGHT));
            cellIndex++;
        }
        rowIndex++;

        //line 5
        for (int colIndex = 0; colIndex <= 9; colIndex++) {
            cellList.add(cellIndex, new Cell(cellIndex, COLUMN_ONE + COLUMN_DELTA * colIndex, MAP_HEIGHT - ROW_ONE + ROW_DELTA * rowIndex, cellForm, CELL_WIDTH, CELL_HEIGHT));
            cellIndex++;
        }
        rowIndex++;

        //line 6
        for (int colIndex = 9; colIndex >= 0; colIndex--) {
            cellList.add(cellIndex, new Cell(cellIndex, COLUMN_ONE + COLUMN_DELTA * colIndex, MAP_HEIGHT - ROW_ONE + ROW_DELTA * rowIndex, cellForm, CELL_WIDTH, CELL_HEIGHT));
            cellIndex++;
        }
        rowIndex++;

        //line 7
        for (int colIndex = 0; colIndex <= 9; colIndex++) {
            cellList.add(cellIndex, new Cell(cellIndex, COLUMN_ONE + COLUMN_DELTA * colIndex, MAP_HEIGHT - ROW_ONE + ROW_DELTA * rowIndex, cellForm, CELL_WIDTH, CELL_HEIGHT));
            cellIndex++;
        }
        rowIndex++;

        //line 8
        for (int colIndex = 9; colIndex >= 0; colIndex--) {
            cellList.add(cellIndex, new Cell(cellIndex, COLUMN_ONE + COLUMN_DELTA * colIndex, MAP_HEIGHT - ROW_ONE + ROW_DELTA * rowIndex, cellForm, CELL_WIDTH, CELL_HEIGHT));
            cellIndex++;
        }
        rowIndex++;

        //line 9
        for (int colIndex = 0; colIndex <= 9; colIndex++) {
            cellList.add(cellIndex, new Cell(cellIndex, COLUMN_ONE + COLUMN_DELTA * colIndex, MAP_HEIGHT - ROW_ONE + ROW_DELTA * rowIndex, cellForm, CELL_WIDTH, CELL_HEIGHT));
            cellIndex++;
        }
        rowIndex++;

        //line 10
        for (int colIndex = 9; colIndex >= 0; colIndex--) {
            cellList.add(cellIndex, new Cell(cellIndex, COLUMN_ONE + COLUMN_DELTA * colIndex, MAP_HEIGHT - ROW_ONE + ROW_DELTA * rowIndex, cellForm, CELL_WIDTH, CELL_HEIGHT));
            cellIndex++;
        }
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
    public Actor getMapAsActor() {
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
    public void putGamerToCell(int indexOnMapPosition, IGamer IGamer) {
        for (ICell cell: cellList) {
            if (cell.contains(IGamer)) {
                cell.remove(IGamer);
                break;
            }
        }
        cellList.get(indexOnMapPosition).put(IGamer);
    }

    @Override
    public int getGamerX(IGamer IGamer) {
        return getCellContainingGamer(IGamer).getGamerX(IGamer);
    }

    @Override
    public int getGamerY(IGamer IGamer) {
        return getCellContainingGamer(IGamer).getGamerY(IGamer);
    }

    private ICell getCellContainingGamer(IGamer IGamer) {
        ICell cellContainingGamer = null;
        for (ICell cell: cellList) {
            if (cell.contains(IGamer)) {
                cellContainingGamer = cell;
                break;
            }
        }

        if ( cellContainingGamer == null ) {
            throw new RuntimeException("Gamer not found");
        }

        return cellContainingGamer;
    }

    @Override
    public void moveGamer(int step, IGamer IGamer) {
        int newPosition = getCurrentPosition(IGamer) + step;

        if (newPosition > getMaxPositionIndex()) {
            newPosition = getMaxPositionIndex();
        }

        putGamerToCell(newPosition, IGamer);
    }

    private int getCurrentPosition(IGamer IGamer) {
        int position = -1;
        for (ICell cell: cellList) {
            if (cell.contains(IGamer)) {
                position = cellList.indexOf(cell);
            }
        }

        if (position == -1) {
            throw new RuntimeException("Gamer not found on board");
        }

        return position;
    }
}
