package com.bq.ld45.game;

import com.bq.ld45.camera.Camera;
import com.bq.ld45.input.KeyManager;
import com.bq.ld45.map.Map;

public class Handler
{
	public Handler(KeyManager km)
	{
		this.km = km;
	}
	public KeyManager km;
	public Map map;
	public Camera cam;
}
