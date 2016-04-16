package com.tomahawk2001913.theproteanorganism.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileMap {
	private static Tiles[][] tiles;
	
	public TileMap(Tiles[][] tiles) {
		this.tiles = tiles;
	}
	
	public void render(SpriteBatch batch) {
		
	}
	
	public static TileMap convertMapArray(int[][] array) {
		for(int[] x : array) {
			for(int y : x) {
				
			}
		}
		
		return null;
	}
}
