package com.bq.ld45.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity
{
	private int x;
	private int y;
	protected int vx;
	protected int vy;

	public int id;


	protected Rectangle hitbox;
	
	public Entity(int x, int y, int vx, int vy)
	{
		this.setX(x);
		this.setY(y);
		this.vx = vx;
		this.vy = vy;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
}
