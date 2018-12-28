package com.bq.ld45.map;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bq.ld45.game.Game;

public class Grass extends Tile
{
	public Grass(int x, int y)
	{
		super(x,y);
		try 
		{
			sprite = ImageIO.read(new File("res/grass.png"));
		} 
		catch (IOException e) 
		{
			System.out.println("Failed to load stone sprite");
		}
	}
	
	@Override
	public void tick()
	{
		
	}
	@Override
	public void render(Graphics g)
	{
		g.drawImage(sprite,x*Game.SCALE,y*Game.SCALE,16*Game.SCALE,16*Game.SCALE,null);
	}
}
