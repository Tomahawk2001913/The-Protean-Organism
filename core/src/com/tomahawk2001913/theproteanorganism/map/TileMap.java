package com.tomahawk2001913.theproteanorganism.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileMap {
	private Tiles[][] tiles;
	
	// Constants
	public static final float TILE_DIMENSION = 64;
	
	public TileMap(Tiles[][] tiles) {
		this.tiles = tiles;
	}
	
	public void render(SpriteBatch batch) {
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				if(tiles[x][y].getTextureRegion() != null) {
					batch.draw(tiles[x][y].getTextureRegion(), x * TILE_DIMENSION, y * TILE_DIMENSION, TILE_DIMENSION, TILE_DIMENSION);
				}
			}
		}
	}
	
	public void update(float delta) {
		// Nothing yet...
	}
	
	public static TileMap convertMapArray(int[][] array) {
		Tiles[][] tiles = new Tiles[array[0].length][array.length];
		
		for(int x = 0; x < array[0].length; x++) {
			for(int y = 0; y < array.length; y++) {
				tiles[x][y] = Tiles.values()[array[y][x]];
			}
		}
		
		return new TileMap(tiles);
	}
}
