package me.ihaq.pacman.utils;

import java.util.List;

import me.ihaq.pacman.menu.Game.FACING;

public class Intersection {

	private CollisionRect rect;
	private List<FACING> facing;

	public Intersection(int x, int y, int x1, int y1, List<FACING> facing) {
		this.rect = new CollisionRect(x, y, x1, y1);
		this.facing = facing;
	}

	public CollisionRect getCollisionRect() {
		return this.rect;
	}

	public List<FACING> getDirections() {
		return this.facing;
	}

}
