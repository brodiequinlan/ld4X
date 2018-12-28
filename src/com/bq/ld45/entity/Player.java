package com.bq.ld45.entity;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bq.ld45.game.Game;
import com.bq.ld45.graphics.Animation;

public class Player extends Entity
{
	private BufferedImage defaultSprite;
	
	private Animation left;

	private EntityManager em;

	float lightx = 0;
	float lighty = 0;
	private float radius = 60;

	public Player(int x, int y, int vx, int vy, EntityManager em)
	{
		super(x, y, vx, vy);
		this.em = em;
		try
		{
			defaultSprite = ImageIO.read(new File("res/playerLeft.png"));
			BufferedImage[] leftimg = new BufferedImage[2];
			leftimg[0] = ImageIO.read(new File("res/PlayerLeft.png"));
			leftimg[1] = ImageIO.read(new File("res/PlayerLeft2.png"));
			left = new Animation(leftimg);
		}
		catch (IOException e)
		{
			System.out.println("Failed to load player sprite");
		}
		hitbox = new Rectangle(x+4,y+1,8,15);
	}
	@Override
	public void tick()
	{
		for(Entity e : em.getAll())
		{
			if(e.id != 2) continue;

			if(e.hitbox.intersects(this.hitbox))
			{
				em.markAdd(new Woman(e.getX(),getY(),-1,-1));
				e.id = 1;
			}
		}
		if(Game.handler.km.down)
		{
			vy = 1;
		}
		else 
		{
			vy = 0;
			if(Game.handler.km.up)
			{
				vy = -1;
			}
			else 
			{
				vy = 0;
			}
		}
		
		if(Game.handler.km.left)
		{
			vx = -1;
		}
		else 
		{
			vx = 0;
			if(Game.handler.km.right)
			{
				vx = 1;
			}
			else 
			{
				vx = 0;
			}
		}
		Rectangle potentialMove = new Rectangle(hitbox);
		potentialMove.translate(vx, vy);
		
		if(!Game.handler.map.checkForintersects(potentialMove))
		{
			setX(getX() + vx);
			setY(getY() + vy);
			hitbox.translate(vx,vy);
		}

		left.tick(75);
		lightx = getX() + 8;
		lighty = getY() + 8;
	}



	@Override
	public void render(Graphics g)
	{
		if(vx == 1 || vy == 1 || vy == -1 || vx == -1)
		{
			g.drawImage(left.get(),getX()*Game.SCALE,getY()*Game.SCALE,16*Game.SCALE,16*Game.SCALE,null);
		}
		else
		{
			g.drawImage(defaultSprite,getX()*Game.SCALE,getY()*Game.SCALE,16*Game.SCALE,16*Game.SCALE,null);
		}

		g.setColor(Color.black);
		
		if(Game.DEBUG)
		g.fillRect(hitbox.x*Game.SCALE, hitbox.y*Game.SCALE,hitbox.width*Game.SCALE, hitbox.height*Game.SCALE);
		Graphics2D g2d = (Graphics2D)g;
		Point2D center = new Point2D.Float(lightx*Game.SCALE,lighty*Game.SCALE);
		float[] dist = {0.0f,1.0f};
		Color[] colors = {new Color(0.0f,0.0f,0.0f,0.0f),Color.BLACK};
		RadialGradientPaint  p = new RadialGradientPaint(center,radius*Game.SCALE,dist,colors);
		g2d.setPaint(p);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .89f));
		g2d.fillRect(0,0,64*16*Game.SCALE,64*16*Game.SCALE);
	}
}
