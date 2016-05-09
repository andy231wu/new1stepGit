package au.com.new1step.apps.rover;

import au.com.new1step.apps.rover.exception.RoverExporeException;
import au.com.new1step.apps.rover.move.Context;
import au.com.new1step.apps.rover.move.MoveEast;
import au.com.new1step.apps.rover.move.MoveNorth;
import au.com.new1step.apps.rover.move.MoveSouth;
import au.com.new1step.apps.rover.move.MoveWest;

public class Rover {
	public final static char FACING_EAST  = 'E';
	public final static char FACING_WEST  = 'W';
	public final static char FACING_SOUTH = 'S';
	public final static char FACING_NORTH = 'N';	
      
	private int posX;
	private int posY;
	private char facing;
	private Plateau plateau;

	public Rover() {
		;
	}

	public Rover(int posX, int posY, char facing){
		this.posX = posX;
		this.posY = posY;
		this.facing = facing;		
	}
	
	
	public void move() throws RoverExporeException{
		Context cxt = null;
		switch(facing){
			case FACING_NORTH:
				 cxt = new Context(new MoveNorth(plateau));
				 break;
			case FACING_SOUTH:
				 cxt = new Context(new MoveSouth(plateau));
				 break;   
				    
			case FACING_EAST:
				 cxt = new Context(new MoveEast(plateau));
				 break;      
				    
			case FACING_WEST:					
				 cxt = new Context(new MoveWest(plateau));
				 break; 
		}
		
		if(cxt != null){
		  cxt.executeStrategy(this);
		}
	}
	
	public void turnLeft(){
		
		switch(facing){
			case FACING_NORTH:
				 facing = FACING_WEST; break;
			case FACING_SOUTH:
				 facing = FACING_EAST; break;
			case FACING_EAST:
				 facing = FACING_NORTH; break;
			case FACING_WEST:
				 facing = FACING_SOUTH; break;		
		}		
	}
	
	public void turnRight(){
		
		switch(facing){
			case FACING_NORTH:
				 facing = FACING_EAST; break;
			case FACING_SOUTH:
				 facing = FACING_WEST; break;
			case FACING_EAST:
				 facing = FACING_SOUTH; break;
			case FACING_WEST:
				 facing = FACING_NORTH; break;		
		}		
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Rover current position:");
		sb.append(posX);
		sb.append(",");
		sb.append(posY);
		sb.append(",");
		sb.append(facing);
	
		return sb.toString();
	}
	
	public String showCurrentPosition(){
		StringBuilder sb = new StringBuilder();		
		sb.append(posX);
		sb.append(" ");
		sb.append(posY);
		sb.append(" ");
		sb.append(facing);
	
		return sb.toString();
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public char getFacing() {
		return facing;
	}
	public void setFacing(char facing) {
		this.facing = facing;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;		
	}
	public Plateau getPlateau(){
		return plateau;
	}
  
}
