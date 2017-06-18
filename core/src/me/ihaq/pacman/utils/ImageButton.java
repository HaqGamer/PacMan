package me.ihaq.pacman.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ImageButton {

	private Sprite skin;
	private int x, y, width, height;

	/*
	 * Constructor for the ImageButton
	 */
	public ImageButton(Texture texture, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		skin = new Sprite(texture);
		skin.setPosition(x, y);
	}

	/*
	 * Renders the current button
	 */
	public void update(SpriteBatch batch) {
		skin.draw(batch);
	}

	/*
	 * Checks if the provided x and y and over a ImageButton
	 */
	public boolean isHovered(int x, int y) {
		if (x > this.x && x < this.x + this.width) {
			if (y > this.y && y < this.y + this.height) {
				return true;
			}
		}
		return false;
	}

}
