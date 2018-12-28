package com.bq.ld45.states;

import com.bq.ld45.game.Game;

import java.awt.*;

public class ScoreState extends State {

    private int score = 0;
    private StateManager sm;
    public ScoreState(int score, StateManager sm)
    {
        this.sm = sm;
        this.score = score;
    }
    @Override
    public void tick()
    {
        if(Game.handler.km.enter)
        {
            sm.popPush(new MenuState(sm));
        }
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.white);
        g.drawString("Final Score: " + score  + " (Enter to go to menu)", Game.WIDTH*Game.SCALE /2 - 40, Game.HEIGHT  * Game.SCALE/ 2);
    }
}
