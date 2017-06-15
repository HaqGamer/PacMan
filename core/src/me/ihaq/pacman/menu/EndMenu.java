package me.ihaq.pacman.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.Main;
import me.ihaq.pacman.Main.STATE;

public class EndMenu {

	private SpriteBatch batch;
	private BitmapFont font;
	private GlyphLayout glyphLayout;

	public EndMenu() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		glyphLayout = new GlyphLayout();
	}

	public void render() {
		Main.MAIN.getMusic().stop();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		glyphLayout.setText(font, "" + Main.GAME.score);
		float width = glyphLayout.width;
		batch.begin();
		batch.draw(new Texture("end/end.png"), 0, 0);
		font.getData().setScale(3F);
		font.draw(batch, "" + Main.GAME.score, (Gdx.graphics.getWidth() / 2) - width / 2, 360);
		batch.end();
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			Main.state = STATE.MAIN;
		} else if (Gdx.input.isKeyPressed(Input.Keys.R)) {
			Main.state = STATE.GAME;
			Main.MAIN.getMusic().play();
		}
		Main.clicked = false;

	}

}
