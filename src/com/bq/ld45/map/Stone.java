package com.bq.ld45.map;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bq.ld45.game.Game;

public class Stone extends Tile
{
	public Stone(int x, int y)
	{
		super(x,y);
		solid = true;
		try 
		{
			sprite = ImageIO.read(new File("res/stone.png"));
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
		g.setColor(Color.white);
		if(Game.DEBUG)
		g.fillRect(hitbox.x*Game.SCALE, hitbox.y*Game.SCALE,hitbox.width*Game.SCALE, hitbox.height*Game.SCALE);
	}
}
