package com.bq.ld45.game;

import java.awt.*;
import java.awt.image.BufferStrategy;

import com.bq.ld45.input.KeyManager;
import com.bq.ld45.states.GameState;
import com.bq.ld45.states.MenuState;
import com.bq.ld45.states.StateManager;

public class Game implements Runnable
{
	public static int SCALE = 3;
	public static boolean DEBUG = false;
	public static int TICKS_PER_SECOND = 60;
	public static int HEIGHT  = 320/16*9;
	public static int WIDTH = 320;
	public static int CHAR_MODEL_SIZE = 16;

	private Thread gameThread;
	private boolean running;
	
	private StateManager stateManager;
	
	public static Handler handler;
	
	private Window window;
	
	public Game()
	{
		gameThread = new Thread(this);
		gameThread.run();
	}
	
	private void init()
	{
		running = false;
		handler = new Handler(new KeyManager());
		stateManager = new StateManager();
		stateManager.push(new MenuState(stateManager));
		window = new Window("ld45",320,320/16*9,SCALE);
		window.add(new Canvas());
		window.addKeyListener(handler.km);
	}
	
	public void run()
	{
		init();
		start();
	}
	
	
	private void start()
	{
		if(!running)running = true;
		
		long lastTime=System.nanoTime();
	    final double amountOfTicks=TICKS_PER_SECOND;
	    double ns=1000000000/amountOfTicks;
	    double delta=0;
	    int updates=0;
	    int frames=0;
	    long timer=System.currentTimeMillis();
		
		while(running)
		{
			long now=System.nanoTime();
			delta+=(now-lastTime)/ns;
	        lastTime=now;
	        if(delta>=1)
	        {
	            tick();
	            updates++;
	            delta--;
	            
	        }
	        render();
	        frames++;

	        if((System.currentTimeMillis()-timer)>1000)
	        {
	            timer+=1000;
	            System.out.println(updates+" Ticks, FPS "+frames);
	            updates=0;
	            frames=0;
	        }
		}
	}
	
	private void tick()
	{
		stateManager.peek().tick();
	}
	public void render()
	{
		BufferStrategy bs = window.canvas.getBufferStrategy();
		if (bs == null)
		{
			window.canvas.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
	    g.fillRect(0, 0, window.getWidth(), window.getHeight());

		stateManager.peek().render(g);
		Graphics2D g2d = (Graphics2D)g;

		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args)
	{
		new Game();
	}
}
