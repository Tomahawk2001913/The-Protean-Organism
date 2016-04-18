package com.tomahawk2001913.theproteanorganism.map;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.tomahawk2001913.theproteanorganism.io.AssetHandler;
import com.tomahawk2001913.theproteanorganism.organisms.Coin;
import com.tomahawk2001913.theproteanorganism.organisms.Enemy;
import com.tomahawk2001913.theproteanorganism.organisms.Organism;
import com.tomahawk2001913.theproteanorganism.organisms.Organisms;
import com.tomahawk2001913.theproteanorganism.organisms.Player;
import com.tomahawk2001913.theproteanorganism.organisms.Portal;
import com.tomahawk2001913.theproteanorganism.organisms.RestartPortal;
import com.tomahawk2001913.theproteanorganism.organisms.WinnerPortal;
import com.tomahawk2001913.theproteanorganism.screens.Playing;

public class TileMap {
	private Tiles[][] tiles;
	private List<Organism> organisms, removeOrganisms;
	
	// Constants
	public static final float TILE_DIMENSION = 64, GRAVITY = 9.2f;
	
	public TileMap(Tiles[][] tiles) {
		this.tiles = tiles;
		
		organisms = new ArrayList<Organism>();
		removeOrganisms = new ArrayList<Organism>();
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
			if(organism instanceof Player) {
				for(Organism check : organisms) {
					if(organism.getBounds().overlaps(check.getBounds())) {
						if(check instanceof Enemy) {
							if(check.getType() == Organisms.SPIKES) {
								Playing.setGameOver(true);
								Playing.changeMap(TileMap.convertMapArray(AssetHandler.gameOver));
							} else if(check.getType() == Organisms.RABBITPOISON && organism.getType() == Organisms.RABBIT) {
								Playing.setGameOver(true);
								Playing.changeMap(TileMap.convertMapArray(AssetHandler.gameOver));
							}
						} else if(check instanceof Coin) {
							check.getType().setUnlocked(true);
							removeOrganism(check);
							AssetHandler.coinCollected.play(1.0f);
						} else if(check instanceof Portal) {
							if(check instanceof WinnerPortal) {
								Playing.setWinner(true);
								Playing.changeMap(((Portal) check).getDestination());
							}
							else if(check instanceof RestartPortal) {
								Playing.setWinner(true);
								Playing.setGameOver(true);
							} else {
								Playing.setWinner(false);
								Playing.setGameOver(false);
								
								Playing.changeMap(((Portal) check).getDestination());
							}
						}
					}
				}
			}
		}
		
		for(Organism organism : removeOrganisms) {
			organisms.remove(organism);
		}
	}
	
	public void addOrganism(Organism organism) {
		organisms.add(organism);
	}
	
	public void removeOrganism(Organism organism) {
		removeOrganisms.add(organism);
	}
	
	public void setTiles(Tiles[][] tiles) {
		this.tiles = tiles;
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
		
		TileMap convert = new TileMap(null);
		
		for(int x = 0; x < array[0].length; x++) {
			for(int y = 0; y < array.length; y++) {
				if(array[y][x] == -1)  {
					convert.addOrganism(new Enemy(new Vector2(x * TILE_DIMENSION, y * TILE_DIMENSION), Organisms.SPIKES, convert));
					tiles[x][y] = Tiles.AIR;
				} else if(array[y][x] == -2) {
					convert.addOrganism(new Coin(new Vector2(x * TILE_DIMENSION, y * TILE_DIMENSION), Organisms.RABBIT, convert));
					tiles[x][y] = Tiles.AIR;
				} else if(array[y][x] == -3) {
					convert.addOrganism(new Coin(new Vector2(x * TILE_DIMENSION, y * TILE_DIMENSION), Organisms.CARDINAL, convert));
					tiles[x][y] = Tiles.AIR;
				} else if(array[y][x] == -4) {
					convert.addOrganism(new Portal(new Vector2(x * TILE_DIMENSION, y * TILE_DIMENSION), convertMapArray(AssetHandler.map2)));
					tiles[x][y] = Tiles.AIR;
				} else if(array[y][x] == -5) {
					convert.addOrganism(new Enemy(new Vector2(x * TILE_DIMENSION , y * TILE_DIMENSION + 32), Organisms.RABBITPOISON, convert));
					tiles[x][y] = Tiles.AIR;
				} else if(array[y][x] == -6) {
					convert.addOrganism(new Portal(new Vector2(x * TILE_DIMENSION, y * TILE_DIMENSION), convertMapArray(AssetHandler.map3)));
					tiles[x][y] = Tiles.AIR;
				} else if(array[y][x] == -7) {
					convert.addOrganism(new Portal(new Vector2(x * TILE_DIMENSION, y * TILE_DIMENSION), convertMapArray(AssetHandler.map1)));
					tiles[x][y] = Tiles.AIR;
				} else if(array[y][x] == -8) {
					convert.addOrganism(new Portal(new Vector2(x * TILE_DIMENSION, y * TILE_DIMENSION), convertMapArray(AssetHandler.map3)));
					tiles[x][y] = Tiles.AIR;
				} else if(array[y][x] == -9) {
					convert.addOrganism(new RestartPortal(new Vector2(x * TILE_DIMENSION, y * TILE_DIMENSION), null));
					tiles[x][y] = Tiles.AIR;
				} else if(array[y][x] == -10) {
					convert.addOrganism(new Portal(new Vector2(x * TILE_DIMENSION, y * TILE_DIMENSION), convertMapArray(AssetHandler.map4)));
					tiles[x][y] = Tiles.AIR;
				} else if(array[y][x] == -11) {
					convert.addOrganism(new Portal(new Vector2(x * TILE_DIMENSION, y * TILE_DIMENSION), convertMapArray(AssetHandler.map5)));
					tiles[x][y] = Tiles.AIR;
				} else if(array[y][x] == -12) {
					convert.addOrganism(new WinnerPortal(new Vector2(x * TILE_DIMENSION, y * TILE_DIMENSION), convertMapArray(AssetHandler.winner)));
					tiles[x][y] = Tiles.AIR;
				} else tiles[x][y] = Tiles.values()[array[y][x]];
			}
		}
		
		convert.setTiles(tiles);
		return convert;
	}
}
