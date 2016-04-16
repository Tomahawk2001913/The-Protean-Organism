package com.tomahawk2001913.theproteanorganism.io;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class AssetHandler {
	public static Texture texture;
	
	// Tiles
	public static TextureRegion grassTile, dirtTile;
	
	// Organisms
	public static TextureRegion human1, human2;
	public static Animation humanAnimation;
	
	// Fonts
	public static HashMap<Integer, BitmapFont> fonts;
	
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
		
		fonts = new HashMap<Integer, BitmapFont>();
	}
	
	public static void dispose() {
		texture.dispose();
	}
	
	public static void generateFont(int size) {
		FreeTypeFontGenerator ttfg = new FreeTypeFontGenerator(Gdx.files.internal("Fonts/VCR_OSD_MONO_1.001.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = size;
		parameter.flip = true;
		fonts.put(size, ttfg.generateFont(parameter));
		ttfg.dispose();
	}
	
	public static boolean fontExists(int size) {
		return fonts.containsKey(size);
	}
	
	public static BitmapFont getFont(int size) {
		return fonts.get(size);
	}
}