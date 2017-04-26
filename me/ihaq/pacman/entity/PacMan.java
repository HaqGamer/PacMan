package me.ihaq.pacman.entity;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PacMan {

	private int x, y, height, width;
	private Sprite pacman;
	private FACING facing;

	public PacMan(Texture t, int x, int y) {
		pacman = new Sprite(t);
		this.x = x;
		this.y = y;
		this.width = t.getWidth();
		this.height = t.getHeight();
		facing = FACING.RIGHT;
	}

	public enum FACING {
		UP, DOWN, RIGHT, LEFT
	}

	public void render(SpriteBatch batch, int x, int y) {
		pacman.setPosition(x, y);
		pacman.draw(batch);
	}

	public void rotate(int key) {
		float rotation = pacman.getRotation();
		boolean flipedY = pacman.isFlipY();
		if (key == Keys.DOWN) {
			facing = FACING.DOWN;
			if(flipedY){
				pacman.setFlip(false, false);
			}
			pacman.rotate((270 - rotation));
		} else if (key == Keys.UP) {
			if(flipedY){
				pacman.setFlip(false, false);
			}
			facing = FACING.UP;
			pacman.rotate((90 - rotation));
		} else if (key == Keys.RIGHT) {
			if(flipedY){
				pacman.setFlip(false, false);
			}
			facing = FACING.RIGHT;
			pacman.rotate((360 - rotation));
		} else if (key == Keys.LEFT) {
			pacman.setFlip(false, true);
			facing = FACING.LEFT;
			pacman.rotate((180 - rotation));
		}
	}

}
