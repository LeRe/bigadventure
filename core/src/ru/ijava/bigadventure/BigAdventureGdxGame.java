package ru.ijava.bigadventure;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;

import ru.ijava.bigadventure.actors.Fishka;
import ru.ijava.bigadventure.actors.FishkaColor;
import ru.ijava.bigadventure.actors.GameDie;
import ru.ijava.bigadventure.actors.MainStage;
import ru.ijava.bigadventure.ifaces.GestureWaiter;
import ru.ijava.bigadventure.ifaces.GameMap;
import ru.ijava.bigadventure.maps.SpaceMap;

public class BigAdventureGdxGame extends ApplicationAdapter {
	private Stage gameStage;
	private Stage inputStage;

	@Override
	public void create () {
		GameMap map = new SpaceMap();

		GameDie die = new GameDie();

		gameStage = new MainStage(map.getMapWidth(), map.getMapHeight());
		inputStage = new Stage(new FillViewport(die.getViewportSize(), die.getViewportSize()));

		//Когда понадобиться два и более InputProcessor незабываем про InputMultiplexer
		BigAdvGestureListener gestureListener = new BigAdvGestureListener();
		gestureListener.addWaiter((GestureWaiter) gameStage);
		Gdx.input.setInputProcessor(new GestureDetector(gestureListener));

		gameStage.addActor(map.getMapActor());
		gameStage.addActor(new Fishka(FishkaColor.RED, map));
		gameStage.addActor(new Fishka(FishkaColor.GREEN, map));
		gameStage.addActor(new Fishka(FishkaColor.BLUE, map));
		gameStage.addActor(new Fishka(FishkaColor.YELLOW, map));

		inputStage.addActor(die);
		die.setVisible(true);
	}

	@Override
	public void resize(int width, int height) {
		gameStage.getViewport().update(width, height, true);
		inputStage.getViewport().update(width, height, true);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gameStage.act();
		inputStage.act();

		gameStage.getViewport().apply();
		gameStage.draw();

		inputStage.getViewport().apply();
		inputStage.draw();
	}

	
	@Override
	public void dispose () {
		gameStage.dispose();
		inputStage.dispose();
	}
}