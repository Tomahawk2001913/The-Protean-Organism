package com.tomahawk2001913.theproteanorganism.organisms;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.tomahawk2001913.theproteanorganism.io.AssetHandler;
import com.tomahawk2001913.theproteanorganism.map.TileMap;

public class Coin extends Organism {
	private Organisms type;
	private Animation animation;
	
	private float time;
	
	public Coin(Vector2 location, Organisms type, TileMap map) {
		super(location, null, map);
		
		this.type = type;
		
		animation = AssetHandler.coinAnimation;
		
		getBounds().set(location.x, location.y, TileMap.TILE_DIMENSION, TileMap.TILE_DIMENSION);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(animation.getKeyFrame(time), getLocation().x, getLocation().y, TileMap.TILE_DIMENSION, TileMap.TILE_DIMENSION);
	}
	
	@Override
	public void update(float delta) {
		time += delta;
	}
	
	@Override
	public Organisms getType() {
		return type;
	}
}