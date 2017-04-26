package me.ihaq.pacman.entity;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PacMan {

	private int x, y, height, width;
	private Sprite pacman;

	public PacMan(Texture t, int x, int y) {
		pacman = new Sprite(t);
		this.x = x;
		this.y = y;
		this.width = t.getWidth();
		this.height = t.getHeight();
	}

	public void render(SpriteBatch batch, int x, int y) {
		pacman.setPosition(x, y);
		pacman.draw(batch);
	}

	public void rotate(int key) {
		float rotation = pacman.getRotation();
		if (key == Keys.DOWN) {
			pacman.rotate((270-rotation));
		} else if (key == Keys.UP) {
			pacman.rotate((90-rotation));
		} else if (key == Keys.RIGHT) {
			pacman.rotate((360-rotation));
		} else if (key == Keys.LEFT) {
			pacman.rotate((180-rotation));
		}
	}

}
