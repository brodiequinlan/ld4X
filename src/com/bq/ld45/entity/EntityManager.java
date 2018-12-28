package com.bq.ld45.entity;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager
{
	private ArrayList<Entity> entities;
	
	public EntityManager()
	{
		entities = new ArrayList<Entity>();
	}

	private Entity marked;
	public void addEntity(Entity e)
	{
		entities.add(e);
	}
	public void remove(Entity e)
	{
		entities.remove(e);
	}
	
	public void tick()
	{
		for(Entity e : entities)
		{
			e.tick();
		}
		if(marked != null)
		{
			entities.add(marked);
			marked = null;
		}
	}
	public void render(Graphics g)
	{
		for(Entity e : entities)
		{
			e.render(g);
		}
	}

    public ArrayList<Entity> getAll()
	{
		return entities;
    }

	public void markAdd(Entity woman)
	{
		marked = woman;
	}
}
