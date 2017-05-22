package me.ihaq.pacman.menu;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import me.ihaq.pacman.entity.PacMan;
import me.ihaq.pacman.entity.Tic;
import me.ihaq.pacman.utils.CollisionRect;

public class Game {

	public SpriteBatch batch;
	public Texture background;
	public PacMan pacMan;
	public static boolean playing;
	public int rotation;
	public static ArrayList<CollisionRect> boxes;
	public static ArrayList<Tic> tic;
	public static int score;
	public ShapeRenderer shapeRenderer;
	public BitmapFont font;

	public Game() {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();
		background = new Texture("game/bGround.jpg");
		pacMan = new PacMan(new Texture("game/pacman.png"), 475, 158);
		playing = false;
		score = 0;
		boxes = new ArrayList<CollisionRect>();
		tic = new ArrayList<Tic>();
		createTics();
		createBoundaries();
	}

	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(background, 0, 0);
		pacMan.render(batch, pacMan.x, pacMan.y);
		renderTics(batch);
		font.getData().setScale(2F);
		font.draw(batch, "Score: " + score, 22, 595);
		System.out.println("X:" + Gdx.input.getX() + ", Y:" + (Gdx.graphics.getHeight() - Gdx.input.getY()));
		batch.end();
	}

	public void createTics() {
		tic.add(new Tic(new Texture("game/tic.png"), 323, 166));
	}

	public void renderTics(SpriteBatch batch) {
		for (Tic t : tic) {
			t.render(batch);
		}
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

}
