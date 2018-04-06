package ru.ijava.bigadventure;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import ru.ijava.bigadventure.actors.Gamer;
import ru.ijava.bigadventure.actors.GamerColor;
import ru.ijava.bigadventure.actors.GameDie;
import ru.ijava.bigadventure.actors.Board;
import ru.ijava.bigadventure.ifaces.GestureListener;
import ru.ijava.bigadventure.ifaces.GameMap;
import ru.ijava.bigadventure.maps.SpaceMap;

public class BigAdventureGdxGame extends ApplicationAdapter {
	private Stage gameBoard;
	private Stage inputStage;

	@Override
	public void create () {
		GameMap map = new SpaceMap();
		GameDie die = new GameDie();

		gameBoard = new Board(map);
		inputStage = new Stage(new FillViewport(die.getViewportSize(), die.getViewportSize()));

		//Когда понадобиться два и более InputProcessor незабываем про InputMultiplexer
		BigAdvGestureListener gestureListener = new BigAdvGestureListener();
		gestureListener.addWaiter((GestureListener) gameBoard);
		Gdx.input.setInputProcessor(new GestureDetector(gestureListener));

		gameBoard.addActor(map.getMapAsActor());
		gameBoard.addActor(new Gamer(GamerColor.RED, map));
		gameBoard.addActor(new Gamer(GamerColor.GREEN, map));
		gameBoard.addActor(new Gamer(GamerColor.BLUE, map));
		gameBoard.addActor(new Gamer(GamerColor.YELLOW, map));

		inputStage.addActor(die);
		die.setVisible(true);
	}

	@Override
	public void resize(int width, int height) {
		gameBoard.getViewport().update(width, height, true);
		inputStage.getViewport().update(width, height, true);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gameBoard.act();
		inputStage.act();

		gameBoard.getViewport().apply();
		gameBoard.draw();

		inputStage.getViewport().apply();
		inputStage.draw();
	}

	
	@Override
	public void dispose () {
		gameBoard.dispose();
		inputStage.dispose();
	}
}