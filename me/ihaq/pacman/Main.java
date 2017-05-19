package me.ihaq.pacman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import me.ihaq.pacman.menu.Game;
import me.ihaq.pacman.menu.HowToPlayMenu;
import me.ihaq.pacman.menu.MainMenu;

public class Main extends ApplicationAdapter {
	public MainMenu menu;
	public HowToPlayMenu howToPlayMenu;
	public Game game;
	public static STATE state;

	public enum STATE {
		MENU, GAME, OPTIONS, HOWTOPLAY
	}

	@Override
	public void create() {
		menu = new MainMenu();
		howToPlayMenu = new HowToPlayMenu();
		game = new Game();
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
		else if (state == STATE.HOWTOPLAY) {
			howToPlayMenu.render();
		}
		else if (state == STATE.GAME) {
			game.render();
		}
	}
}