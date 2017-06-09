package me.ihaq.pacman.entity;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.menu.Game;
import me.ihaq.pacman.menu.Game.FACING;
import me.ihaq.pacman.utils.CollisionRect;
import me.ihaq.pacman.utils.Portal;

public class Ghost {

	private int x, y, height, width, vx, vy;
	private Sprite ghost;
	private FACING facing;
	private boolean alive;
	private CollisionRect rect;

	public Ghost(Texture t, int x, int y) {
		this.ghost = new Sprite(t);
		this.x = x;
		this.y = y;
		this.width = t.getWidth();
		this.height = t.getHeight();
		this.facing = FACING.UP;
		this.alive = true;
		this.rect = new CollisionRect(x, y, x + this.width, y + this.height);
	}

	public void render(SpriteBatch batch) {
		this.ghost.setPosition(this.x, this.y);
		this.ghost.draw(batch);
		this.rect = new CollisionRect(this.x, this.y, this.x + this.width, this.y + this.height);

		if (!Game.playing) {
			return;
		}

		if (this.facing == FACING.UP && !collides(this.x, this.y + 2)) {
			this.vx = 0;
			this.vy = 2;

			this.x += this.vx;
			this.y += this.vy;
		}

		else if (this.facing == FACING.DOWN && !collides(this.x, this.y - 2)) {
			this.vx = 0;
			this.vy = -2;

			this.x += this.vx;
			this.y += this.vy;
		}

		else if (this.facing == FACING.RIGHT && !collides(this.x + 2, this.y)) {
			this.vx = 2;
			this.vy = 0;

			this.x += this.vx;
			this.y += this.vy;
		}

		else if (this.facing == FACING.LEFT && !collides(this.x - 2, this.y)) {
			this.vx = -2;
			this.vy = 0;

			this.x += this.vx;
			this.y += this.vy;
		}

		checkForPortals();

		this.facing = this.facing == FACING.UP && collides(this.x, this.y + 2) ? newDirection() : this.facing;
		this.facing = this.facing == FACING.DOWN && collides(this.x, this.y - 2) ? newDirection() : this.facing;
		this.facing = this.facing == FACING.RIGHT && collides(this.x + 2, this.y) ? newDirection() : this.facing;
		this.facing = this.facing == FACING.LEFT && collides(this.x - 2, this.y) ? newDirection() : this.facing;

	}

	private void checkForPortals() {
		for (Portal r : Game.portals) {
			if (r.getCollisionRect().collidesWith(this.rect)) {
				this.x = r.getTargetX();
			}
		}
	}

	private boolean collides(int x, int y) {
		CollisionRect pac = new CollisionRect(x, y, x + this.width, y + this.height);
		for (CollisionRect r : Game.boxes) {
			if (r.collidesWith(pac)) {
				return true;
			}
		}
		return false;
	}

	private FACING newDirection() {
		int newMove = new Random().nextInt(4);
		if (newMove == 0) { // UP
			return FACING.UP;
		} else if (newMove == 1) { // DOWN
			return FACING.DOWN;
		} else if (newMove == 2) { // RIGHT
			return FACING.RIGHT;
		} else { // LEFT
			return FACING.LEFT;
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

	public void setAlive(boolean b) {
		this.alive = b;
	}

	public boolean isAlive() {
		return this.alive;
	}
}
