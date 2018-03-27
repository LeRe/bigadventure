package ru.ijava.bigadventure;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;

import java.util.ArrayList;
import java.util.List;

import ru.ijava.bigadventure.actors.Gamer;
import ru.ijava.bigadventure.actors.GamerColor;
import ru.ijava.bigadventure.actors.GameDie;
import ru.ijava.bigadventure.actors.Board;
import ru.ijava.bigadventure.ifaces.IGamer;
import ru.ijava.bigadventure.ifaces.GestureListener;
import ru.ijava.bigadventure.ifaces.GameMap;
import ru.ijava.bigadventure.maps.SpaceMap;

public class BigAdventureGdxGame extends ApplicationAdapter {
	private Stage gameStage;
	private Stage inputStage;

	private GameRound gameRound;

	@Override
	public void create () {
		GameMap map = new SpaceMap();

		GameDie die = new GameDie();

		gameStage = new Board(map.getMapWidth(), map.getMapHeight());
		inputStage = new Stage(new FillViewport(die.getViewportSize(), die.getViewportSize()));

		//Когда понадобиться два и более InputProcessor незабываем про InputMultiplexer
		BigAdvGestureListener gestureListener = new BigAdvGestureListener();
		gestureListener.addWaiter((GestureListener) gameStage);
		Gdx.input.setInputProcessor(new GestureDetector(gestureListener));

		gameStage.addActor(map.getMapAsActor());

		List<IGamer> gamerList = new ArrayList<IGamer>();
		gamerList.add((IGamer) (new Gamer(GamerColor.RED, map)));
		gamerList.add((IGamer) (new Gamer(GamerColor.GREEN, map)));
		gamerList.add((IGamer) (new Gamer(GamerColor.BLUE, map)));
		gamerList.add((IGamer) (new Gamer(GamerColor.YELLOW, map)));

		for (IGamer fishka: gamerList) {
			gameStage.addActor((Actor) fishka);
		}

		inputStage.addActor(die);
		die.setVisible(true);

		gameRound = new GameRound(map, gamerList);
	}

	@Override
	public void resize(int width, int height) {
		gameStage.getViewport().update(width, height, true);
		inputStage.getViewport().update(width, height, true);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gameRound.act();

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