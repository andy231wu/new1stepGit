package au.com.new1step.apps.rover.move;

import au.com.new1step.apps.rover.Plateau;
import au.com.new1step.apps.rover.Rover;
import au.com.new1step.apps.rover.exception.RoverExporeException;

public class MoveEast implements Strategy{
	private Plateau plateau;
	
	public MoveEast (Plateau plateau){
		this.plateau = plateau;
	}
	
	@Override
	public void doMove(Rover rover) throws RoverExporeException{		
		if (rover.getPosX() < plateau.getMaxPosX() ){
			rover.setPosX(rover.getPosX() + 1);
		}else{
			throw new RoverExporeException("Error: Rover cannot move East further.");
		}
	}

}
