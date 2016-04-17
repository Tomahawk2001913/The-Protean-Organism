package com.tomahawk2001913.theproteanorganism.organisms;

import com.badlogic.gdx.math.Vector2;
import com.tomahawk2001913.theproteanorganism.map.TileMap;

public class Player extends Organism {
	private boolean ignoreStopRight = true, ignoreStopLeft = true;
	
	public Player(Vector2 location, Organisms type, TileMap map) {
		super(location, type, map);
	}
	
	public void moveRight() {
		getVelocity().x += getType().getSpeed();
		ignoreStopRight = false;
	}
	
	public void stopMovingRight() {
		if(!ignoreStopRight) getVelocity().x -= getType().getSpeed();
		else ignoreStopRight = false;
	}
	
	public void moveLeft() {
		getVelocity().x -= getType().getSpeed();
		ignoreStopLeft = false;
	}
	
	public void stopMovingLeft() {
		if(!ignoreStopLeft) getVelocity().x += getType().getSpeed();
		else ignoreStopLeft = false;
	}
	
	public void jump() {
		if(isOnGround() || getType().canFly()) getVelocity().y = -getType().getSpeed() * 10;
	}
	
	public void shiftDown() {
		for(int i = Organisms.values().length - 1; i >= 0; i--) {
			Organisms organism = Organisms.values()[i];
			if(organism.ordinal() < getType().ordinal() && organism.isUnlocked()) {
				if(getVelocity().x > 0) ignoreStopRight = true;
				else if(getVelocity().x < 0) ignoreStopLeft = true;
				getVelocity().x = 0;
				changeType(organism);
				break;
			}
		}
	}
	
	public void shiftUp() {
		for(Organisms organism : Organisms.values()) {
			if(organism.ordinal() > getType().ordinal() && organism.isUnlocked()) {
				if(getVelocity().x > 0) ignoreStopRight = true;
				else if(getVelocity().x < 0) ignoreStopLeft = true;
				getVelocity().x = 0;
				changeType(organism);
				break;
			}
		}
	}
}