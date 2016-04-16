package com.tomahawk2001913.theproteanorganism.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.tomahawk2001913.theproteanorganism.TPOMain;
import com.tomahawk2001913.theproteanorganism.io.PlayingInputHandler;
import com.tomahawk2001913.theproteanorganism.map.TileMap;
import com.tomahawk2001913.theproteanorganism.organisms.Organisms;
import com.tomahawk2001913.theproteanorganism.organisms.Player;

public class Playing implements Screen {
	private OrthographicCamera camera = TPOMain.camera;
	private SpriteBatch batch = TPOMain.batch;	
	
	private TileMap map;
	
	private Player player;
	
	// Constants
	public static final float MAX_DELTA = 0.15f;
	
	public Playing(int[][] map) {
		this.map = TileMap.convertMapArray(map);
	}
	
	@Override
	public void show() {
		player = new Player(new Vector2(0, 0), Organisms.HUMAN, map);
		map.addOrganism(player);
		
		Gdx.input.setInputProcessor(new PlayingInputHandler(player));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(delta >= MAX_DELTA) delta = MAX_DELTA;
		
		// Renders
		batch.begin();
		
		map.render(batch);
		
		batch.end();
		
		// Updates
		map.update(delta);
		camera.position.set(player.getLocation().x + 18, player.getLocation().y + 32, 0);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}
}
