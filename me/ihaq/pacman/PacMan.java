package me.ihaq.pacman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import me.ihaq.pacman.menu.MainMenu;

public class PacMan extends ApplicationAdapter {
	MainMenu menu;
	public static STATE state;

	public enum STATE {
		MENU, GAME
	}

	@Override
	public void create() {
		menu = new MainMenu();
		state = STATE.MENU;
	}

	@Override
	public void render() {
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			state = STATE.MENU;
		}
		if (state == STATE.MENU) {
			menu.render();
		}
	}
}