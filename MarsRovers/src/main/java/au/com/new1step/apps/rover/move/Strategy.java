package au.com.new1step.apps.rover.move;

import au.com.new1step.apps.rover.Rover;
import au.com.new1step.apps.rover.exception.RoverExporeException;

public interface Strategy {
	   public void doMove(Rover rover) throws RoverExporeException;
}
