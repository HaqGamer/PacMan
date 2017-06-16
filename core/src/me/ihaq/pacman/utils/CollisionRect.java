package me.ihaq.pacman.utils;

public class CollisionRect {

	public int x, y, width, height;

	/*
	 * Constructor for the CollisionRect Class
	 */
	public CollisionRect(int x, int y, int x1, int y1) {
		this.x = x;
		this.y = y;
		this.width = (x1 - x);
		this.height = (y1 - y);
	}

	/*
	 * Checks if the given collisionrect overlaps with this collisionrect.
	 */
	public boolean collidesWith(CollisionRect rect) {
		return x < rect.x + rect.width && y < rect.y + rect.height && x + width > rect.x && y + height > rect.y;
	}

}