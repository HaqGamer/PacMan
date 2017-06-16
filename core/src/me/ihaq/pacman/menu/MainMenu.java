package me.ihaq.pacman.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.Main;
import me.ihaq.pacman.Main.STATE;
import me.ihaq.pacman.utils.ImageButton;

public class MainMenu {

	private SpriteBatch batch;
	private Texture logo;
	private Music music;
	private ImageButton play, playHovered, quit, quitHovered;

	/*
	 * Constructor for the MainMenu class. 
	 * This is pretty much the same thing as the create() method in the Main.java class.
	 */
	public MainMenu() {
		batch = new SpriteBatch();
		logo = new Texture("mainmenu/logo.png");
		music = Gdx.audio.newMusic(Gdx.files.internal("mainmenu/mainmenusong.mp3"));
		play = new ImageButton(new Texture("mainmenu/buttons/play.png"), 335, 303, 312, 105);
		playHovered = new ImageButton(new Texture("mainmenu/buttons/playHOVERED.png"), 335, 303, 312, 105);
		quit = new ImageButton(new Texture("mainmenu/buttons/quit.png"), 335, 200, 270, 105);
		quitHovered = new ImageButton(new Texture("mainmenu/buttons/quitHOVERED.png"), 335, 200, 270, 105);
	}

	/*
	 * Renders everything for the mainmenu
	 */
	public void render() {
		music.play();
		music.setLooping(true);
		int mouseX = Gdx.input.getX();
		int mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(logo, 0, 0);
		play.update(batch);
		quit.update(batch);
		if (play.isHovered(mouseX, mouseY)) {
			if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
				Main.state = STATE.HOWTOPLAY;
			}
			playHovered.update(batch);
		} else if (quit.isHovered(mouseX, mouseY)) {
			if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
				System.exit(0);
			}
			quitHovered.update(batch);
		}
		batch.end();

	}

	/*
	 * Returns the music for the class.
	 */
	public Music getMusic() {
		return this.music;
	}

}
