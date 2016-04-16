package com.tomahawk2001913.theproteanorganism.organisms;

import com.badlogic.gdx.math.Vector2;

public abstract class Organism {
	private Vector2 location;
	private Organisms type;
	
	public Organism(Vector2 location, Organisms type) {
		this.location = location;
		this.type = type;
	}
}
