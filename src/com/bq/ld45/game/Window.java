package com.bq.ld45.game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame
{
	private static final long serialVersionUID = 1L;

	public Canvas canvas;	
	
	private int scale;
	
	public Window(String title, int width, int height, int scale)
	{
		this.scale = scale;
		canvas = new Canvas();
		add(canvas);
		setTitle(title);
		setPreferredSize(new Dimension(width*scale,height));
		setMinimumSize(new Dimension(width*this.scale,height*this.scale));
		setMaximumSize(new Dimension(width*this.scale,height*this.scale));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
