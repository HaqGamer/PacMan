package me.ihaq.pacman.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.Main;
import me.ihaq.pacman.Main.STATE;

public class HowToPlayMenu {

	private SpriteBatch batch;

	/*
	 * Constructor for the HowToPlayMenu class. 
	 * This is pretty much the same thing as the create() method in the Main.java class.
	 */
	public HowToPlayMenu() {
		batch = new SpriteBatch();
	}

	/*
	 * Renders everything for the menu.
	 * If you press ENTER it continues to the game.
	 */
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(new Texture("howtoplay/howtoplay.png"), 0, 0);
		batch.end();
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			Main.state = STATE.GAME;
		}

	}

}
