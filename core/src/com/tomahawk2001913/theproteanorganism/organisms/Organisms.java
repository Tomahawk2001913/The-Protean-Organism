package com.tomahawk2001913.theproteanorganism.organisms;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tomahawk2001913.theproteanorganism.io.AssetHandler;

public enum Organisms {
	HUMAN(AssetHandler.human1, AssetHandler.humanAnimation, 36, 64, 90), RABBIT(null, null, 0, 0, 0), CARDINAL(null, null, 0, 0, 0);
	
	private TextureRegion standing;
	private Animation moving;
	private float width, height, speed;
	
	private Organisms(TextureRegion standing, Animation moving, float width, float height, float speed) {
		this.standing = standing;
		this.moving = moving;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	public TextureRegion getStandingTextureRegion() {
		return standing;
	}
	
	public Animation getMovingAnimation() {
		return moving;
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
}