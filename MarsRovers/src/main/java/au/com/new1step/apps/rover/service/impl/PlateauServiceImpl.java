package au.com.new1step.apps.rover.service.impl;

import au.com.new1step.apps.rover.Plateau;
import au.com.new1step.apps.rover.service.PlateauService;

public class PlateauServiceImpl implements PlateauService{
	private Plateau plateau;
	
	@Override
	public Plateau setupPlateau(String line){
		String[] positions = line.split(" ");
		int maxX = Integer.parseInt(positions[0]);
		int maxY = Integer.parseInt(positions[1]);
		
		plateau = new Plateau(maxX, maxY);
		return plateau;
		
	}

}
