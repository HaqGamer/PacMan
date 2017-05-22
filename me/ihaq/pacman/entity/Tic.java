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

	public Tic(Texture t, int x, int y) {
		this.tic = new Sprite(t);
		this.x = x;
		this.y = y;
		this.height = t.getHeight();
		this.width = t.getWidth();
		this.rect = new CollisionRect(x, y, x + this.width, y + this.height);
		this.alive = true;
	}

	public void render(SpriteBatch batch) {
		if (alive) {
			batch.draw(this.tic, this.x, this.y);
		}
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public CollisionRect getCollisionRect() {
		return this.rect;
	}
	public void setAlive(boolean b){
		this.alive = b;
	}
	public boolean isAlive(){
		return this.alive;
	}

}
