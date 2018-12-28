package com.bq.ld45.map;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.bq.ld45.graphics.Animation;

public abstract class Tile
{
	protected BufferedImage sprite;
	protected Animation animation;
	protected int x, y;
	protected boolean solid = false;
	protected Rectangle hitbox;
	public Tile(int x, int y)
	{
		this.x = x;
		this.y = y;
		hitbox = new Rectangle(x, y, 16, 16);
	}
	public boolean isSolid()
	{
		return solid;
	}
	public boolean intersects(Rectangle other)
	{
		return hitbox.intersects(other);
	}
	public abstract void tick();
	public abstract void render(Graphics g);
}
