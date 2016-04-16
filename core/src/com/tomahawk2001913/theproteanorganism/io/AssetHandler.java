package com.tomahawk2001913.theproteanorganism.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetHandler {
	public static Texture texture;
	
	// Tiles
	public static TextureRegion grassTile, dirtTile;
	
	public static int[][] map = {
			{0, 0, 2, 2, 2, 0, 0},
			{2, 2, 1, 1, 1, 2, 2},
			{1, 1, 1, 1, 1, 1, 1}
	};
	
	public static void create() {
		texture = new Texture(Gdx.files.internal("Textures/Texture.png"));
		
		grassTile = new TextureRegion(texture, 0, 0, 32, 32);
		grassTile.flip(false, true);
		
		dirtTile = new TextureRegion(texture, 32, 0, 32, 32);
		dirtTile.flip(false, true);
	}
	
	public static void dispose() {
		texture.dispose();
	}
}