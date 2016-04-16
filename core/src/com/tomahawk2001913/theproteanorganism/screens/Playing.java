package com.tomahawk2001913.theproteanorganism.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tomahawk2001913.theproteanorganism.TPOMain;
import com.tomahawk2001913.theproteanorganism.map.TileMap;

public class Playing implements Screen {
	private OrthographicCamera camera = TPOMain.camera;
	private SpriteBatch batch = TPOMain.batch;	
	
	private TileMap map;
	
	public Playing(int[][] map) {
		this.map = TileMap.convertMapArray(map);
	}
	
	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		// Renders
		batch.begin();
		
		map.render(batch);
		
		batch.end();
		
		// Updates
		map.update(delta);
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
