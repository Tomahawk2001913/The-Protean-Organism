package com.tomahawk2001913.theproteanorganism;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tomahawk2001913.theproteanorganism.io.AssetHandler;
import com.tomahawk2001913.theproteanorganism.screens.Playing;

public class TPOMain extends Game {
	public static OrthographicCamera camera;
	public static SpriteBatch batch;
	
	@Override
	public void create() {
		AssetHandler.create();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		
		setScreen(new Playing(AssetHandler.map1));
	}
	
	@Override
	public void dispose() {
		AssetHandler.dispose();
	}
}
