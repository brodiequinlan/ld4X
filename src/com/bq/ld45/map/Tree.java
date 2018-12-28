package com.bq.ld45.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bq.ld45.game.Game;
import com.bq.ld45.graphics.Animation;

public class Tree extends Tile
{
	public Tree(int x, int y)
	{
		super(x,y);
		solid = true;
		try 
		{
			BufferedImage[] imgs = new BufferedImage[2];
			imgs[0] = ImageIO.read(new File("res/tree.png"));
			imgs[1] = ImageIO.read(new File("res/tree2.png"));
			animation = new Animation(imgs);
		} 
		catch (IOException e) 
		{
			System.out.println("Failed to load stone sprite");
		}
		hitbox = new Rectangle(x+7, y+6, 2, 7);
	}
	
	@Override
	public void tick()
	{
		animation.tick(99);
	}
	@Override
	public void render(Graphics g)
	{
		g.drawImage(animation.get(),x*Game.SCALE,y*Game.SCALE,16*Game.SCALE,16*Game.SCALE,null);
		g.setColor(Color.white);
		if(Game.DEBUG)
		g.fillRect(hitbox.x*Game.SCALE, hitbox.y*Game.SCALE,hitbox.width*Game.SCALE, hitbox.height*Game.SCALE);
	}
}
