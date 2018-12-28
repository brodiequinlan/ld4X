package com.bq.ld45.camera;

import com.bq.ld45.entity.Entity;

public class Camera
{
	public int x;
	public int y;
	
	private Entity e;
	
	public Camera(Entity e)
	{
		this.e = e;
		x = e.getX();
		y = e.getY();
	}
	
	public void tick()
	{
		x = e.getX()-150;
		y = e.getY()-300/16*9/2+8;
	}
}
