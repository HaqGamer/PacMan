package me.ihaq.pacman.utils;

import java.util.List;

import me.ihaq.pacman.menu.Game.FACING;

public class Intersection {

	private CollisionRect rect;
	private List<FACING> facing;

	/*
	 * Constructor for the Intersection class
	 */
	public Intersection(int x, int y, int x1, int y1, List<FACING> facing) {
		this.rect = new CollisionRect(x, y, x1, y1);
		this.facing = facing;
	}

	/*
	 * Returns the collisionrect for the intersection
	 */
	public CollisionRect getCollisionRect() {
		return this.rect;
	}

	/*
	 * Returns all the possible directions for the intersection
	 */
	public List<FACING> getDirections() {
		return this.facing;
	}

}
