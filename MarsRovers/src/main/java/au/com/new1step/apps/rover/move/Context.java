package au.com.new1step.apps.rover.move;

import au.com.new1step.apps.rover.Rover;
import au.com.new1step.apps.rover.exception.RoverExporeException;

public class Context {
	   private Strategy strategy;

	   public Context(Strategy strategy){
	      this.strategy = strategy;
	   }

	   public void executeStrategy(Rover rover)throws RoverExporeException {
	       strategy.doMove(rover);
	   }
	   
	}
