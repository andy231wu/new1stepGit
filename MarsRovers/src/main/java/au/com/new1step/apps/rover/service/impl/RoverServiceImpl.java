package au.com.new1step.apps.rover.service.impl;

import au.com.new1step.apps.rover.Plateau;
import au.com.new1step.apps.rover.Rover;
import au.com.new1step.apps.rover.exception.RoverDeployException;
import au.com.new1step.apps.rover.exception.RoverExporeException;
import au.com.new1step.apps.rover.service.RoverService;


public class RoverServiceImpl implements RoverService {
 
	private Rover rover;
	private Plateau plateau;
	
	public RoverServiceImpl(Plateau plateau) {
		this.plateau = plateau;
		rover = new Rover();
		rover.setPlateau(plateau);
	}
    
	
	/*
	public RoverServiceImpl() {
		rover = new Rover();
	}
    
	@Override
	public void setupPlateau(String line){
		String[] positions = line.split(" ");
		int maxX = Integer.parseInt(positions[0]);
		int maxY = Integer.parseInt(positions[1]);
		
		plateau = new Plateau(maxX, maxY);
		rover.setPlateau(plateau);
		
	}
	*/
	@Override
	public void deploy(String line) throws RoverDeployException{
		String[] positions = line.split(" ");
	
		int posX = Integer.parseInt(positions[0]);
		int posY = Integer.parseInt(positions[1]);
		char facing = positions[2].charAt(0);
		
		if((posX < plateau.getMinPosX() || posX > plateau.getMaxPosX()) || 
		   (posY < plateau.getMinPosY() || posY > plateau.getMaxPosY())) {			
			throw new RoverDeployException("Error - The rover is deployed outside of the plateau.");
		}
		
		if(Rover.FACING_EAST == facing  || Rover.FACING_WEST == facing ||
		   Rover.FACING_NORTH == facing || Rover.FACING_SOUTH == facing) {	
			
			rover.setPosX(posX);	
    		rover.setPosY(posY);
    		rover.setFacing(facing);
    		
		}else{			
			throw new RoverDeployException("Error - Bad data entry for Rover Facing.");
		}    	
    }
    
	@Override
	public void explore(String line) throws RoverExporeException{
		for(int i=0; i<line.length(); i++){
			char c = line.charAt(i);
			switch(c){
				case 'L': rover.turnLeft();
					      break;
				case 'R': rover.turnRight(); 
					      break;
				case 'M': rover.move();
					      break;
			    default:
			    	throw new RoverExporeException("Error - Bad data entry for Rover Explores.");			            	    
			}
		}
	   
	}
	/*
	@Override
	public String report(){
		return rover.toString();		
	}
	*/
	@Override
	public Rover getRover(){
		return rover;
	}
	
	
}
