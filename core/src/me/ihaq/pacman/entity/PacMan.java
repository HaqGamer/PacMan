package me.ihaq.pacman.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.Main;
import me.ihaq.pacman.Main.STATE;
import me.ihaq.pacman.menu.Game.FACING;
import me.ihaq.pacman.utils.CollisionRect;
import me.ihaq.pacman.utils.Intersection;
import me.ihaq.pacman.utils.Portal;

public class PacMan {

	private int x, y, height, width;
	private Sprite pacman;
	private FACING facing;
	private CollisionRect pac;
	private boolean alive, eatMode;

	public PacMan(Texture t, int x, int y) {
		this.pacman = new Sprite(t);
		this.x = x;
		this.y = y;
		this.width = t.getWidth();
		this.height = t.getHeight();
		this.facing = FACING.RIGHT;
		this.pac = new CollisionRect(x, y, x + this.width, y + this.height);
		this.alive = true;

	}

	public void render(SpriteBatch batch) {
		if (!this.alive) {
			return;
		}
		this.pacman.setPosition(this.x, this.y);
		this.pacman.draw(batch);
		this.pac = new CollisionRect(this.x, this.y, this.x + this.width, this.y + this.height);

		if (Gdx.input.isKeyJustPressed(Keys.LEFT) || Gdx.input.isKeyJustPressed(Keys.RIGHT)
				|| Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.DOWN)
				|| Main.GAME.playing == true) {
			Main.GAME.playing = true;

			checkForPortals();
			checkForRotation();
			checkForCollisions();
		}
	}

	private void checkForCollisions() {
		this.y = this.facing == FACING.UP && !collides(this.x, this.y + 2) ? this.y + 2 : this.y;
		this.y = this.facing == FACING.DOWN && !collides(this.x, this.y - 2) ? this.y - 2 : this.y;
		this.x = this.facing == FACING.RIGHT && !collides(this.x + 2, this.y) ? this.x + 2 : this.x;
		this.x = this.facing == FACING.LEFT && !collides(this.x - 2, this.y) ? this.x - 2 : this.x;
		ticCollide();
		cherryCollide();
		ghostCollide();
	}

	private void checkForPortals() {
		for (Portal r : Main.GAME.portals) {
			if (r.getCollisionRect().collidesWith(this.pac)) {
				this.x = r.getTargetX();
			}
		}
	}

	private void checkForRotation() {

		if (facing == FACING.UP && Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			rotate(Keys.DOWN);
		} else if (facing == FACING.DOWN && Gdx.input.isKeyJustPressed(Keys.UP)) {
			rotate(Keys.UP);
		} else if (facing == FACING.RIGHT && Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			rotate(Keys.LEFT);
		} else if (facing == FACING.LEFT && Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			rotate(Keys.RIGHT);
		}
		if (!intersectionCollide()) {
			return;
		}
		for (FACING f : getCollidingIntersection().getDirections()) {
			if (f == FACING.UP && Gdx.input.isKeyJustPressed(Keys.UP)) {
				rotate(Keys.UP);
			} else if (f == FACING.DOWN && Gdx.input.isKeyJustPressed(Keys.DOWN)) {
				rotate(Keys.DOWN);
			} else if (f == FACING.RIGHT && Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
				rotate(Keys.RIGHT);
			} else if (f == FACING.LEFT && Gdx.input.isKeyJustPressed(Keys.LEFT)) {
				rotate(Keys.LEFT);
			}
		}
	}

	private void rotate(int key) {
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

	private boolean collides(int x, int y) {
		CollisionRect pac = new CollisionRect(x, y, x + this.width, y + this.height);
		for (CollisionRect r : Main.GAME.boxes) {
			if (r.collidesWith(pac)) {
				return true;
			}
		}
		return false;
	}

	private boolean intersectionCollide() {
		for (Intersection r : Main.GAME.intersections) {
			if (r.getCollisionRect().collidesWith(this.pac)) {
				return true;
			}
		}
		return false;
	}

	private Intersection getCollidingIntersection() {
		for (Intersection r : Main.GAME.intersections) {
			if (r.getCollisionRect().collidesWith(this.pac)) {
				return r;
			}
		}
		return null;
	}

	private void ticCollide() {
		for (Tic r : Main.GAME.tic) {
			if (r.isAlive()) {
				if (r.getCollisionRect().collidesWith(this.pac)) {
					Main.GAME.score += 100;
					r.setAlive(false);
				}
			}
		}

	}

	private void cherryCollide() {
		for (PowerUp r : Main.GAME.powerUp) {
			if (r.isAlive()) {
				if (r.getCollisionRect().collidesWith(this.pac)) {
					r.setAlive(false);
					this.eatMode = true;
					for (Ghost g : Main.GAME.ghosts) {
						g.setEatable(true);
					}

					new Thread(new Runnable() {
						@Override
						public void run() {
							boolean goochie = false;
							while (true) {
								if (goochie) {
									eatMode = false;
									for (Ghost g : Main.GAME.ghosts) {
										g.setEatable(false);
									}
								}
								goochie = true;
								try {
									Thread.sleep(10000); // how many seconds
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}).start();

				}
			}
		}

	}

	private void ghostCollide() {
		for (Ghost g : Main.GAME.ghosts) {
			if (g.isAlive()) {
				if (g.getCollisionRect().collidesWith(this.pac)) {
					if (g.isEatable()) {
						g.setAlive(false);
					} else if (!g.isEatable() && this.eatMode) {
						g.setEatable(true);
					} else {
						this.alive = false;
						Main.state = STATE.END;
					}

				}
			}
		}

	}

}