package com.tomahawk2001913.theproteanorganism.map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tomahawk2001913.theproteanorganism.io.AssetHandler;

public enum Tiles {
	AIR(null), DIRT(AssetHandler.dirtTile), GRASS(AssetHandler.grassTile), BARRIERBRICKTILE(AssetHandler.barrierBrickTile);
	
	private TextureRegion img;
	
	private Tiles(TextureRegion region) {
		img = region;
	}
	
	public TextureRegion getTextureRegion() {
		return img;
	}
}