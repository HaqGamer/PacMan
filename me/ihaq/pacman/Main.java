package me.ihaq.pacman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import me.ihaq.pacman.menu.EndMenu;
import me.ihaq.pacman.menu.Game;
import me.ihaq.pacman.menu.HowToPlayMenu;
import me.ihaq.pacman.menu.MainMenu;

public class Main extends ApplicationAdapter {
	private MainMenu MAIN;
	private HowToPlayMenu HOWTOPLAY;
	private Game GAME;
	private EndMenu END;
	public static boolean clicked;
	public static STATE state;

	public enum STATE {
		MAIN, GAME, HOWTOPLAY, END
	}

	@Override
	public void create() {
		MAIN = new MainMenu();
		HOWTOPLAY = new HowToPlayMenu();
		END = new EndMenu();
		state = STATE.MAIN;
	}

	@Override
	public void render() {
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			state = STATE.MAIN;
			clicked = false;
		}
		if (state == STATE.MAIN) {
			MAIN.render();
		} else if (state == STATE.HOWTOPLAY) {
			HOWTOPLAY.render();
		} else if (state == STATE.GAME && clicked == false) {
			GAME = new Game();
			GAME.render();
			clicked = true;
		} else if (state == STATE.GAME && clicked == true) {
			GAME.render();
		} else if (state == STATE.END) {
			END.render();
		}
	}
}