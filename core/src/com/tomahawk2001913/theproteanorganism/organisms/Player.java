package com.tomahawk2001913.theproteanorganism.organisms;

import com.badlogic.gdx.math.Vector2;
import com.tomahawk2001913.theproteanorganism.map.TileMap;

public class Player extends Organism {
	private boolean ignoreStopRight = false, ignoreStopLeft = false;
	
	public Player(Vector2 location, Organisms type, TileMap map) {
		super(location, type, map);
	}
	
	public void moveRight() {
		getVelocity().x += getType().getSpeed();
	}
	
	public void stopMovingRight() {
		if(!ignoreStopRight) getVelocity().x -= getType().getSpeed();
		else ignoreStopRight = false;
	}
	
	public void moveLeft() {
		getVelocity().x -= getType().getSpeed();
	}
	
	public void stopMovingLeft() {
		if(!ignoreStopLeft) getVelocity().x += getType().getSpeed();
		else ignoreStopLeft = false;
	}
	
	public void jump() {
		if(isOnGround() || getType().canFly()) getVelocity().y = -getType().getSpeed() * 10;
	}
	
	public void shiftDown() {
		if(getType().ordinal() > 0 && Organisms.values()[getType().ordinal() - 1].isUnlocked()) {
			changeType(Organisms.values()[getType().ordinal() - 1]);
			if(getVelocity().x > 0) ignoreStopRight = true;
			else if(getVelocity().x < 0) ignoreStopLeft = true;
			getVelocity().x = 0;
		}
	}
	
	public void shiftUp() {
		if(getType().ordinal() < Organisms.values().length && Organisms.values()[getType().ordinal() + 1].isUnlocked()) {
			changeType(Organisms.values()[getType().ordinal() + 1]);
			if(getVelocity().x > 0) ignoreStopRight = true;
			else if(getVelocity().x < 0) ignoreStopLeft = true;
			getVelocity().x = 0;
		}
	}
}