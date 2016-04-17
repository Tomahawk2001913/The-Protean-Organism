package com.tomahawk2001913.theproteanorganism.io;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
	public static TextureRegion grassTile, dirtTile, barrierBrickTile;
	
	// Organisms
	public static TextureRegion human1, human2, spikes, cardinal1, cardinal2, rabbit1, rabbit2, portal, rabbitPoison;
	public static Animation humanAnimation, cardinalAnimation, rabbitAnimation;
	
	// Coin
	public static TextureRegion coin1, coin2;
	public static Animation coinAnimation;
	
	// Music
	public static Music music;
	
	// Sounds
	public static Sound coinCollected, chirp;
	
	// Fonts
	public static HashMap<Integer, BitmapFont> fonts;
	
	public static int[][] gameOver = {
			{3, 3, 3, 3, 3, 3, 3},
			{3, 0, 0, 0, 0, 0, 3},
			{3, 0, 0, 0, 0, -7, 3},
			{3, 2, 2, 2, 2, 2, 3},
			{3, 1, 1, 1, 1, 1, 3},
			{3, 3, 3, 3, 3, 3, 3}
	}, winner = {
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -9, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
			{3, 0, 0, 2, 2, 2, 0, 0, 2, 2, 0, 0, 3},
			{3, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
			{3, 0, 0, -2, 0, 0, 0, 0, 0, -3, 0, 0, 3},
			{3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
	}, map1 = {
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 3},
			{3, 0, 0, 0, -3, 0, 0, 0, 0, 0, 1, 1, 3},
			{3, 0, 0, 2, 2, 2, 0, 0, 0, 0, -1, -4, 3},
			{3, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
	}, map2 = {
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
			{3, 2, 2, 2, 2, 0, 0, 0, 2, 2, 2, 2, 2, 3},
			{3, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 3},
			{3, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 3},
			{3, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 3},
			{3, 1, -2, 0, -5, 0, 0, 0, -1, 0, 0, 0, 1, 3},
			{3, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 3},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 3},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 3},
			{3, 1, -3, -5, 0, 0, -1, 0, 0, -5, 0, 0, 1, 3},
			{3, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 3},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
	}, map3 = {
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, 0, 0, 0, 0, -1, -1, -1, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 3},
			{3, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, 0, 0, 2, 2, 1, 3},
			{3, 0, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -10, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 1, 1, 3},
			{3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 3},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
	}, map4 = {
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
			{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
			{3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
	};
	
	public static void create() {
		texture = new Texture(Gdx.files.internal("Textures/Texture.png"));
		
		grassTile = new TextureRegion(texture, 0, 0, 32, 32);
		grassTile.flip(false, true);
		
		dirtTile = new TextureRegion(texture, 32, 0, 32, 32);
		dirtTile.flip(false, true);
		
		barrierBrickTile = new TextureRegion(texture, 64, 0, 32, 32);
		barrierBrickTile.flip(false, true);
		
		human1 = new TextureRegion(texture, 0, 32, 18, 32);
		human1.flip(false, true);
		
		human2 = new TextureRegion(texture, 18, 32, 18, 32);
		human2.flip(false, true);
		
		humanAnimation = new Animation(0.15f, new TextureRegion[] {human1, human2});
		humanAnimation.setPlayMode(PlayMode.LOOP);
		
		spikes = new TextureRegion(texture, 36, 32, 32, 16);
		spikes.flip(false, true);
		
		cardinal1 = new TextureRegion(texture, 100, 32, 32, 32);
		cardinal1.flip(false, true);
		
		cardinal2 = new TextureRegion(texture, 132, 32, 32, 32);
		cardinal2.flip(false, true);
		
		cardinalAnimation = new Animation(0.1f, new TextureRegion[] {cardinal1, cardinal2});
		cardinalAnimation.setPlayMode(PlayMode.LOOP);
		
		rabbit1 = new TextureRegion(texture, 68, 32, 32, 16);
		rabbit1.flip(false, true);
		
		rabbit2 = new TextureRegion(texture, 68, 48, 32, 16);
		rabbit2.flip(false, true);
		
		rabbitAnimation = new Animation(0.1f, new TextureRegion[] {rabbit1, rabbit2});
		rabbitAnimation.setPlayMode(PlayMode.LOOP);
		
		portal = new TextureRegion(texture, 64, 64, 32, 32);
		portal.flip(false, true);
		
		rabbitPoison = new TextureRegion(texture, 96, 80, 32, 16);
		rabbitPoison.flip(false, true);
		
		coin1 = new TextureRegion(texture, 0, 64, 32, 32);
		coin1.flip(false, true);
		
		coin2 = new TextureRegion(texture, 32, 64, 32, 32);
		coin2.flip(false, true);
		
		coinAnimation = new Animation(0.25f, new TextureRegion[] {coin1, coin2});
		coinAnimation.setPlayMode(PlayMode.LOOP);
		
		music = Gdx.audio.newMusic(Gdx.files.internal("Music/theproteanorganismloopfromaudiotool.ogg"));
		music.setLooping(true);
		music.setVolume(0.35f);
		music.play();
		
		coinCollected = Gdx.audio.newSound(Gdx.files.internal("Sounds/coincollect.wav"));
		
		chirp = Gdx.audio.newSound(Gdx.files.internal("Sounds/chirp.wav"));
		
		fonts = new HashMap<Integer, BitmapFont>();
	}
	
	public static void dispose() {
		texture.dispose();
		music.dispose();
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