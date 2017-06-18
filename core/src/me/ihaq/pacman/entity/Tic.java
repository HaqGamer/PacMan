package me.ihaq.pacman.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.utils.CollisionRect;

public class Tic {

	private int x, y, height, width;
	private Sprite tic;
	private CollisionRect rect;
	private boolean alive;

	/*
	 * Constructor for the Tic Class
	 */
	public Tic(Texture t, int x, int y) {
		this.tic = new Sprite(t);
		this.x = x;
		this.y = y;
		this.height = t.getHeight();
		this.width = t.getWidth();
		this.rect = new CollisionRect(x, y, x + this.width, y + this.height);
		this.alive = true;
	}

	/*
	 * Renders the tic if it is alive
	 */
	public void render(SpriteBatch batch) {
		if (!alive) {
			return;
		}
		batch.draw(this.tic, this.x, this.y);
	}

	/*
	 * Returns the x value of the tic
	 */
	public int getX() {
		return this.x;
	}

	/*
	 * Returns the y value of the tic
	 */
	public int getY() {
		return this.y;
	}

	/*
	 * Returns the height of the tic
	 */
	public int getHeight() {
		return this.height;
	}

	/*
	 * Returns the width of the tic
	 */
	public int getWidth() {
		return this.width;
	}

	/*
	 * Returns the CollisionRect for the tic
	 */
	public CollisionRect getCollisionRect() {
		return this.rect;
	}

	/*
	 * Sets alive for the tic 
	 */
	public void setAlive(boolean b) {
		this.alive = b;
	}

	/*
	 * Returns true if the tic is alive or false if not alive
	 */
	public boolean isAlive() {
		return this.alive;
	}

}
