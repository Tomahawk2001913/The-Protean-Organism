package com.tomahawk2001913.theproteanorganism.map;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tomahawk2001913.theproteanorganism.organisms.Organism;

public class TileMap {
	private Tiles[][] tiles;
	private List<Organism> organisms;
	
	// Constants
	public static final float TILE_DIMENSION = 64, GRAVITY = 9.2f;
	
	public TileMap(Tiles[][] tiles) {
		this.tiles = tiles;
		
		organisms = new ArrayList<Organism>();
	}
	
	public void render(SpriteBatch batch) {
		for(int x = 0; x < tiles.length; x++) {
			for(int y = 0; y < tiles[0].length; y++) {
				if(tiles[x][y].getTextureRegion() != null) {
					batch.draw(tiles[x][y].getTextureRegion(), x * TILE_DIMENSION, y * TILE_DIMENSION, TILE_DIMENSION, TILE_DIMENSION);
				}
			}
		}
		
		for(Organism organism : organisms) {
			organism.render(batch);
		}
	}
	
	public void update(float delta) {
		for(Organism organism : organisms) {
			organism.update(delta);
		}
	}
	
	public void addOrganism(Organism organism) {
		organisms.add(organism);
	}
	
	public Tiles getTile(int x, int y) {
		try {
			return tiles[x][y];
		} catch(ArrayIndexOutOfBoundsException e) {
			return null;
		}
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
