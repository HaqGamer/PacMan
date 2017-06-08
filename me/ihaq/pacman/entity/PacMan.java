package me.ihaq.pacman.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.menu.Game;
import me.ihaq.pacman.menu.Game.FACING;
import me.ihaq.pacman.utils.CollisionRect;

public class PacMan {

	public int x, y, height, width;
	private Sprite pacman;
	private FACING facing;

	public PacMan(Texture t, int x, int y) {
		pacman = new Sprite(t);
		this.x = x;
		this.y = y;
		this.width = t.getWidth();
		this.height = t.getHeight();
		this.facing = FACING.RIGHT;

	}

	public void render(SpriteBatch batch) {
		pacman.setPosition(x, y);
		pacman.draw(batch);
		
		// Teleportation
		if (x == 195 && y < 440 && y > 340) {
			this.x = 750;
		} else if (x == 750 && y < 440 && y > 340) {
			this.x = 234;
		}

		if (Gdx.input.isKeyJustPressed(Keys.LEFT) || Gdx.input.isKeyJustPressed(Keys.RIGHT)
				|| Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.DOWN)
				|| Game.playing == true) {
			Game.playing = true;

			if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
				rotate(Keys.LEFT);
			} else if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
				rotate(Keys.RIGHT);
			} else if (Gdx.input.isKeyJustPressed(Keys.UP)) {
				rotate(Keys.UP);
			} else if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
				rotate(Keys.DOWN);
			}

			if (this.facing == FACING.UP && (y + 1 + height) < 704 && !collides(x, y + 2)) {
				this.y += 2;
			}

			else if (this.facing == FACING.DOWN && y - 2 > 17 && !collides(x, y - 2)) {
				this.y -= 2;
			}

			else if (this.facing == FACING.RIGHT && (x + 2 + width) < 832 && !collides(x + 2, y)) {
				this.x += 2;
			}

			else if (this.facing == FACING.LEFT && x - 2 > 163 && !collides(x - 2, y)) {
				this.x -= 2;
			}

		}
		ticCollide(x, y);
		cherryCollide(x, y);
	}

	public void rotate(int key) {
		float rotation = pacman.getRotation();
		boolean flipedY = pacman.isFlipY();
		if (key == Keys.DOWN) {
			facing = FACING.DOWN;
			if (flipedY) {
				pacman.setFlip(false, false);
			}
			pacman.rotate((270 - rotation));
		} else if (key == Keys.UP) {
			if (flipedY) {
				pacman.setFlip(false, false);
			}
			facing = FACING.UP;
			pacman.rotate((90 - rotation));
		} else if (key == Keys.RIGHT) {
			if (flipedY) {
				pacman.setFlip(false, false);
			}
			facing = FACING.RIGHT;
			pacman.rotate((360 - rotation));
		} else if (key == Keys.LEFT) {
			pacman.setFlip(false, true);
			facing = FACING.LEFT;
			pacman.rotate((180 - rotation));
		}
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public boolean collides(int x, int y) {
		CollisionRect pac = new CollisionRect(x, y, x + this.width, y + this.height);
		/*
		 * shapeRenderer.begin(ShapeType.Filled);
		 * shapeRenderer.setColor(Color.RED); shapeRenderer.rect(pac.x, pac.y,
		 * pac.width, pac.height); shapeRenderer.end();
		 */
		for (CollisionRect r : Game.boxes) {
			if (r.collidesWith(pac)) {
				return true;
			}
		}
		return false;
	}

	public void ticCollide(int x, int y) {
		CollisionRect pac = new CollisionRect(x, y, x + this.width, y + this.height);
		for (Tic r : Game.tic) {
			if (r.isAlive()) {
				if (r.getCollisionRect().collidesWith(pac)) {
					Game.score++;
					r.setAlive(false);
				}
			}
		}

	}
	
	public void ghostCollide(int x, int y) {
		CollisionRect pac = new CollisionRect(x, y, x + this.width, y + this.height);
		for (Tic r : Game.tic) {
			if (r.isAlive()) {
				if (r.getCollisionRect().collidesWith(pac)) {
					Game.score++;
					r.setAlive(false);
				}
			}
		}

	}

	public void cherryCollide(int x, int y) {
		CollisionRect pac = new CollisionRect(x, y, x + this.width, y + this.height);
		for (Ghost r : Game.ghosts) {
			if (r.isAlive()) {
				if (r.getCollisionRect().collidesWith(pac)) {
					Game.invincilbe = true;
					r.setAlive(false);
				}
			}
		}

	}

}