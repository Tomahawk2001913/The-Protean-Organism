package com.tomahawk2001913.theproteanorganism.organisms;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.tomahawk2001913.theproteanorganism.io.AssetHandler;
import com.tomahawk2001913.theproteanorganism.map.TileMap;

public class Portal extends Organism {
	private TileMap destination;
	private TextureRegion img;
	
	public Portal(Vector2 location, TileMap destination) {
		super(location, null, null);
		img = AssetHandler.portal;
		
		this.destination = destination;
		
		getBounds().set(getLocation().x, getLocation().y, TileMap.TILE_DIMENSION, TileMap.TILE_DIMENSION);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(img, getLocation().x, getLocation().y, TileMap.TILE_DIMENSION, TileMap.TILE_DIMENSION);
	}
	
	@Override
	public void update(float delta) {
		
	}
	
	public TileMap getDestination() {
		return destination;
	}
}