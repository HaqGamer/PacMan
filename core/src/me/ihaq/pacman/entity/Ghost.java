package me.ihaq.pacman.entity;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.Main;
import me.ihaq.pacman.menu.Game.FACING;
import me.ihaq.pacman.utils.CollisionRect;
import me.ihaq.pacman.utils.Intersection;
import me.ihaq.pacman.utils.Portal;

public class Ghost {

	private int x, initialX, initialY, y, height, width, vx, vy;
	private Sprite ghost, eatGhost;
	private FACING facing;
	private boolean alive, eatable, collide;
	private CollisionRect rect;
	private Intersection i;

	/*
	 * Constructor for the Ghost class
	 */
	public Ghost(Texture t, int x, int y) {
		this.ghost = new Sprite(t);
		this.eatGhost = new Sprite(new Texture("game/ghostEAT.png"));
		this.x = x;
		this.y = y;
		this.initialX = x;
		this.initialY = y;
		this.width = t.getWidth();
		this.height = t.getHeight();
		this.facing = FACING.UP;
		this.alive = true;
		this.rect = new CollisionRect(x, y, x + this.width, y + this.height);
	}

	/*
	 * Renders all the ghosts Checks for all the collisions
	 */
	public void render(SpriteBatch batch) {
		if (!alive) {
			alive = true;
			this.x = initialX;
			this.y = initialY;
		}
		if (!eatable) {
			this.ghost.setPosition(this.x, this.y);
			this.ghost.draw(batch);
		} else {
			this.eatGhost.setPosition(this.x, this.y);
			this.eatGhost.draw(batch);
		}

		this.rect = new CollisionRect(this.x, this.y, this.x + this.width, this.y + this.height);

		if (!Main.GAME.playing) {
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
		checkForCollisions();

	}

	/*
	 * Checks if the ghost collides with an intersection or a boundry. If it
	 * collides it gets a new direction
	 */
	private void checkForCollisions() {
		this.facing = intersectionCollide() ? newIntersectionDirection() : this.facing;
		this.facing = intersectionCollide() ? newIntersectionDirection() : this.facing;
		this.facing = intersectionCollide() ? newIntersectionDirection() : this.facing;
		this.facing = intersectionCollide() ? newIntersectionDirection() : this.facing;

		this.facing = this.facing == FACING.UP && collides(this.x, this.y + 2) ? newDirection() : this.facing;
		this.facing = this.facing == FACING.DOWN && collides(this.x, this.y - 2) ? newDirection() : this.facing;
		this.facing = this.facing == FACING.RIGHT && collides(this.x + 2, this.y) ? newDirection() : this.facing;
		this.facing = this.facing == FACING.LEFT && collides(this.x - 2, this.y) ? newDirection() : this.facing;
	}

	/*
	 * Checks if the ghost collides with an portal if it does it teleports it.
	 */
	private void checkForPortals() {
		for (Portal r : Main.GAME.portals) {
			if (r.getCollisionRect().collidesWith(this.rect)) {
				this.x = r.getTargetX();
			}
		}
	}

	/*
	 * Takes in and x and y and makes a collisionrect out of it. And if that
	 * collisionrect collides with onne it returns true.
	 */
	private boolean collides(int x, int y) {
		CollisionRect pac = new CollisionRect(x, y, x + this.width, y + this.height);
		for (CollisionRect r : Main.GAME.boxes) {
			if (r.collidesWith(pac)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Returns true if the ghost collides with an intersection else false
	 */
	private boolean intersectionCollide() {
		for (Intersection r : Main.GAME.intersections) {
			if (r.getCollisionRect().collidesWith(this.rect)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Returns the intersection the ghost is currently colliding with
	 */
	private Intersection getCollidingIntersection() {
		for (Intersection r : Main.GAME.intersections) {
			if (r.getCollisionRect().collidesWith(this.rect)) {
				return r;
			}
		}
		return null;
	}

	/*
	 * Gets a new direction for the ghost if it collides at an intersection
	 */
	private FACING newIntersectionDirection() {
		Intersection i = getCollidingIntersection();
		/*
		 * Only allows the ghost to collide with a intersection once
		 */
		if (i == this.i || collide) {
			return this.facing;
		}
		int newMove = new Random().nextInt(i.getDirections().size());
		System.out.println(i.getDirections().get(newMove));
		System.out.println(i.getDirections());
		this.i = i;
		this.collide = true;

		/*
		 * Allows the ghost to collide with a intersection once every 4 seconds
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				boolean goochie = false;
				while (true) {
					if (goochie) {
						collide = false;
					}
					goochie = true;
					try {
						Thread.sleep(4000); // how many seconds
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		return i.getDirections().get(newMove);
	}

	/*
	 * Gets a new direction for the ghost if the ghost collides with a boundrie
	 */
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

	/*
	 * Returns the x value of the ghost
	 */
	public int getX() {
		return this.x;
	}

	/*
	 * Returns the x value of the ghost
	 */
	public int getY() {
		return this.y;
	}

	/*
	 * Returns the height of the ghost
	 */
	public int getHeight() {
		return this.height;
	}

	/*
	 * Returns the width of the ghost
	 */
	public int getWidth() {
		return this.width;
	}

	/*
	 * returns the CollisionRect for the ghost
	 */
	public CollisionRect getCollisionRect() {
		return this.rect;
	}

	/*
	 * Sets the alive status of the ghost
	 */
	public void setAlive(boolean b) {
		this.alive = b;
	}

	/*
	 * Returns true of the ghost is alive else false
	 */
	public boolean isAlive() {
		return this.alive;
	}

	/*
	 * Sets the etable status of the ghost
	 */
	public void setEatable(boolean b) {
		this.eatable = b;
	}

	/*
	 * Returns true of eatable else false
	 */
	public boolean isEatable() {
		return this.eatable;
	}
}
