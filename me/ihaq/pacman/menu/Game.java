package me.ihaq.pacman.menu;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import me.ihaq.pacman.entity.PacMan;
import me.ihaq.pacman.entity.PacMan.FACING;
import me.ihaq.pacman.utils.CollisionRect;

public class Game {

	public SpriteBatch batch;
	public Texture background;
	public PacMan pacMan;
	public boolean playing;
	public int rotation;
	public ArrayList<CollisionRect> boxes = new ArrayList<CollisionRect>();
	ShapeRenderer shapeRenderer;

	public Game() {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		background = new Texture("game/bGround.jpg");
		pacMan = new PacMan(new Texture("game/pacman.png"), 475, 158);
		playing = false;
		createBoundaries();
	}

	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0);

		pacMan.render(batch, pacMan.x, pacMan.y);

		System.out.println("X:" + Gdx.input.getX() + ", Y:" + (Gdx.graphics.getHeight() - Gdx.input.getY()));

		// Teleportation
		if (pacMan.x == 163 && pacMan.y < 408 && pacMan.y > 340) {
			pacMan.x = 800;
		} else if (pacMan.x == 796 && pacMan.y <= 408 && pacMan.y >= 340) {
			pacMan.x = 164;
		}

		if (Gdx.input.isKeyJustPressed(Keys.LEFT) || Gdx.input.isKeyJustPressed(Keys.RIGHT)
				|| Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.DOWN) || playing == true) {
			playing = true;

			if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
				pacMan.rotate(Keys.LEFT);

			} else if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
				pacMan.rotate(Keys.RIGHT);
			} else if (Gdx.input.isKeyJustPressed(Keys.UP)) {
				pacMan.rotate(Keys.UP);
			} else if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
				pacMan.rotate(Keys.DOWN);
			}
			if (pacMan.getFacing() == FACING.UP && (pacMan.y + 1 + pacMan.height) < 704
					&& !collides(pacMan.x, pacMan.y + 2)) {
				pacMan.y += 2;
			}

			else if (pacMan.getFacing() == FACING.DOWN && pacMan.y - 2 > 17 && !collides(pacMan.x, pacMan.y - 2)) {
				pacMan.y -= 2;
			}

			else if (pacMan.getFacing() == FACING.RIGHT && (pacMan.x + 2 + pacMan.width) < 832
					&& !collides(pacMan.x + 2, pacMan.y)) {
				pacMan.x += 2;
			}

			else if (pacMan.getFacing() == FACING.LEFT && pacMan.x - 2 > 163 && !collides(pacMan.x - 2, pacMan.y)) {
				pacMan.x -= 2;
			}

		}

		batch.end();
		// renderBoundaries();
	}

	public void createBoundaries() {
		boxes.add(new CollisionRect(410, 128, 587, 154));
		boxes.add(new CollisionRect(482, 63, 515, 129));
		boxes.add(new CollisionRect(210, 63, 437, 85));
		boxes.add(new CollisionRect(333, 83, 363, 152));
		boxes.add(new CollisionRect(157, 128, 215, 152));
		boxes.add(new CollisionRect(261, 136, 288, 220));
		boxes.add(new CollisionRect(214, 198, 288, 220));
		boxes.add(new CollisionRect(558, 63, 784, 85));
		boxes.add(new CollisionRect(631, 85, 664, 152));
		boxes.add(new CollisionRect(563, 201, 663, 223));
		boxes.add(new CollisionRect(711, 132, 742, 221));
		boxes.add(new CollisionRect(742, 198, 788, 221));
		boxes.add(new CollisionRect(337, 198, 439, 220));
		boxes.add(new CollisionRect(785, 129, 839, 153));
		boxes.add(new CollisionRect(484, 199, 518, 290));
		boxes.add(new CollisionRect(408, 268, 590, 291));
		boxes.add(new CollisionRect(158, 274, 291, 360));
		boxes.add(new CollisionRect(708, 268, 844, 358));
		boxes.add(new CollisionRect(633, 269, 662, 361));
		boxes.add(new CollisionRect(335, 272, 363, 359));
		boxes.add(new CollisionRect(157, 405, 286, 494));
		boxes.add(new CollisionRect(709, 406, 842, 496));
		boxes.add(new CollisionRect(634, 408, 665, 566));
		boxes.add(new CollisionRect(558, 475, 673, 500));
		boxes.add(new CollisionRect(334, 406, 365, 564));
		boxes.add(new CollisionRect(363, 472, 437, 494));
		boxes.add(new CollisionRect(483, 476, 515, 550));
		boxes.add(new CollisionRect(409, 542, 588, 565));
		boxes.add(new CollisionRect(205, 541, 291, 565));
		boxes.add(new CollisionRect(707, 541, 790, 565));
		boxes.add(new CollisionRect(485, 614, 517, 709));
		boxes.add(new CollisionRect(210, 614, 286, 657));
		boxes.add(new CollisionRect(335, 614, 438, 657));
		boxes.add(new CollisionRect(560, 614, 663, 657));
		boxes.add(new CollisionRect(708, 614, 787, 657));
	}

	public void renderBoundaries() {
		for (CollisionRect r : boxes) {
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(Color.RED);
			shapeRenderer.rect(r.x, r.y, r.width, r.height);
			shapeRenderer.end();
		}
	}

	public boolean collides(int x, int y) {
		CollisionRect pac = new CollisionRect(x, y, x + pacMan.width, y + pacMan.height);
		/*
		 * shapeRenderer.begin(ShapeType.Filled);
		 * shapeRenderer.setColor(Color.RED); shapeRenderer.rect(pac.x, pac.y,
		 * pac.width, pac.height); shapeRenderer.end();
		 */
		for (CollisionRect r : boxes) {
			if (r.collidesWith(pac)) {
				return true;
			}
		}
		return false;
	}

}
