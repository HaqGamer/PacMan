package me.ihaq.pacman.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.entity.PacMan;

public class Game {

	SpriteBatch batch;
	Texture background;
	PacMan pacMan;
	int rotation;

	int px = 475;
	int py = 150;

	public Game() {
		batch = new SpriteBatch();
		// background = new Texture("bGround.jpg");
		pacMan = new PacMan(new Texture("game/pacman.png"), 475, 150);
	}

	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		// batch.draw(background, 0, 0);

		pacMan.render(batch, px, py);

		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			if ((Gdx.input.isKeyJustPressed(Keys.LEFT))) {
				pacMan.rotate(Keys.LEFT);
			}
			px -= 5;
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if ((Gdx.input.isKeyJustPressed(Keys.RIGHT))) {
				pacMan.rotate(Keys.RIGHT);
			}
			px += 5;
		} else if (Gdx.input.isKeyPressed(Keys.UP)) {
			if ((Gdx.input.isKeyJustPressed(Keys.UP))) {
				pacMan.rotate(Keys.UP);
			}
			py += 5;
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			if ((Gdx.input.isKeyJustPressed(Keys.DOWN))) {
				pacMan.rotate(Keys.DOWN);
			}
			py -= 5;
		}

		batch.end();
	}

}
