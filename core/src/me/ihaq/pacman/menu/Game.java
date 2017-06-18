package me.ihaq.pacman.menu;

import java.util.ArrayList;
import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.ihaq.pacman.entity.Ghost;
import me.ihaq.pacman.entity.PacMan;
import me.ihaq.pacman.entity.PowerUp;
import me.ihaq.pacman.entity.Tic;
import me.ihaq.pacman.utils.CollisionRect;
import me.ihaq.pacman.utils.Intersection;
import me.ihaq.pacman.utils.Portal;

public class Game {

	public PacMan pacMan;
	public boolean playing, eatMode;
	public ArrayList<CollisionRect> pacmanBoundries; // holds all the boundries
	public ArrayList<CollisionRect> ghostBoundries; // holds all the boundries
	public ArrayList<Intersection> intersections; // holds all he intersections
	public ArrayList<Portal> portals; // holds all the portals
	public ArrayList<Tic> tic; // holds all the tics
	public ArrayList<PowerUp> powerUp; // holds all the powerups
	public ArrayList<Ghost> ghosts; // holds all the ghosts
	public int score; // holds the score

	private Texture background;
	private SpriteBatch batch;
	private BitmapFont font;

	/*
	 * Constructor for the Game class
	 */
	public Game() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		background = new Texture("game/bGround.png");
		pacMan = new PacMan(new Texture("game/pacman.png"), 475, 158);
		playing = false;
		score = 0;
		pacmanBoundries = new ArrayList<CollisionRect>();
		ghostBoundries = new ArrayList<CollisionRect>();
		intersections = new ArrayList<Intersection>();
		portals = new ArrayList<Portal>();
		tic = new ArrayList<Tic>();
		powerUp = new ArrayList<PowerUp>();
		ghosts = new ArrayList<Ghost>();
		createEntities();
		createBoundaries();
	}

	/*
	 * Renders everything for the game
	 */
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0);
		pacMan.render(batch);
		renderEntitis(batch);
		font.getData().setScale(2F);
		font.draw(batch, "" + score, 22, 595);
		batch.end();
	}

	/*
	 * Creates the protals for the map Creates the ghosts for the game Creates
	 * all the powerups for the map Creates all the tics for the map
	 */
	private void createEntities() {

		ghosts.add(new Ghost(new Texture("game/ghostR.png"), 485, 380));
		ghosts.add(new Ghost(new Texture("game/ghostO.png"), 485, 380));
		ghosts.add(new Ghost(new Texture("game/ghostP.png"), 485, 380));
		ghosts.add(new Ghost(new Texture("game/ghostC.png"), 485, 380));

		portals.add(new Portal(168, 381, 167, 382, 790));
		portals.add(new Portal(823, 382, 824, 383, 198));

		// powerUp.add(new PowerUp(new Texture("game/cherry.png"), 308, 105));

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

		tic.add(new Tic(new Texture("game/tic.png"), 808, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 728, 105));
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
		// tic.add(new Tic(new Texture("game/tic.png"), 368, 105));
		// tic.add(new Tic(new Texture("game/tic.png"), 348, 105));
		// tic.add(new Tic(new Texture("game/tic.png"), 328, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 288, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 268, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 248, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 228, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 208, 105));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 105));

		tic.add(new Tic(new Texture("game/tic.png"), 528, 65));
		tic.add(new Tic(new Texture("game/tic.png"), 528, 85));
		tic.add(new Tic(new Texture("game/tic.png"), 468, 65));
		tic.add(new Tic(new Texture("game/tic.png"), 468, 85));

		tic.add(new Tic(new Texture("game/tic.png"), 188, 85));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 65));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 45));

		tic.add(new Tic(new Texture("game/tic.png"), 808, 85));
		tic.add(new Tic(new Texture("game/tic.png"), 808, 65));
		tic.add(new Tic(new Texture("game/tic.png"), 808, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 688, 45));

		tic.add(new Tic(new Texture("game/tic.png"), 788, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 768, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 748, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 728, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 708, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 808, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 668, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 648, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 628, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 588, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 568, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 528, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 508, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 488, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 468, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 428, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 408, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 368, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 348, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 328, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 288, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 268, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 248, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 228, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 208, 45));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 45));

		tic.add(new Tic(new Texture("game/tic.png"), 228, 125));
		tic.add(new Tic(new Texture("game/tic.png"), 228, 145));
		tic.add(new Tic(new Texture("game/tic.png"), 228, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 208, 165));

		// tic.add(new Tic(new Texture("game/cherry.png"), 178, 165));
		powerUp.add(new PowerUp(new Texture("game/cherry.png"), 178, 165));

		tic.add(new Tic(new Texture("game/tic.png"), 188, 205));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 225));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 208, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 228, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 248, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 268, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 288, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 328, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 348, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 368, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 408, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 428, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 245));
		// tic.add(new Tic(new Texture("game/tic.png"), 468, 245));
		// tic.add(new Tic(new Texture("game/tic.png"), 488, 245));
		// tic.add(new Tic(new Texture("game/tic.png"), 508, 245));
		// tic.add(new Tic(new Texture("game/tic.png"), 528, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 568, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 588, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 628, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 648, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 668, 245));
		// tic.add(new Tic(new Texture("game/tic.png"), 688, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 708, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 728, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 748, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 768, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 788, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 808, 245));
		tic.add(new Tic(new Texture("game/tic.png"), 808, 225));
		tic.add(new Tic(new Texture("game/tic.png"), 808, 205));
		// tic.add(new Tic(new Texture("game/tic.png"), 808, 185));

		// tic.add(new Tic(new Texture("game/cherry.png"), 808, 165));
		powerUp.add(new PowerUp(new Texture("game/cherry.png"), 803, 165));

		tic.add(new Tic(new Texture("game/tic.png"), 788, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 768, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 748, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 748, 145));
		tic.add(new Tic(new Texture("game/tic.png"), 748, 125));

		tic.add(new Tic(new Texture("game/tic.png"), 668, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 648, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 628, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 588, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 568, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 165));
		// tic.add(new Tic(new Texture("game/tic.png"), 528, 165));
		// tic.add(new Tic(new Texture("game/tic.png"), 508, 165));
		// tic.add(new Tic(new Texture("game/tic.png"), 488, 165));
		// tic.add(new Tic(new Texture("game/tic.png"), 468, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 428, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 408, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 368, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 348, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 328, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 165));
		// tic.add(new Tic(new Texture("game/tic.png"), 288, 165));
		// tic.add(new Tic(new Texture("game/tic.png"), 268, 165));
		// tic.add(new Tic(new Texture("game/tic.png"), 248, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 228, 165));
		tic.add(new Tic(new Texture("game/tic.png"), 208, 165));

		tic.add(new Tic(new Texture("game/tic.png"), 388, 128));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 148));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 128));

		tic.add(new Tic(new Texture("game/tic.png"), 448, 225));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 205));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 185));

		tic.add(new Tic(new Texture("game/tic.png"), 548, 225));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 205));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 185));

		tic.add(new Tic(new Texture("game/tic.png"), 388, 265));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 285));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 325));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 345));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 365));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 385));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 405));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 425));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 445));

		tic.add(new Tic(new Texture("game/tic.png"), 608, 265));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 285));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 325));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 345));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 365));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 385));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 405));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 425));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 445));

		tic.add(new Tic(new Texture("game/tic.png"), 388, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 545));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 565));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 585));

		tic.add(new Tic(new Texture("game/tic.png"), 608, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 545));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 565));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 585));

		tic.add(new Tic(new Texture("game/tic.png"), 608, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 588, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 568, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 528, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 508, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 488, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 468, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 428, 305));
		tic.add(new Tic(new Texture("game/tic.png"), 408, 305));

		tic.add(new Tic(new Texture("game/tic.png"), 608, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 588, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 568, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 528, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 508, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 488, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 468, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 428, 445));
		tic.add(new Tic(new Texture("game/tic.png"), 408, 445));

		tic.add(new Tic(new Texture("game/tic.png"), 608, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 588, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 568, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 525));
		// tic.add(new Tic(new Texture("game/tic.png"), 528, 525));
		// tic.add(new Tic(new Texture("game/tic.png"), 508, 525));
		// tic.add(new Tic(new Texture("game/tic.png"), 488, 525));
		// tic.add(new Tic(new Texture("game/tic.png"), 468, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 428, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 408, 525));

		tic.add(new Tic(new Texture("game/tic.png"), 448, 505));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 485));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 465));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 505));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 485));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 465));

		tic.add(new Tic(new Texture("game/tic.png"), 788, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 768, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 748, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 728, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 708, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 808, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 668, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 648, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 628, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 588, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 568, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 685));
		// tic.add(new Tic(new Texture("game/tic.png"), 528, 685));
		// tic.add(new Tic(new Texture("game/tic.png"), 508, 685));
		// tic.add(new Tic(new Texture("game/tic.png"), 488, 685));
		// tic.add(new Tic(new Texture("game/tic.png"), 468, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 428, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 408, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 368, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 348, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 328, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 288, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 268, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 248, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 228, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 208, 685));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 685));

		tic.add(new Tic(new Texture("game/tic.png"), 788, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 768, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 748, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 728, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 708, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 808, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 668, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 648, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 628, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 608, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 588, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 568, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 528, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 508, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 488, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 468, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 428, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 408, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 388, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 368, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 348, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 328, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 308, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 288, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 268, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 248, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 228, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 208, 585));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 585));

		tic.add(new Tic(new Texture("game/tic.png"), 448, 605));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 625));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 645));
		tic.add(new Tic(new Texture("game/tic.png"), 448, 665));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 605));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 625));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 645));
		tic.add(new Tic(new Texture("game/tic.png"), 548, 665));

		tic.add(new Tic(new Texture("game/tic.png"), 288, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 268, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 248, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 228, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 208, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 808, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 788, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 768, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 748, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 728, 525));
		tic.add(new Tic(new Texture("game/tic.png"), 708, 525));

		tic.add(new Tic(new Texture("game/tic.png"), 328, 385));
		tic.add(new Tic(new Texture("game/tic.png"), 348, 385));
		tic.add(new Tic(new Texture("game/tic.png"), 368, 385));
		tic.add(new Tic(new Texture("game/tic.png"), 628, 385));
		tic.add(new Tic(new Texture("game/tic.png"), 648, 385));
		tic.add(new Tic(new Texture("game/tic.png"), 668, 385));

		powerUp.add(new PowerUp(new Texture("game/cherry.png"), 178, 630));

		powerUp.add(new PowerUp(new Texture("game/cherry.png"), 803, 630));

		tic.add(new Tic(new Texture("game/tic.png"), 808, 665));
		tic.add(new Tic(new Texture("game/tic.png"), 808, 605));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 665));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 605));

		tic.add(new Tic(new Texture("game/tic.png"), 808, 568));
		tic.add(new Tic(new Texture("game/tic.png"), 808, 548));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 568));
		tic.add(new Tic(new Texture("game/tic.png"), 188, 548));
	}

	/*
	 * Renders all the powerups Renders all the tics Renders all the ghosts
	 */
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

	/*
	 * Creates all the intersections for the map Creates all the boundries for
	 * the map
	 */
	private void createBoundaries() {

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
		intersections.add(new Intersection(310, 177, 311, 178, Arrays.asList(FACING.UP, FACING.DOWN, FACING.RIGHT)));
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
		intersections.add(new Intersection(497, 459, 498, 460, Arrays.asList(FACING.RIGHT, FACING.LEFT)));
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

		pacmanBoundries.add(new CollisionRect(409, 130, 589, 151));
		pacmanBoundries.add(new CollisionRect(482, 62, 515, 130));
		pacmanBoundries.add(new CollisionRect(210, 62, 438, 82));
		pacmanBoundries.add(new CollisionRect(334, 80, 364, 151));
		pacmanBoundries.add(new CollisionRect(157, 128, 215, 152));
		pacmanBoundries.add(new CollisionRect(260, 128, 288, 220));
		pacmanBoundries.add(new CollisionRect(214, 198, 288, 220));
		pacmanBoundries.add(new CollisionRect(560, 62, 788, 82));
		pacmanBoundries.add(new CollisionRect(634, 80, 664, 151));
		pacmanBoundries.add(new CollisionRect(560, 198, 664, 220));
		pacmanBoundries.add(new CollisionRect(710, 128, 738, 220));
		pacmanBoundries.add(new CollisionRect(738, 198, 788, 220));
		pacmanBoundries.add(new CollisionRect(336, 198, 439, 220));
		pacmanBoundries.add(new CollisionRect(783, 128, 839, 152));
		pacmanBoundries.add(new CollisionRect(482, 199, 516, 288));
		pacmanBoundries.add(new CollisionRect(408, 266, 590, 290));
		pacmanBoundries.add(new CollisionRect(156, 268, 288, 358));
		pacmanBoundries.add(new CollisionRect(710, 268, 844, 358));
		pacmanBoundries.add(new CollisionRect(634, 268, 664, 358));
		pacmanBoundries.add(new CollisionRect(334, 268, 364, 358));
		pacmanBoundries.add(new CollisionRect(157, 405, 288, 494));
		pacmanBoundries.add(new CollisionRect(709, 405, 844, 496));
		pacmanBoundries.add(new CollisionRect(634, 405, 664, 564));
		pacmanBoundries.add(new CollisionRect(560, 472, 664, 498));
		pacmanBoundries.add(new CollisionRect(334, 405, 366, 564));
		pacmanBoundries.add(new CollisionRect(363, 472, 438, 498));
		pacmanBoundries.add(new CollisionRect(483, 472, 515, 550));
		pacmanBoundries.add(new CollisionRect(410, 542, 588, 564));
		pacmanBoundries.add(new CollisionRect(210, 542, 289, 564));
		pacmanBoundries.add(new CollisionRect(710, 542, 790, 564));
		pacmanBoundries.add(new CollisionRect(483, 612, 515, 709));
		pacmanBoundries.add(new CollisionRect(210, 612, 289, 656));
		pacmanBoundries.add(new CollisionRect(335, 612, 438, 656));
		pacmanBoundries.add(new CollisionRect(560, 612, 663, 656));
		pacmanBoundries.add(new CollisionRect(708, 612, 787, 656));
		pacmanBoundries.add(new CollisionRect(154, 3, 843, 15));
		pacmanBoundries.add(new CollisionRect(154, 3, 164, 713));
		pacmanBoundries.add(new CollisionRect(833, 3, 843, 713));
		pacmanBoundries.add(new CollisionRect(154, 702, 843, 713));
		pacmanBoundries.add(new CollisionRect(410, 336, 588, 426));

		ghostBoundries.add(new CollisionRect(409, 130, 589, 151));
		ghostBoundries.add(new CollisionRect(482, 62, 515, 130));
		ghostBoundries.add(new CollisionRect(210, 62, 438, 82));
		ghostBoundries.add(new CollisionRect(334, 80, 364, 151));
		ghostBoundries.add(new CollisionRect(157, 128, 215, 152));
		ghostBoundries.add(new CollisionRect(260, 128, 288, 220));
		ghostBoundries.add(new CollisionRect(214, 198, 288, 220));
		ghostBoundries.add(new CollisionRect(560, 62, 788, 82));
		ghostBoundries.add(new CollisionRect(634, 80, 664, 151));
		ghostBoundries.add(new CollisionRect(560, 198, 664, 220));
		ghostBoundries.add(new CollisionRect(710, 128, 738, 220));
		ghostBoundries.add(new CollisionRect(738, 198, 788, 220));
		ghostBoundries.add(new CollisionRect(336, 198, 439, 220));
		ghostBoundries.add(new CollisionRect(783, 128, 839, 152));
		ghostBoundries.add(new CollisionRect(482, 199, 516, 288));
		ghostBoundries.add(new CollisionRect(408, 266, 590, 290));
		ghostBoundries.add(new CollisionRect(156, 268, 288, 358));
		ghostBoundries.add(new CollisionRect(710, 268, 844, 358));
		ghostBoundries.add(new CollisionRect(634, 268, 664, 358));
		ghostBoundries.add(new CollisionRect(334, 268, 364, 358));
		ghostBoundries.add(new CollisionRect(157, 405, 288, 494));
		ghostBoundries.add(new CollisionRect(709, 405, 844, 496));
		ghostBoundries.add(new CollisionRect(634, 405, 664, 564));
		ghostBoundries.add(new CollisionRect(560, 472, 664, 498));
		ghostBoundries.add(new CollisionRect(334, 405, 366, 564));
		ghostBoundries.add(new CollisionRect(363, 472, 438, 498));
		ghostBoundries.add(new CollisionRect(483, 472, 515, 550));
		ghostBoundries.add(new CollisionRect(410, 542, 588, 564));
		ghostBoundries.add(new CollisionRect(210, 542, 289, 564));
		ghostBoundries.add(new CollisionRect(710, 542, 790, 564));
		ghostBoundries.add(new CollisionRect(483, 612, 515, 709));
		ghostBoundries.add(new CollisionRect(210, 612, 289, 656));
		ghostBoundries.add(new CollisionRect(335, 612, 438, 656));
		ghostBoundries.add(new CollisionRect(560, 612, 663, 656));
		ghostBoundries.add(new CollisionRect(708, 612, 787, 656));
		ghostBoundries.add(new CollisionRect(154, 3, 843, 15));
		ghostBoundries.add(new CollisionRect(154, 3, 164, 713));
		ghostBoundries.add(new CollisionRect(833, 3, 843, 713));
		ghostBoundries.add(new CollisionRect(154, 702, 843, 713));

		ghostBoundries.add(new CollisionRect(409, 336, 418, 427));
		ghostBoundries.add(new CollisionRect(409, 336, 588, 346));
		ghostBoundries.add(new CollisionRect(581, 336, 589, 427));
		ghostBoundries.add(new CollisionRect(417, 417, 476, 427));
		ghostBoundries.add(new CollisionRect(521, 417, 589, 427));

		// pacmanBoundries.add(new CollisionRect(410, 336, 588, 426));
	}

	/*
	 * All the possible direction for the pacman to face.
	 */
	public enum FACING {
		UP, DOWN, RIGHT, LEFT
	}

}