package com.tomahawk2001913.theproteanorganism.organisms;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tomahawk2001913.theproteanorganism.io.AssetHandler;

public enum Organisms {
	HUMAN(AssetHandler.human1, AssetHandler.humanAnimation, null, 36, 64, 90, true, false, true), 
	CARDINAL(AssetHandler.cardinal1, AssetHandler.cardinalAnimation, AssetHandler.chirp, 48, 48, 100, true, true, false), 
	RABBIT(AssetHandler.rabbit1, AssetHandler.rabbitAnimation, null, 64, 32, 120, true, false, false), 
	SPIKES(AssetHandler.spikes, null, null, 64, 32, 0, false, false, false);
	
	private TextureRegion standing;
	private Animation moving;
	private Sound noise;
	private float width, height, speed;
	private boolean gravity, fly, unlocked;
	
	private Organisms(TextureRegion standing, Animation moving, Sound noise, float width, float height, float speed, boolean gravity, boolean flies, boolean unlocked) {
		this.standing = standing;
		this.moving = moving;
		this.noise = noise;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.gravity = gravity;
		fly = flies;
		this.unlocked = unlocked;
	}
	
	public TextureRegion getStandingTextureRegion() {
		return standing;
	}
	
	public Animation getMovingAnimation() {
		return moving;
	}
	
	public Sound getNoise() {
		return noise;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public boolean useGravity() {
		return gravity;
	}
	
	public boolean canFly() {
		return fly;
	}
	
	public boolean isUnlocked() {
		return unlocked;
	}
	
	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}
}