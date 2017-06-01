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
import me.ihaq.pacman.entity.PowerUp;
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
	public static ArrayList<PowerUp> powerUp;
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
		powerUp = new ArrayList<PowerUp>();
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
		font.draw(batch, "" + score, 22, 595);
		// System.out.println("X:" + Gdx.input.getX() + ", Y:" +
		// (Gdx.graphics.getHeight() - Gdx.input.getY()));
		// renderBoundaries();
		batch.end();
	}

	public void createTics() {
		powerUp.add(new PowerUp(new Texture("game/cherry.png"), 308, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 125));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 145));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 185));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 205));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 225));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 265));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 285));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 325));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 345));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 365));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 385));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 405));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 425));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 465));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 485));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 505));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 545));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 565));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 605));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 625));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 645));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 665));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 685));

		tic.add(new Tic(new Texture("game/tic.png"), 688, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 125));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 145));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 185));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 205));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 225));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 265));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 285));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 325));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 345));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 365));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 385));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 405));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 425));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 465));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 485));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 505));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 545));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 565));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 605));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 625));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 645));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 665));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 685));

		tic.add(new Tic(new Texture("game/tic.png"), 708, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 728, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 748, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 768, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 788, 105));
		// tic.add(new Tic(new Texture("game/tic.png"), 808, 105));
		// tic.add(new Tic(new Texture("game/tic.png"), 668, 105));
		// tic.add(new Tic(new Texture("game/tic.png"), 648, 105));
		// tic.add(new Tic(new Texture("game/tic.png"), 628, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 588, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 568, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 528, 105));
		// tic.add(new Tic(new Texture("game/tic.png"), 508, 105));
		// tic.add(new Tic(new Texture("game/tic.png"), 488, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 468, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 428, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 408, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 368, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 348, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 328, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 288, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 268, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 248, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 228, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 208, 105));
	}

	public void renderTics(SpriteBatch batch) {
		for(PowerUp p : powerUp){
			p.render(batch);
		}
		for (Tic t : tic) {
			t.render(batch);
		}
	}

	public void createBoundaries() {
		boxes.add(new CollisionRect(409, 130, 589, 151));
		boxes.add(new CollisionRect(482, 62, 515, 130));
		boxes.add(new CollisionRect(210, 62, 438, 82));
		boxes.add(new CollisionRect(334, 80, 364, 151));
		boxes.add(new CollisionRect(157, 128, 215, 152));
		boxes.add(new CollisionRect(260, 128, 288, 220));
		boxes.add(new CollisionRect(214, 198, 288, 220));
		boxes.add(new CollisionRect(560, 62, 788, 82));
		boxes.add(new CollisionRect(634, 80, 664, 151));
		boxes.add(new CollisionRect(560, 198, 664, 220));
		boxes.add(new CollisionRect(710, 128, 738, 220));
		boxes.add(new CollisionRect(738, 198, 788, 220));
		boxes.add(new CollisionRect(336, 198, 439, 220));
		boxes.add(new CollisionRect(783, 128, 839, 152));
		boxes.add(new CollisionRect(482, 199, 516, 288));
		boxes.add(new CollisionRect(408, 266, 590, 290));
		boxes.add(new CollisionRect(156, 268, 288, 358));
		boxes.add(new CollisionRect(710, 268, 844, 358));
		boxes.add(new CollisionRect(634, 268, 664, 358));
		boxes.add(new CollisionRect(334, 268, 364, 358));
		boxes.add(new CollisionRect(157, 405, 288, 494));
		boxes.add(new CollisionRect(709, 405, 844, 496));
		boxes.add(new CollisionRect(634, 405, 664, 564));
		boxes.add(new CollisionRect(560, 472, 664, 498));
		boxes.add(new CollisionRect(334, 405, 366, 564));
		boxes.add(new CollisionRect(363, 472, 438, 498));
		boxes.add(new CollisionRect(483, 472, 515, 550));
		boxes.add(new CollisionRect(410, 542, 588, 564));
		boxes.add(new CollisionRect(210, 542, 289, 564));
		boxes.add(new CollisionRect(710, 542, 790, 564));
		boxes.add(new CollisionRect(483, 612, 515, 709));
		boxes.add(new CollisionRect(210, 612, 289, 656));
		boxes.add(new CollisionRect(335, 612, 438, 656));
		boxes.add(new CollisionRect(560, 612, 663, 656));
		boxes.add(new CollisionRect(708, 612, 787, 656));
		boxes.add(new CollisionRect(410, 336, 588, 426));

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