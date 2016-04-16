package com.tomahawk2001913.theproteanorganism.organisms;

import com.badlogic.gdx.math.Vector2;
import com.tomahawk2001913.theproteanorganism.map.TileMap;

public class Player extends Organism {
	public Player(Vector2 location, Organisms type, TileMap map) {
		super(location, type, map);
	}
	
	public void moveRight() {
		getVelocity().x += getType().getSpeed();
	}
	
	public void stopMovingRight() {
		getVelocity().x -= getType().getSpeed();
	}
	
	public void moveLeft() {
		getVelocity().x -= getType().getSpeed();
	}
	
	public void stopMovingLeft() {
		getVelocity().x += getType().getSpeed();
	}
	
	public void jump() {
		getVelocity().y = -getType().getSpeed() * 10;
	}
}