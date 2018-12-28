package com.bq.ld45.states;

import java.awt.*;

import com.bq.ld45.camera.Camera;
import com.bq.ld45.entity.EntityManager;
import com.bq.ld45.entity.*;
import com.bq.ld45.game.Game;
import com.bq.ld45.map.Map;
public class MenuState extends State
{
    int index = 0;
    private StateManager sm;
    public MenuState(StateManager sm)
    {
        this.sm = sm;
    }

    @Override
    public void tick()
    {


        if(Game.handler.km.enter && index == 1)
        {
            sm.popPush(new GameState(sm));
        }
        else if (Game.handler.km.enter && index == 0)
        {
            //this is because i dont have time to fxi inout system and i dont have a way to chekc if inpout is repeated or first click so u can get stuck bounching between menus and this should fix
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){}
            sm.popPush(new AboutState(sm));
        }
        if(Game.handler.km.down)
        {
            index = 1;
        }
        else if(Game.handler.km.up)
        {
            index = 0;
        }
    }
    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.red);
        Font font = new Font("Verdana", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("Play" , Game.WIDTH*Game.SCALE /2 - 20, Game.HEIGHT * Game.SCALE / 2);
        g.drawString("About" ,Game.WIDTH*Game.SCALE /2 - 20, Game.HEIGHT * Game.SCALE/ 3);
        if(index == 1)
        {
            g.drawString(">       <" ,Game.WIDTH*Game.SCALE /2 - 40, Game.HEIGHT  * Game.SCALE/ 2);
        }
        else if(index == 0)
        {
            g.drawString(">          <" ,Game.WIDTH*Game.SCALE /2 - 40, Game.HEIGHT * Game.SCALE / 3);
        }
    }
}
