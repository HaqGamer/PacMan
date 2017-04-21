package me.ihaq.pacman.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.ImageButton;

public class MainMenu {
	SpriteBatch batch;
	Texture img;
	Music music;
	ImageButton play, playHovered, options, optionsHovered, quit, quitHovered;

	public MainMenu() {
		batch = new SpriteBatch();
		music = Gdx.audio.newMusic(Gdx.files.internal("mainmenu/mainmenusong.mp3"));
		play = new ImageButton(new Texture("mainmenu/buttons/play.png"), 335, 363, 312, 105);
		playHovered = new ImageButton(new Texture("mainmenu/buttons/playHOVERED.png"), 335, 363, 312, 105);
		options = new ImageButton(new Texture("mainmenu/buttons/options.png"), 258, 260, 454, 105);
		optionsHovered = new ImageButton(new Texture("mainmenu/buttons/optionsHOVERED.png"), 258, 260, 454, 105);
		quit = new ImageButton(new Texture("mainmenu/buttons/quit.png"), 348, 157, 270, 105);
		quitHovered = new ImageButton(new Texture("mainmenu/buttons/quitHOVERED.png"), 348, 157, 270, 105);
	}

	public void render() {
		music.play();
		music.setLooping(true);
		int mouseX = Gdx.input.getX();
		int mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
		System.out.println(mouseX + " " + mouseY);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(new Texture("mainmenu/logo.png"), 0, 0);
		play.update(batch);
		options.update(batch);
		quit.update(batch);
		if (play.isHovered(mouseX, mouseY)) {
			playHovered.update(batch);
		}
		if (options.isHovered(mouseX, mouseY)) {
			optionsHovered.update(batch);
		}
		if (quit.isHovered(mouseX, mouseY)) {
			if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
				System.exit(0);
			}
			quitHovered.update(batch);
		}
		batch.end();

	}

}
