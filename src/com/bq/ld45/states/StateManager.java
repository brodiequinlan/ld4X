package com.bq.ld45.states;

import java.awt.Graphics;
import java.util.Stack;

public class StateManager
{
	private Stack<State> states;
	
	public StateManager()
	{
		states = new Stack<State>();
	}
	
	public State peek()
	{
		return states.peek();
	}
	public void pop()
	{
		states.pop();
	}
	public void push(State state)
	{
		state.sm = this;
		states.push(state);
	}
	public void popPush(State state)
	{
		states.pop();
		states.push(state);
	}
	public void tick()
	{
		states.peek().tick();
	}
	public void render(Graphics g)
	{
		states.peek().render(g);
	}
}
