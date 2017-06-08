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

	private int x, y, height, width;
	private Sprite pacman;
	private FACING facing;
	private CollisionRect pac;;

	public PacMan(Texture t, int x, int y) {
		pacman = new Sprite(t);
		this.x = x;
		this.y = y;
		this.width = t.getWidth();
		this.height = t.getHeight();
		this.facing = FACING.RIGHT;
		this.pac = new CollisionRect(x, y, x + this.width, y + this.height);

	}

	public void render(SpriteBatch batch) {
		this.pacman.setPosition(this.x, this.y);
		this.pacman.draw(batch);
		this.pac = new CollisionRect(this.x, this.y, this.x + this.width, this.y + this.height);

		// Teleportation
		if (this.x == 195 && this.y < 440 && this.y > 340) {
			this.x = 750;
		} else if (this.x == 750 && this.y < 440 && this.y > 340) {
			this.x = 234;
		}

		if (Gdx.input.isKeyJustPressed(Keys.LEFT) || Gdx.input.isKeyJustPressed(Keys.RIGHT)
				|| Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.DOWN)
				|| Game.playing == true) {
			Game.playing = true;

			checkForRotation();

			this.y = this.facing == FACING.UP && !collides(this.x, this.y + 2) ? this.y + 2 : this.y;
			this.y = this.facing == FACING.DOWN && !collides(this.x, this.y - 2) ? this.y - 2 : this.y;
			this.x = this.facing == FACING.RIGHT && !collides(this.x + 2, this.y) ? this.x + 2 : this.x;
			this.x = this.facing == FACING.LEFT && !collides(this.x - 2, this.y) ? this.x - 2 : this.x;

			ticCollide();
			cherryCollide();
			ghostCollide();
		}
	}

	public void checkForRotation() {
		if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			rotate(Keys.LEFT);
		} else if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			rotate(Keys.RIGHT);
		} else if (Gdx.input.isKeyJustPressed(Keys.UP)) {
			rotate(Keys.UP);
		} else if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			rotate(Keys.DOWN);
		}
	}

	public void rotate(int key) {
		float rotation = pacman.getRotation();
		boolean flipedY = pacman.isFlipY();
		if (key == Keys.DOWN) {
			this.facing = FACING.DOWN;
			if (flipedY) {
				this.pacman.setFlip(false, false);
			}
			this.pacman.rotate((270 - rotation));
		} else if (key == Keys.UP) {
			if (flipedY) {
				this.pacman.setFlip(false, false);
			}
			this.facing = FACING.UP;
			this.pacman.rotate((90 - rotation));
		} else if (key == Keys.RIGHT) {
			if (flipedY) {
				this.pacman.setFlip(false, false);
			}
			this.facing = FACING.RIGHT;
			this.pacman.rotate((360 - rotation));
		} else if (key == Keys.LEFT) {
			this.pacman.setFlip(false, true);
			this.facing = FACING.LEFT;
			this.pacman.rotate((180 - rotation));
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

	public void ticCollide() {
		for (Tic r : Game.tic) {
			if (r.isAlive()) {
				if (r.getCollisionRect().collidesWith(this.pac)) {
					Game.score++;
					r.setAlive(false);
				}
			}
		}

	}

	public void cherryCollide() {
		for (Tic r : Game.tic) {
			if (r.isAlive()) {
				if (r.getCollisionRect().collidesWith(this.pac)) {
					Game.score++;
					r.setAlive(false);
				}
			}
		}

	}

	public void ghostCollide() {
		for (Ghost g : Game.ghosts) {
			if (g.isAlive()) {
				if (g.getCollisionRect().collidesWith(this.pac)) {
					Game.invincilbe = false;
					g.setAlive(false);
				}
			}
		}

	}

}