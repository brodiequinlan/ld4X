package com.bq.ld45.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bq.ld45.game.Game;
import com.bq.ld45.graphics.Animation;

public class Water extends Tile
{
    private Animation animation;
    public Water(int x, int y)
    {
        super(x,y);
        solid = true;
        try
        {
            BufferedImage[] images = new BufferedImage[2];
            images[0] = ImageIO.read(new File("res/water1.png"));
            images[1] = ImageIO.read(new File("res/water2.png"));
            animation = new Animation(images);
            sprite = ImageIO.read(new File("res/water1.png"));
        }
        catch (IOException e)
        {
            System.out.println("Failed to load stone sprite");
        }
    }

    @Override
    public void tick()
    {
        animation.tick(50);
    }
    @Override
    public void render(Graphics g)
    {
        g.drawImage(animation.get(),x*Game.SCALE,y*Game.SCALE,16*Game.SCALE,16*Game.SCALE,null);
    }
}
