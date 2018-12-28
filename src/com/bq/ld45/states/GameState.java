package com.bq.ld45.states;

import java.awt.*;
import java.util.Random;

import com.bq.ld45.camera.Camera;
import com.bq.ld45.entity.EntityManager;
import com.bq.ld45.entity.*;
import com.bq.ld45.game.Game;
import com.bq.ld45.map.Map;
public class GameState extends State
{
	private EntityManager em;
	private StateManager sm;
	private Map map;
	private Camera cam;

	private int population = 0;
	private int time = 300;
	private int totalTicks = 0;
	private int index = 0;
	private int[] prevRates = new int[512];
	private int  prevPop = 2;


	private float growthRate = 0f;
	public GameState(StateManager sm)
	{
		this.sm = sm;
		em = new EntityManager();
		Player p = new Player(150,100,1,0, em);
		em.addEntity(p);
		em.addEntity(new Woman(100,100,1,1,2));
		Game.handler.cam = new Camera(p);
		cam = Game.handler.cam;
		Game.handler.map = new Map();
		map = Game.handler.map;
		for(int i =0; i < 512;++i)
		{
			prevRates[i] = 0;
		}
	}
	
	@Override
	public void tick()
	{
		if(totalTicks % Game.TICKS_PER_SECOND == 0) time--;

		if(time == 0)
		{
			sm.popPush(new ScoreState(population,sm));
		}
		if(new Random().nextInt(180) == 1)em.addEntity(new Woman(500,500,1,1));
		totalTicks++;
		population = em.getAll().size();

		int sum = 0;
		for (int d : prevRates) sum += d;
		growthRate = (float)sum / prevRates.length;
		prevRates[index] = population - prevPop;

		prevPop = population;

		index++;
		if(index >= 512) index = 0;



		cam.tick();
		map.tick();
		em.tick();
	}
	@Override
	public void render(Graphics g)
	{
		g.translate(-cam.x*Game.SCALE, -cam.y*Game.SCALE);
		map.render(g);
		em.render(g);
		g.setColor(Color.red);
		Font font = new Font("Verdana", Font.BOLD, 20);
		g.setFont(font);
		g.drawString("Population: " + population, cam.x*Game.SCALE, cam.y*Game.SCALE+20);
		g.drawString("Growth Rate: " + growthRate*Game.TICKS_PER_SECOND, cam.x*Game.SCALE, cam.y*Game.SCALE+62);
		g.drawString("Time: " + time, cam.x*Game.SCALE, cam.y*Game.SCALE+41);
	}
}
