package com.tomahawk2001913.theproteanorganism.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.tomahawk2001913.theproteanorganism.organisms.Player;

public class PlayingInputHandler implements InputProcessor {
	private Player player;
	
	private boolean fullscreen = false;
	
	public PlayingInputHandler(Player player) {
		this.player = player;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.ESCAPE) {
			Gdx.app.exit();
			return true;
		} else if(keycode == Keys.F11) {
			if(fullscreen) {
				Gdx.graphics.setWindowedMode(800, 600);
				fullscreen = false;
			} else {
				Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
				fullscreen = true;
			}
		} else if(keycode == Keys.A || keycode == Keys.LEFT) {
			player.moveLeft();
			return true;
		} else if(keycode == Keys.D || keycode == Keys.RIGHT) {
			player.moveRight();
			return true;
		} else if(keycode == Keys.SPACE) {
			player.jump();
			return true;
		} else if(keycode == Keys.W || keycode == Keys.UP) {
			player.shiftUp();
			return true;
		} else if(keycode == Keys.S || keycode == Keys.DOWN) {
			player.shiftDown();
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
