package me.ihaq.pacman.utils;

public class Portal {

	private CollisionRect rect;
	private int targetX;

	public Portal(int x, int y, int x1, int y1, int targetX) {
		this.rect = new CollisionRect(x, y, x1, y1);
		this.targetX = targetX;
	}

	public int getTargetX() {
		return this.targetX;
	}


	public CollisionRect getCollisionRect() {
		return this.rect;
	}

}
