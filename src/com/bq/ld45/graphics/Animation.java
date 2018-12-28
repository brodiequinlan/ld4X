package com.bq.ld45.graphics;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Animation
{
	int index = 0;
	
	private BufferedImage[] frames;
	private Random random;
	public Animation(BufferedImage[] frames)
	{
		random = new Random();
		this.frames = frames;
	}
	public void tick(int chancetoswitch)
	{
		if(random.nextInt(100) < chancetoswitch) return;
		if(index+1 >= frames.length) index = 0;
		else index++;
	}
	public BufferedImage get()
	{
		return frames[index];
	}
}
