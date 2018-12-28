package com.bq.ld45.states;

import com.bq.ld45.game.Game;

import java.awt.*;
public class AboutState extends State
{
    private StateManager sm;
    public AboutState(StateManager sm)
    {
        this.sm = sm;
    }

    @Override
    public void tick()
    {
        if(Game.handler.km.enter)
        {
            //this is because i dont have time to fxi inout system and i dont have a way to chekc if inpout is repeated or first click so u can get stuck bounching between menus and this should fix
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){}
            sm.popPush(new MenuState(sm));
        }
    }
    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.red);
        Font font = new Font("Verdana", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("Your objective is to reproduce(with the blue balled lookin chicks)" , Game.WIDTH*Game.SCALE /2 - 250, Game.HEIGHT * Game.SCALE / 2);
        g.drawString("they take some time to get ready to reproduce after doing it" , Game.WIDTH*Game.SCALE /2 - 250, Game.HEIGHT * Game.SCALE / 3);
        g.drawString("they will randomly spawn in as well increasing population)" , Game.WIDTH*Game.SCALE /2 - 250, Game.HEIGHT * Game.SCALE / 4);
        g.drawString("WASD to control movement" , Game.WIDTH*Game.SCALE /2 - 250, Game.HEIGHT * Game.SCALE / 2);
        g.drawString("Menu" ,Game.WIDTH*Game.SCALE /2 - 20, Game.HEIGHT * Game.SCALE/ 3);

        g.drawString(">         <" ,Game.WIDTH*Game.SCALE /2 - 40, Game.HEIGHT  * Game.SCALE/ 3);
    }
}
