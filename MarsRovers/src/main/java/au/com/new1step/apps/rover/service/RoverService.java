package au.com.new1step.apps.rover.service;


import au.com.new1step.apps.rover.Rover;
import au.com.new1step.apps.rover.exception.RoverDeployException;
import au.com.new1step.apps.rover.exception.RoverExporeException;


public interface RoverService {		
	public void deploy(String line) throws RoverDeployException;	
	public void explore(String line) throws RoverDeployException, RoverExporeException;	
	public Rover getRover();	
}
