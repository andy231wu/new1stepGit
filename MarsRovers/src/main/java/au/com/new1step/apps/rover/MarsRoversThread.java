package au.com.new1step.apps.rover;

import au.com.new1step.apps.rover.exception.RoverDeployException;
import au.com.new1step.apps.rover.exception.RoverExporeException;
import au.com.new1step.apps.rover.service.RoverService;
import au.com.new1step.apps.rover.service.impl.RoverServiceImpl;

public class MarsRoversThread extends Thread {
	
   private Thread t;
   private String roverName;
   private String instruction1;
   private String instruction2;
   
   private RoverService roverService;	
  
   public MarsRoversThread(String roverName, Plateau plateau, String instruction1, String instruction2){
	   this.roverName = roverName;
       this.instruction1 = instruction1;
       this.instruction2 = instruction2;
       roverService = new RoverServiceImpl(plateau);
   }
   
   public void run() {
	   synchronized(this){
		   try{
			   roverService.deploy(instruction1);
			   roverService.explore(instruction2);
			   Thread.sleep(10000); // for waiting test
			   System.out.println(roverName + " current position: " + roverService.getRover().showCurrentPosition());
		   } catch(RoverDeployException | RoverExporeException | InterruptedException e){
			   System.out.println(e.getMessage());
		   }
		   notify();
	   }
   }
   
   public void start () {
      System.out.println("\nStarting Mars " +  roverName );
      if (t == null) {
         t = new Thread (this, roverName);
         t.start ();
      }
   }

}
