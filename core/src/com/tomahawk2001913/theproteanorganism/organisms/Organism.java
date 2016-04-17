package com.tomahawk2001913.theproteanorganism.organisms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.tomahawk2001913.theproteanorganism.map.TileMap;
import com.tomahawk2001913.theproteanorganism.map.Tiles;

public abstract class Organism {
	private Vector2 location, velocity;
	private Organisms type;
	private Rectangle bounds;
	private TileMap tm;
	
	private float time = 0;
	private boolean onGround = false;
	
	// Constants
	public static final float TERMINAL_VELOCITY = 300.0f;
	
	public Organism(Vector2 location, Organisms type, TileMap map) {
		bounds = new Rectangle();
		
		this.location = location;
		changeType(type);
		
		tm = map;
		
		velocity = new Vector2(0, 0);
	}
	
	public void render(SpriteBatch batch) {
		if(velocity.x == 0 && onGround || type.getMovingAnimation() == null) batch.draw(type.getStandingTextureRegion(), location.x, location.y, type.getWidth(), type.getHeight());
		else batch.draw(type.getMovingAnimation().getKeyFrame(time), location.x, location.y, type.getWidth(), type.getHeight());
	}
	
	public void update(float delta) {
		time += delta;
		
		if(time % 7 < 0.1f && type.getNoise() != null) {
			type.getNoise().stop();
			type.getNoise().play(0.8f);
		}
		
		if(type.useGravity()) velocity.y += TileMap.GRAVITY;
		
		// Keep things from going too fast.
		if(velocity.x > TERMINAL_VELOCITY) velocity.x = TERMINAL_VELOCITY;
		else if(velocity.x < -TERMINAL_VELOCITY) velocity.x = -TERMINAL_VELOCITY;
		if(velocity.y > TERMINAL_VELOCITY) velocity.y = TERMINAL_VELOCITY;
		else if(velocity.y < -TERMINAL_VELOCITY) velocity.y = -TERMINAL_VELOCITY;
		
		location.add(velocity.x * delta, velocity.y * delta);
		bounds.set(location.x, location.y, type.getWidth(), type.getHeight());
		
		if(velocity.y < 0) onGround = false;
		
		for(int x = -1; x < 2; x++) {
			for(int y = -1; y < 2; y++) {
				Tiles tile = tm.getTile((int) (location.x / TileMap.TILE_DIMENSION) + x, (int) (location.y / TileMap.TILE_DIMENSION + y));
				if(tile == null || tile == Tiles.AIR) continue;
				
				Rectangle tileBounds = new Rectangle(((int) (location.x / TileMap.TILE_DIMENSION) + x) * TileMap.TILE_DIMENSION, ((int) (location.y / TileMap.TILE_DIMENSION + y)) * TileMap.TILE_DIMENSION, TileMap.TILE_DIMENSION, TileMap.TILE_DIMENSION);
				if(bounds.overlaps(tileBounds)) {
					if(!(x == 0 && y == 0) && tileBounds.x > bounds.x && bounds.x + type.getWidth() > tileBounds.x && bounds.x + type.getWidth() < tileBounds.x + tileBounds.width && (int) (bounds.y / TileMap.TILE_DIMENSION) == (int) (tileBounds.y / TileMap.TILE_DIMENSION)) {
						location.set(tileBounds.x - type.getWidth(), location.y);
						bounds.set(location.x, location.y, type.getWidth(), type.getHeight());
					} else if(bounds.x > tileBounds.x && tileBounds.x + tileBounds.width > bounds.x && (int) (bounds.y / TileMap.TILE_DIMENSION) == (int) (tileBounds.y / TileMap.TILE_DIMENSION)) {
						location.set(tileBounds.x + tileBounds.width, location.y);
						bounds.set(location.x, location.y, type.getWidth(), type.getHeight());
					}
					
					if(tileBounds.y > bounds.y && bounds.y + type.getHeight() > tileBounds.y) {
						location.set(location.x, tileBounds.y - type.getHeight());
						bounds.set(location.x, location.y, type.getWidth(), type.getHeight());
						onGround = true;
					} else if(bounds.y < tileBounds.y + tileBounds.height && Math.abs(bounds.y - tileBounds.y) > 32 && (int) (bounds.x / TileMap.TILE_DIMENSION) <= (int) (tileBounds.x / TileMap.TILE_DIMENSION)) {
						location.set(location.x, tileBounds.y + tileBounds.height);
						bounds.set(location.x, location.y, type.getWidth(), type.getHeight());
						velocity.y = 0;
					}
				}
			}
		}
	}
	
	public void changeType(Organisms type) {
		this.type = type;
		if(type != null) bounds.set(location.x, location.y, type.getWidth(), type.getHeight());
	}
	
	public Vector2 getLocation() {
		return location;
	}
	
	public Vector2 getVelocity() {
		return velocity;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public Organisms getType() {
		return type;
	}
	
	public boolean isOnGround() {
		return onGround;
	}
}