package me.ihaq.pacman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import me.ihaq.pacman.menu.Game;
import me.ihaq.pacman.menu.HowToPlayMenu;
import me.ihaq.pacman.menu.MainMenu;

public class Main extends ApplicationAdapter {
	public MainMenu MENU;
	public HowToPlayMenu HOWTOPLAY;
	public Game GAME;
	public static STATE state;

	public enum STATE {
		MENU, GAME, OPTIONS, HOWTOPLAY
	}

	@Override
	public void create() {
		MENU = new MainMenu();
		HOWTOPLAY = new HowToPlayMenu();
		GAME = new Game();
		state = STATE.MENU;
	}

	@Override
	public void render() {
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			state = STATE.MENU;
		}
		if (state == STATE.MENU) {
			MENU.render();
		}else if(state == STATE.HOWTOPLAY){
			HOWTOPLAY.render();
		}
		else if (state == STATE.GAME) {
			
			GAME.render();
		}
	}
}