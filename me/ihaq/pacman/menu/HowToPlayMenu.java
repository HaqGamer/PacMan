package me.ihaq.pacman.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.PacMan;
import me.ihaq.pacman.PacMan.STATE;

public class HowToPlayMenu {
	SpriteBatch batch;
	Texture img;

	public HowToPlayMenu() {
		batch = new SpriteBatch();
	}

	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(new Texture("howtoplay/howtoplay.png"), 0, 0);
		batch.end();
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
			PacMan.state = STATE.GAME;
		}

	}

}
