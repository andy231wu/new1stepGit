
package au.com.new1step.apps.rover.test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import au.com.new1step.apps.rover.Plateau;
import au.com.new1step.apps.rover.Rover;
import au.com.new1step.apps.rover.exception.RoverExporeException;

public class RoverTest {
	private Rover rover;
	private Plateau plateau;
	
	@BeforeClass
	public void oneTimeSetUp(){
		// one-time initialization code			
	}

	@AfterClass
	public void oneTimeTearDown(){
		// one-time cleanup code	
	}
	
	@BeforeMethod
	public void setUp(){
		plateau = new Plateau(5,5);		
	}
	
	@AfterMethod
	public void tearDown(){
		rover = null;
		
	}
		
	@DataProvider(name = "data-provider-for-move-method")
	 public Object[][] dataProviderForMoveMethod(Method method) {
		
		String nm = method.getName();
        switch(nm){
        	case "testMoveNorthWithoutException":
        		return new Object[][] { {0,3,'N'}}; 
        	case "testMoveNorthWithException":
        		return new Object[][] { {3,5,'N'}}; 
        	case "testMoveSouthWithoutException":
        		return new Object[][] { {3,3,'S' }};
        	case "testMoveSouthWithException":
        		return new Object[][] { {2,0,'S' }};
        	case "testMoveEastWithoutException":
        		return new Object[][] { {2,1,'E' }}; 
        	case "testMoveEastWithException":
        		return new Object[][] { {5,1,'E' }}; 
        	case "testMoveWestWithoutException":
        		return new Object[][] { {3,3,'W' }};
        	case "testMoveWestWithException":
        		return new Object[][] { {0,2,'W'}};
        }
        return new Object[][] { { "Invalid data" }};
	 }
	
	@DataProvider(name = "data-provider-for-turn-methods")
	 public Object[][] dataProviderForTurnMethod(Method method) {
		
	   String nm = method.getName();
       switch(nm){
        	case "testTurnLeft":
        		return new Object[][] { {0,3,'N' }};   
        	case "testTurnRight":
        		return new Object[][] { {0,3,'S' }};  
        	case "testTurnLeftAndRight":
        		return new Object[][] { {2,3,'E' }};          	
       }
       return new Object[][] { { "Invalid data" }};
	 }
	
	@DataProvider(name = "data-provider-for-report")
	 public Object[][] dataProviderForToStringMethod(Method method) {
		
	  String nm = method.getName();
      switch(nm){
       	case "testToString":
       		return new Object[][] { {2,4,'W' }};  
       	case "testShowCurrentPosition":
       		return new Object[][] { {2,4,'W' }};        		
      }
      return new Object[][] { { "Invalid data" }};
	 }
	
	/* ---- test move north ---- */
	@Test(dataProvider="data-provider-for-move-method")	
	public void testMoveNorthWithoutException(int posX, int posY, char facing) throws RoverExporeException{
		rover = new Rover(posX, posY, facing);
		rover.setPlateau(plateau);
		rover.move();
		
		Assert.assertEquals(rover.getPosX(), 0);
		Assert.assertEquals(rover.getPosY(), 4);
		Assert.assertEquals(rover.getFacing(), 'N');
	}
	
	@Test(dataProvider="data-provider-for-move-method", expectedExceptions = RoverExporeException.class)	
	public void testMoveNorthWithException(int posX, int posY, char facing) throws RoverExporeException{
		rover = new Rover(posX, posY, facing);	
		rover.setPlateau(plateau);
		rover.move();
	}
	
	/* ---- test move south ---- */
	
	@Test(dataProvider="data-provider-for-move-method")	
	public void testMoveSouthWithoutException(int posX, int posY, char facing) throws RoverExporeException{
		rover = new Rover(posX, posY, facing);
		rover.setPlateau(plateau);
		rover.move();
		
		Assert.assertEquals(rover.getPosX(), 3);
		Assert.assertEquals(rover.getPosY(), 2);
		Assert.assertEquals(rover.getFacing(), 'S');
	}
	
	@Test(dataProvider="data-provider-for-move-method", expectedExceptions = RoverExporeException.class)	
	public void testMoveSouthWithException(int posX, int posY, char facing) throws RoverExporeException {
		rover = new Rover(posX, posY, facing);	
		rover.setPlateau(plateau);
		rover.move();
	}
	
	/* ---- test move east ---- */
	@Test(dataProvider="data-provider-for-move-method")	
	public void testMoveEastWithoutException(int posX, int posY, char facing) throws RoverExporeException {
		rover = new Rover(posX, posY, facing);
		rover.setPlateau(plateau);
		rover.move();
		
		Assert.assertEquals(rover.getPosX(), 3);
		Assert.assertEquals(rover.getPosY(), 1);
		Assert.assertEquals(rover.getFacing(), 'E');
	}
	
	@Test(dataProvider="data-provider-for-move-method", expectedExceptions = RoverExporeException.class)	
	public void testMoveEastWithException(int posX, int posY, char facing) throws RoverExporeException{
		rover = new Rover(posX, posY, facing);	
		rover.setPlateau(plateau);
		rover.move();
	}
	
	/* ---- test move west ---- */
	@Test(dataProvider="data-provider-for-move-method")	
	public void testMoveWestWithoutException(int posX, int posY, char facing) throws RoverExporeException {
		rover = new Rover(posX, posY, facing);
		rover.setPlateau(plateau);
		rover.move();
		
		Assert.assertEquals(rover.getPosX(), 2);
		Assert.assertEquals(rover.getPosY(), 3);
		Assert.assertEquals(rover.getFacing(), 'W');
	}
	
	@Test(dataProvider="data-provider-for-move-method", expectedExceptions = RoverExporeException.class)	
	public void testMoveWestWithException(int posX, int posY, char facing) throws RoverExporeException {
		rover = new Rover(posX, posY, facing);
		rover.setPlateau(plateau);
		rover.move();
	}
	
	/* ---- test turnLeft ---- */
	
	@Test(dataProvider="data-provider-for-turn-methods")
	public void testTurnLeft(int posX, int posY, char facing) {
		rover = new Rover(posX, posY, facing);
		rover.turnLeft();
		Assert.assertEquals(rover.getFacing(), Rover.FACING_WEST);
		rover.turnLeft();
		Assert.assertEquals(rover.getFacing(), Rover.FACING_SOUTH);
		rover.turnLeft();
		Assert.assertEquals(rover.getFacing(), Rover.FACING_EAST);
		rover.turnLeft();
		Assert.assertEquals(rover.getFacing(), Rover.FACING_NORTH);
	}
	
	/* ---- test turnRight ---- */	
	@Test(dataProvider="data-provider-for-turn-methods")	
	public void testTurnRight(int posX, int posY, char facing) {
		rover = new Rover(posX, posY, facing);
		rover.turnRight();
		Assert.assertEquals(rover.getFacing(), Rover.FACING_WEST);
		rover.turnRight();
		Assert.assertEquals(rover.getFacing(), Rover.FACING_NORTH);
		rover.turnRight();
		Assert.assertEquals(rover.getFacing(), Rover.FACING_EAST);
		rover.turnRight();
		Assert.assertEquals(rover.getFacing(), Rover.FACING_SOUTH);
	}
	
	/* ---- test turn Left then turn Right ---- */
	
	@Test(dataProvider="data-provider-for-turn-methods")
	public void testTurnLeftAndRight(int posX, int posY, char facing) {
		rover = new Rover(posX, posY, facing);
		rover.turnLeft();
		Assert.assertEquals(rover.getFacing(), Rover.FACING_NORTH);
		rover.turnRight();
		Assert.assertEquals(rover.getFacing(), Rover.FACING_EAST);		
	}
	
	/* ---- test toString---- */
	@Test(dataProvider="data-provider-for-report")
	public void testToString(int posX, int posY, char facing) {
		rover = new Rover(posX, posY, facing);
		Assert.assertEquals(rover.toString(), "Rover current position:2,4,W");		
	}
	
	@Test(dataProvider="data-provider-for-report")
	public void testShowCurrentPosition(int posX, int posY, char facing) {
		rover = new Rover(posX, posY, facing);
		Assert.assertEquals(rover.showCurrentPosition(), "2 4 W");		
	}
	
}
