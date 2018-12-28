package com.bq.ld45.entity;

import com.bq.ld45.game.Game;
import com.bq.ld45.graphics.Animation;
import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Woman extends Entity
{

    private BufferedImage nothorny;

    private BufferedImage horny;



    private int ticks = 0;

    public Woman(int x, int y, int vx, int vy, int id)
    {
        super(x, y, vx, vy);
        this.id = id;
        try
        {
            horny = ImageIO.read(new File("res/horny.png"));
            nothorny = ImageIO.read(new File("res/nothorny.png"));
        }
        catch (IOException e)
        {
            System.out.println("Failed to load player sprite");
        }
        hitbox = new Rectangle(x+4,y+1,8,15);
    }
    public Woman(int x, int y, int vx, int vy)
    {
        super(x, y, vx, vy);
        id = 1;
        try
        {
            horny = ImageIO.read(new File("res/horny.png"));
            nothorny = ImageIO.read(new File("res/nothorny.png"));
        }
        catch (IOException e)
        {
            System.out.println("Failed to load player sprite");
        }
        hitbox = new Rectangle(x+4,y+1,8,15);
    }
    @Override
    public void tick() {
        ticks++;

        if(ticks % (Game.TICKS_PER_SECOND*20) == 0 && id == 1)
        {
            id = 2;
        }

        Random r = new Random();

        if (r.nextInt(100) == 2)
        {
            vx *= -1;

        }
        if (r.nextInt(100) == 2)
        {
            vy *= -1;
        }


        Rectangle potentialMove = new Rectangle(hitbox);
        potentialMove.translate(vx, vy);

        if(!Game.handler.map.checkForintersects(potentialMove) && r.nextBoolean())
        {
            setX(getX() + vx);
            setY(getY() + vy);
            hitbox.translate(vx,vy);
        }

    }

    @Override
    public void render(Graphics g)
    {
        if(id == 2) g.drawImage(horny,getX()*Game.SCALE,getY()*Game.SCALE,16*Game.SCALE,16*Game.SCALE,null);
        if(id == 1) g.drawImage(nothorny,getX()*Game.SCALE,getY()*Game.SCALE,16*Game.SCALE,16*Game.SCALE,null);

        g.setColor(Color.black);
        if(Game.DEBUG)
            g.fillRect(hitbox.x*Game.SCALE, hitbox.y*Game.SCALE,hitbox.width*Game.SCALE, hitbox.height*Game.SCALE);
    }
}
