package com.bq.ld45.states;

import java.awt.Graphics;

public abstract class State
{
	protected StateManager sm;
	public abstract void tick();
	public abstract void render(Graphics g);
}
