package au.com.new1step.apps.rover.move;

import au.com.new1step.apps.rover.Plateau;
import au.com.new1step.apps.rover.Rover;
import au.com.new1step.apps.rover.exception.RoverExporeException;

public class MoveSouth implements Strategy{
	private Plateau plateau;
	
	public MoveSouth (Plateau plateau){
		this.plateau = plateau;
	}
	
	@Override
	public void doMove(Rover rover) throws RoverExporeException{
		if (rover.getPosY() > plateau.getMinPosY()){
			rover.setPosY(rover.getPosY() - 1);
		}else{
			throw new RoverExporeException("Error: Rover cannot move South further.");
		}
	}

}
