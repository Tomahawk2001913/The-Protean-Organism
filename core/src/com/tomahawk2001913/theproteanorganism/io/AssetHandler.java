package com.tomahawk2001913.theproteanorganism.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class AssetHandler {
	public static Texture texture;
	
	// Tiles
	public static TextureRegion grassTile, dirtTile;
	
	// Organisms
	public static TextureRegion human1, human2;
	public static Animation humanAnimation;
	
	public static int[][] map = {
			{0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0},
			{2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 2},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
	};
	
	public static void create() {
		texture = new Texture(Gdx.files.internal("Textures/Texture.png"));
		
		grassTile = new TextureRegion(texture, 0, 0, 32, 32);
		grassTile.flip(false, true);
		
		dirtTile = new TextureRegion(texture, 32, 0, 32, 32);
		dirtTile.flip(false, true);
		
		human1 = new TextureRegion(texture, 0, 32, 18, 32);
		human1.flip(false, true);
		
		human2 = new TextureRegion(texture, 18, 32, 18, 32);
		human2.flip(false, true);
		
		humanAnimation = new Animation(0.15f, new TextureRegion[] {human1, human2});
		humanAnimation.setPlayMode(PlayMode.LOOP);
	}
	
	public static void dispose() {
		texture.dispose();
	}
}