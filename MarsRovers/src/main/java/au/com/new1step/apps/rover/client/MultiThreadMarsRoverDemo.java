package au.com.new1step.apps.rover.client;

import java.util.ArrayList;
import java.util.List;

import au.com.new1step.apps.rover.MarsRoversThread;
import au.com.new1step.apps.rover.Plateau;
import au.com.new1step.apps.rover.service.impl.PlateauServiceImpl;


public class MultiThreadMarsRoverDemo {
	public static void main(String args[]) {
		  
		  List<String> inputs = new ArrayList<String>();
		  inputs.add("5 5");
		  
		  // test case1 from NBN
		  inputs.add("1 2 N");
		  inputs.add("LMLMLMLMM");     // expected: "1 3 N"
		  
		  // test case2 from NBN 
		  inputs.add("3 3 E");
		  inputs.add("MMRMMRMRRM");    // expected: "5 1 E"	
		  
		  // test case3 
		  inputs.add("4 8 E");         // expected: outside of plateau exception 
		  inputs.add("MM");
		  
		  // test case4 
		  inputs.add("4 3 Q");         // expected: bad facing exception 
		  inputs.add("MM");
		  
		  // test case5 
		  inputs.add("4 3 E");         
		  inputs.add("T");             // expected: bad move instruction exception 
		  
		  // test case6 
		  inputs.add("4 4 E");          
		  inputs.add("MM");            // expected: move East exception
		  
		  // test case7
		  inputs.add("1 4 N");         
		  inputs.add("LMM");           // expected: move West exception 
		  
		  // test case8 
		  inputs.add("1 1 S");          
		  inputs.add("MM");            // expected: move South exception
		  
		  // test case9
		  inputs.add("1 4 N");         
		  inputs.add("MM");           // expected: move North exception 
		  
		  // test case10
		  inputs.add("4 1 E");
		  inputs.add("RRMMMRMMMMLM"); // expected "0 5 W"
		  
		
		  Plateau plateau = new PlateauServiceImpl().setupPlateau(inputs.get(0));		
		  
		  int j=0;
		  for(int i=1; i < inputs.size(); i++){
			  j++;
			  String line1 = inputs.get(i);
			  i++;
			  String line2 = inputs.get(i);
			  MarsRoversThread rover = new MarsRoversThread("Rover-" + j, plateau, line1, line2);
		      rover.start();
		      synchronized(rover){
		            try{
		                System.out.println("Waiting for Rover-" + j + " to complete moving...");
		                rover.wait();
		            }catch(InterruptedException e){
		                e.printStackTrace();
		            }	
		            System.out.println("Rover-" + j + " has finished now. Start next Rover ...");
		      }
		  }	
		  
		  System.out.println("\n" + j + " Mars Rovers have finished moving.\n");
	   } 
}
