package com.bq.ld45.map;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;


import com.bq.ld45.game.Game;

public class Map
{
	private ArrayList<Tile> tiles;
	private int width = 64;
	private int height = 64;

	public Map()
	{
		Random r = new Random();
		ArrayList<Integer> wIndex = new ArrayList<Integer>();
		ArrayList<Integer> hIndex = new ArrayList<Integer>();

		for(int i = 0; i < 15; i++)
		{
			wIndex.add(r.nextInt(width ));
			hIndex.add(r.nextInt(height));
		}



		tiles = new ArrayList<Tile>();
		for(int i=0; i< width; i++)
		{
			for(int y = 0; y < height; ++y)
			{
				if(i == 0 || y == 0 || i == height-1 || y == width-1)
				{
					tiles.add(new Stone(i*16,y*16));
				}
				else
				{
					boolean flag = false;
					for(int z = 0; z < wIndex.size();z++  )
					{
						if(Math.abs(i - wIndex.get(z)) < r.nextInt(3)+2 && Math.abs(y - hIndex.get(z)) < r.nextInt(3)+2)
						{
							if(r.nextInt(25) > 3)
							{
								tiles.add(new Water(i * 16, y * 16));
								flag = true;
							}

						}
					}
					if(!flag)
					{
						if(r.nextInt(25) == 7)
							tiles.add(new Tree(i*16,y*16));
						else
							tiles.add(new Grass(i*16,y*16));
					}

				}
			}
		}
	}
	public boolean checkForintersects(Rectangle other)
	{
		boolean found = false;
		for(Tile t : tiles)
		{
			found = t.intersects(other)&&t.solid;
			if(found) return true;
		}
		return false;
	}
	public void tick()
	{
		for(Tile t : tiles)
		{
			if((t.x > Game.handler.cam.x -16 && t.x < Game.handler.cam.x + 316) && (t.y > Game.handler.cam.y-16 && t.y < Game.handler.cam.y  +150+18))
			{
				t.tick();
			}
		}
	}
	public void render(Graphics g)
	{
		
		for(Tile t : tiles)
		{
			if((t.x > Game.handler.cam.x -16 && t.x < Game.handler.cam.x + 316) && (t.y > Game.handler.cam.y-16 && t.y < Game.handler.cam.y  +150+18))
			{
				t.render(g);
			}
		}
	}
}
