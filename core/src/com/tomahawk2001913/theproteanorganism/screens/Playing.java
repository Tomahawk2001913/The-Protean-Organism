package com.tomahawk2001913.theproteanorganism.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.tomahawk2001913.theproteanorganism.TPOMain;
import com.tomahawk2001913.theproteanorganism.io.AssetHandler;
import com.tomahawk2001913.theproteanorganism.io.PlayingInputHandler;
import com.tomahawk2001913.theproteanorganism.map.TileMap;
import com.tomahawk2001913.theproteanorganism.organisms.Organisms;
import com.tomahawk2001913.theproteanorganism.organisms.Player;

public class Playing implements Screen {
	private OrthographicCamera camera = TPOMain.camera;
	private SpriteBatch batch = TPOMain.batch;	
	
	private static TileMap map;
	private static boolean mapChanged = false;
	
	private Player player;
	
	// Constants
	public static final float MAX_DELTA = 0.1f;
	
	public Playing(int[][] map) {
		Playing.map = TileMap.convertMapArray(map);
	}
	
	@Override
	public void show() {
		player = new Player(new Vector2(TileMap.TILE_DIMENSION, TileMap.TILE_DIMENSION), Organisms.HUMAN, map);
		map.addOrganism(player);
		
		if(!AssetHandler.fontExists(20)) AssetHandler.generateFont(20);
		
		Gdx.input.setInputProcessor(new PlayingInputHandler(player));
		
		for(Organisms organism : Organisms.values()) if(organism != Organisms.HUMAN) organism.setUnlocked(false);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(delta >= MAX_DELTA) delta = MAX_DELTA;
		
		if(mapChanged) {
			mapChanged = false;
			show();
		}
		
		// Renders
		batch.begin();
		
		map.render(batch);
		
		AssetHandler.getFont(20).draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 0, 0);
		AssetHandler.getFont(20).draw(batch, "Unlocked shifts:", camera.position.x + 4 - camera.viewportWidth / 2, camera.position.y + 4 - camera.viewportHeight / 2);
		
		for(int i = 0; i < Organisms.values().length; i++) {
			if(Organisms.values()[i].isUnlocked()) AssetHandler.getFont(20).draw(batch, Organisms.values()[i].toString(), camera.position.x + 4 - camera.viewportWidth / 2, camera.position.y + 20 + 20 * i - camera.viewportHeight / 2);
		}
		
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
	
	public static void changeMap(TileMap map) {
		Playing.map = map;
		mapChanged = true;
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
