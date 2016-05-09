package au.com.new1step.apps.rover.move;

import au.com.new1step.apps.rover.Plateau;
import au.com.new1step.apps.rover.Rover;
import au.com.new1step.apps.rover.exception.RoverExporeException;

public class MoveNorth implements Strategy{
	private Plateau plateau;
	
	public MoveNorth (Plateau plateau){
		this.plateau = plateau;
	}
	
	@Override
	public void doMove(Rover rover) throws RoverExporeException{
		if (rover.getPosY() < plateau.getMaxPosY() ){
			rover.setPosY(rover.getPosY() + 1);
		}else{
			throw new RoverExporeException("Error: Rover cannot move North further.");
		}
	}

}
