package me.ihaq.pacman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import me.ihaq.pacman.menu.Game;
import me.ihaq.pacman.menu.HowToPlayMenu;
import me.ihaq.pacman.menu.MainMenu;

public class Main extends ApplicationAdapter {
	private MainMenu MENU;
	private HowToPlayMenu HOWTOPLAY;
	private Game GAME;
	private boolean clicked;
	public static STATE state;

	public enum STATE {
		MENU, GAME, OPTIONS, HOWTOPLAY
	}

	@Override
	public void create() {
		MENU = new MainMenu();
		HOWTOPLAY = new HowToPlayMenu();
		state = STATE.MENU;
	}

	@Override
	public void render() {
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			state = STATE.MENU;
			clicked = false;
		}
		if (state == STATE.MENU) {
			MENU.render();
		} else if (state == STATE.HOWTOPLAY) {
			HOWTOPLAY.render();
		} else if (state == STATE.GAME && clicked == false) {
			GAME = new Game();
			GAME.render();
			clicked = true;
		}else if (state == STATE.GAME && clicked == true) {
			GAME.render();
		}
	}
}