package com.tomahawk2001913.theproteanorganism;

import com.badlogic.gdx.Game;
import com.tomahawk2001913.theproteanorganism.io.AssetHandler;
import com.tomahawk2001913.theproteanorganism.screens.Playing;

public class TPOMain extends Game {
	@Override
	public void create() {
		AssetHandler.create();
		
		setScreen(new Playing(AssetHandler.map));
	}
	
	@Override
	public void dispose() {
		AssetHandler.dispose();
	}
}
