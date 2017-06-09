package me.ihaq.pacman.menu;

import java.util.ArrayList;
import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import me.ihaq.pacman.entity.Ghost;
import me.ihaq.pacman.entity.PacMan;
import me.ihaq.pacman.entity.PowerUp;
import me.ihaq.pacman.entity.Tic;
import me.ihaq.pacman.utils.CollisionRect;
import me.ihaq.pacman.utils.Intersection;
import me.ihaq.pacman.utils.Portal;

public class Game {

	public static SpriteBatch batch;
	public static Texture background;
	public static PacMan pacMan;
	public static boolean playing;
	public static int rotation;
	public static ArrayList<CollisionRect> boxes;
	public static ArrayList<Intersection> intersections;
	public static ArrayList<Portal> portals;
	public static ArrayList<Tic> tic;
	public static ArrayList<PowerUp> powerUp;
	public static ArrayList<Ghost> ghosts;

	public static int score;
	public static ShapeRenderer shapeRenderer;
	public static BitmapFont font;
	public static boolean invincilbe = false;

	public Game() {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();
		background = new Texture("game/bGround.jpg");
		pacMan = new PacMan(new Texture("game/pacman.png"), 475, 158);
		playing = false;
		score = 0;
		boxes = new ArrayList<CollisionRect>();
		intersections = new ArrayList<Intersection>();
		portals = new ArrayList<Portal>();
		tic = new ArrayList<Tic>();
		powerUp = new ArrayList<PowerUp>();
		ghosts = new ArrayList<Ghost>();
		createEntities();
		createBoundaries();
	}

	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0);
		pacMan.render(batch);
		renderEntitis(batch);
		font.getData().setScale(2F);
		font.draw(batch, "" + score, 22, 595);
		int mouseX = Gdx.input.getX();
		int mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
		System.out.println(mouseX + " , " + mouseY);
		batch.end();
	}

	private void createEntities() {
		ghosts.add(new Ghost(new Texture("game/ghostO.png"), 377, 376));

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

	private void renderEntitis(SpriteBatch batch) {
		for (PowerUp p : powerUp) {
			p.render(batch);
		}
		for (Tic t : tic) {
			t.render(batch);
		}
		for (Ghost g : ghosts) {
			g.render(batch);
		}
	}

	private void createBoundaries() {

		portals.add(new Portal(192, 381, 193, 382, 753));
		portals.add(new Portal(795, 382, 796, 383, 237));

		intersections.add(new Intersection(183, 40, 184, 41, Arrays.asList(FACING.UP, FACING.RIGHT)));
		intersections.add(new Intersection(458, 40, 459, 41, Arrays.asList(FACING.UP, FACING.RIGHT, FACING.LEFT)));
		intersections.add(new Intersection(535, 40, 536, 41, Arrays.asList(FACING.UP, FACING.RIGHT, FACING.LEFT)));
		intersections.add(new Intersection(805, 40, 806, 41, Arrays.asList(FACING.UP, FACING.LEFT)));

		intersections.add(new Intersection(183, 109, 184, 110, Arrays.asList(FACING.RIGHT, FACING.DOWN)));
		intersections.add(new Intersection(229, 109, 230, 110, Arrays.asList(FACING.UP, FACING.LEFT, FACING.RIGHT)));
		intersections.add(new Intersection(306, 109, 307, 110, Arrays.asList(FACING.UP, FACING.LEFT)));
		intersections.add(new Intersection(380, 109, 381, 110, Arrays.asList(FACING.UP, FACING.RIGHT)));
		intersections.add(new Intersection(455, 109, 456, 110, Arrays.asList(FACING.LEFT, FACING.DOWN)));
		intersections.add(new Intersection(536, 109, 537, 110, Arrays.asList(FACING.RIGHT, FACING.DOWN)));
		intersections.add(new Intersection(603, 109, 604, 110, Arrays.asList(FACING.UP, FACING.LEFT)));
		intersections.add(new Intersection(679, 109, 680, 110, Arrays.asList(FACING.UP, FACING.RIGHT)));
		intersections.add(new Intersection(757, 109, 758, 110, Arrays.asList(FACING.UP, FACING.RIGHT, FACING.LEFT)));
		intersections.add(new Intersection(804, 109, 805, 110, Arrays.asList(FACING.DOWN, FACING.LEFT)));

		intersections.add(new Intersection(186, 177, 187, 178, Arrays.asList(FACING.UP, FACING.RIGHT)));
		intersections.add(new Intersection(230, 177, 231, 178, Arrays.asList(FACING.LEFT, FACING.DOWN)));
		intersections.add(new Intersection(304, 177, 305, 178, Arrays.asList(FACING.UP, FACING.DOWN, FACING.RIGHT)));
		intersections.add(new Intersection(382, 177, 383, 178, Arrays.asList(FACING.LEFT, FACING.DOWN, FACING.RIGHT)));
		intersections.add(new Intersection(457, 177, 458, 178, Arrays.asList(FACING.UP, FACING.LEFT, FACING.RIGHT)));
		intersections.add(new Intersection(535, 177, 536, 178, Arrays.asList(FACING.UP, FACING.LEFT, FACING.RIGHT)));
		intersections.add(new Intersection(607, 177, 608, 178, Arrays.asList(FACING.LEFT, FACING.DOWN, FACING.RIGHT)));
		intersections.add(new Intersection(683, 177, 684, 178, Arrays.asList(FACING.LEFT, FACING.DOWN, FACING.UP)));
		intersections.add(new Intersection(760, 177, 761, 178, Arrays.asList(FACING.RIGHT, FACING.DOWN)));
		intersections.add(new Intersection(805, 177, 806, 178, Arrays.asList(FACING.UP, FACING.LEFT)));

		intersections.add(new Intersection(185, 239, 186, 240, Arrays.asList(FACING.RIGHT, FACING.DOWN)));
		intersections.add(
				new Intersection(309, 239, 310, 240, Arrays.asList(FACING.RIGHT, FACING.DOWN, FACING.UP, FACING.LEFT)));
		intersections.add(new Intersection(385, 239, 386, 240, Arrays.asList(FACING.UP, FACING.LEFT, FACING.RIGHT)));
		intersections.add(new Intersection(452, 239, 453, 240, Arrays.asList(FACING.LEFT, FACING.DOWN)));
		intersections.add(new Intersection(537, 239, 538, 240, Arrays.asList(FACING.RIGHT, FACING.DOWN)));
		intersections.add(new Intersection(607, 239, 608, 240, Arrays.asList(FACING.RIGHT, FACING.UP, FACING.LEFT)));
		intersections.add(
				new Intersection(684, 239, 685, 240, Arrays.asList(FACING.RIGHT, FACING.DOWN, FACING.UP, FACING.LEFT)));
		intersections.add(new Intersection(806, 239, 807, 240, Arrays.asList(FACING.LEFT, FACING.DOWN)));

		intersections.add(new Intersection(385, 313, 386, 314, Arrays.asList(FACING.UP, FACING.DOWN, FACING.RIGHT)));
		intersections.add(new Intersection(605, 313, 606, 314, Arrays.asList(FACING.UP, FACING.DOWN, FACING.LEFT)));

		intersections.add(
				new Intersection(306, 384, 307, 385, Arrays.asList(FACING.UP, FACING.DOWN, FACING.LEFT, FACING.RIGHT)));
		intersections.add(new Intersection(385, 384, 386, 385, Arrays.asList(FACING.UP, FACING.DOWN, FACING.LEFT)));
		intersections.add(new Intersection(609, 384, 610, 385, Arrays.asList(FACING.UP, FACING.DOWN, FACING.RIGHT)));
		intersections.add(
				new Intersection(686, 384, 687, 385, Arrays.asList(FACING.UP, FACING.DOWN, FACING.LEFT, FACING.RIGHT)));

		intersections.add(new Intersection(388, 448, 389, 449, Arrays.asList(FACING.DOWN, FACING.RIGHT)));
		intersections.add(new Intersection(458, 448, 459, 449, Arrays.asList(FACING.UP, FACING.RIGHT, FACING.LEFT)));
		intersections.add(new Intersection(537, 448, 538, 449, Arrays.asList(FACING.UP, FACING.RIGHT, FACING.LEFT)));
		intersections.add(new Intersection(607, 448, 608, 449, Arrays.asList(FACING.DOWN, FACING.LEFT)));

		intersections.add(new Intersection(185, 521, 186, 522, Arrays.asList(FACING.UP, FACING.RIGHT)));
		intersections.add(new Intersection(305, 521, 306, 522, Arrays.asList(FACING.UP, FACING.DOWN, FACING.LEFT)));
		intersections.add(new Intersection(386, 521, 387, 522, Arrays.asList(FACING.UP, FACING.RIGHT)));
		intersections.add(new Intersection(455, 521, 456, 522, Arrays.asList(FACING.LEFT, FACING.DOWN)));
		intersections.add(new Intersection(534, 521, 535, 522, Arrays.asList(FACING.RIGHT, FACING.DOWN)));
		intersections.add(new Intersection(607, 521, 608, 522, Arrays.asList(FACING.UP, FACING.LEFT)));
		intersections.add(new Intersection(689, 521, 690, 522, Arrays.asList(FACING.UP, FACING.DOWN, FACING.RIGHT)));
		intersections.add(new Intersection(807, 521, 808, 522, Arrays.asList(FACING.UP, FACING.LEFT)));

		intersections.add(new Intersection(186, 592, 187, 593, Arrays.asList(FACING.UP, FACING.DOWN, FACING.RIGHT)));
		intersections.add(
				new Intersection(310, 592, 311, 593, Arrays.asList(FACING.RIGHT, FACING.DOWN, FACING.UP, FACING.LEFT)));
		intersections.add(new Intersection(387, 592, 388, 593, Arrays.asList(FACING.LEFT, FACING.DOWN, FACING.RIGHT)));
		intersections.add(new Intersection(460, 592, 461, 593, Arrays.asList(FACING.LEFT, FACING.UP, FACING.RIGHT)));
		intersections.add(new Intersection(538, 592, 539, 593, Arrays.asList(FACING.LEFT, FACING.UP, FACING.RIGHT)));
		intersections.add(new Intersection(609, 592, 610, 593, Arrays.asList(FACING.LEFT, FACING.DOWN, FACING.RIGHT)));
		intersections.add(
				new Intersection(687, 592, 688, 593, Arrays.asList(FACING.RIGHT, FACING.DOWN, FACING.UP, FACING.LEFT)));
		intersections.add(new Intersection(809, 592, 810, 593, Arrays.asList(FACING.LEFT, FACING.DOWN, FACING.UP)));

		intersections.add(new Intersection(192, 682, 193, 683, Arrays.asList(FACING.DOWN, FACING.RIGHT)));
		intersections.add(new Intersection(310, 682, 311, 683, Arrays.asList(FACING.DOWN, FACING.RIGHT, FACING.LEFT)));
		intersections.add(new Intersection(456, 682, 457, 683, Arrays.asList(FACING.DOWN, FACING.LEFT)));
		intersections.add(new Intersection(540, 682, 541, 683, Arrays.asList(FACING.DOWN, FACING.RIGHT)));
		intersections.add(new Intersection(682, 682, 683, 683, Arrays.asList(FACING.DOWN, FACING.RIGHT, FACING.LEFT)));
		intersections.add(new Intersection(807, 682, 808, 683, Arrays.asList(FACING.DOWN, FACING.LEFT)));

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
		boxes.add(new CollisionRect(154, 3, 843, 15));
		boxes.add(new CollisionRect(154, 3, 164, 713));
		boxes.add(new CollisionRect(833, 3, 843, 713));
		boxes.add(new CollisionRect(154, 702, 843, 713));
	}

	private void renderBoundaries() {
		shapeRenderer.begin(ShapeType.Filled);
		for (CollisionRect r : boxes) {
			shapeRenderer.setColor(Color.RED);
			shapeRenderer.rect(r.x, r.y, r.width, r.height);
		}
		for (Intersection r : intersections) {
			shapeRenderer.setColor(Color.GREEN);
			shapeRenderer.rect(r.getCollisionRect().x, r.getCollisionRect().y, r.getCollisionRect().width,
					r.getCollisionRect().height);
		}
		shapeRenderer.end();
	}

	public enum FACING {
		UP, DOWN, RIGHT, LEFT
	}

}