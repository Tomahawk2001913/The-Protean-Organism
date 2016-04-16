package com.tomahawk2001913.theproteanorganism.io;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.tomahawk2001913.theproteanorganism.organisms.Player;

public class PlayingInputHandler implements InputProcessor {
	private Player player;
	
	public PlayingInputHandler(Player player) {
		this.player = player;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.A || keycode == Keys.LEFT) {
			player.moveLeft();
			return true;
		} else if(keycode == Keys.D || keycode == Keys.RIGHT) {
			player.moveRight();
			return true;
		} else if(keycode == Keys.SPACE) {
			player.jump();
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.A || keycode == Keys.LEFT) {
			player.stopMovingLeft();
			return true;
		} else if(keycode == Keys.D || keycode == Keys.RIGHT) {
			player.stopMovingRight();
			return true;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
