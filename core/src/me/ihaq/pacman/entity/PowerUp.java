package me.ihaq.pacman.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.utils.CollisionRect;

public class PowerUp {

	private int x, y, height, width;
	private Sprite power;
	private CollisionRect rect;
	private boolean alive;

	
	/*
	 * Constructor for the PowerUP class
	 */
	public PowerUp(Texture t, int x, int y) {
		this.power = new Sprite(t);
		this.x = x;
		this.y = y;
		this.height = t.getHeight();
		this.width = t.getWidth();
		this.rect = new CollisionRect(x, y, x + this.width, y + this.height);
		this.alive = true;
	}

	/*
	 * Renders the powerup if it is alive	
	 */
	public void render(SpriteBatch batch) {
		if (!alive) {
			return;
		}
		batch.draw(this.power, this.x, this.y);

	}

	/*
	 * Returns the x value of the powerup
	 */
	public int getX() {
		return this.x;
	}

	/*
	 * Returns the y value of the powerup
	 */
	public int getY() {
		return this.y;
	}

	/*
	 * Returns the height of the powerup
	 */
	public int getHeight() {
		return this.height;
	}

	/*
	 * Returns the width of the powerup
	 */
	public int getWidth() {
		return this.width;
	}

	/*
	 * Returns the CollisionRect for the powerup
	 */
	public CollisionRect getCollisionRect() {
		return this.rect;
	}

	/*
	 * Sets alive status for the powerup
	 */
	public void setAlive(boolean b) {
		this.alive = b;
	}

	/*
	 * Retunrs true if alive or false if not
	 */
	public boolean isAlive() {
		return this.alive;
	}

}
