package me.ihaq.pacman.utils;

public class Portal {

	private CollisionRect rect;
	private int targetX;

	/*
	 * Constructor for the Protal class
	 */
	public Portal(int x, int y, int x1, int y1, int targetX) {
		this.rect = new CollisionRect(x, y, x1, y1);
		this.targetX = targetX;
	}

	/*
	 * Return the targetX for the protal
	 */
	public int getTargetX() {
		return this.targetX;
	}

	/*
	 * Returns the CollisionRect for the portal
	 */
	public CollisionRect getCollisionRect() {
		return this.rect;
	}

}
