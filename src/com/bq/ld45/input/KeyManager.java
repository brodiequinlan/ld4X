package com.bq.ld45.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
	public boolean left = false;
	public boolean up = false;
	public boolean right = false;
	public boolean down = false;
    public boolean enter = false;

    @Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			enter = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			enter = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
}
