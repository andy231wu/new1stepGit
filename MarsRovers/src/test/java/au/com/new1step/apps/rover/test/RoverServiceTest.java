
package au.com.new1step.apps.rover.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import au.com.new1step.apps.rover.exception.RoverDeployException;
import au.com.new1step.apps.rover.exception.RoverExporeException;
import au.com.new1step.apps.rover.service.PlateauService;
import au.com.new1step.apps.rover.service.RoverService;
import au.com.new1step.apps.rover.service.impl.PlateauServiceImpl;
import au.com.new1step.apps.rover.service.impl.RoverServiceImpl;

public class RoverServiceTest {
	private RoverService roverService;	
	
	@BeforeClass
	public void oneTimeSetUp(){
		PlateauService ps = new PlateauServiceImpl();		
		roverService = new RoverServiceImpl(ps.setupPlateau("5 5"));	
	}

	@AfterClass
	public void oneTimeTearDown(){
		roverService = null;	
	}
	
	@BeforeMethod
	public void setUp(){
		//
	}
	
	@AfterMethod
	public void tearDown(){
		//
	}	 
		
	/* ---- test setup plateau ----*/
	
	public void testSetupPlateau() {
		PlateauService plateau = new PlateauServiceImpl();	
		roverService = new RoverServiceImpl(plateau.setupPlateau("6 6"));		
		Assert.assertEquals(roverService.getRover().getPlateau().getMaxPosX(), 6);
		Assert.assertEquals(roverService.getRover().getPlateau().getMaxPosY(), 6);		
	}
	
	/* ---- test deploy method ---- */
	
	@Test	
	public void testDeployNormal() throws RoverDeployException{		
		roverService.deploy("2 3 N");
		
		Assert.assertEquals(roverService.getRover().getPosX(), 2);
		Assert.assertEquals(roverService.getRover().getPosY(), 3);
		Assert.assertEquals(roverService.getRover().getFacing(), 'N');
	}
	
	@Test(expectedExceptions = RoverDeployException.class)	
	public void testDeployOutOfXposition() throws RoverDeployException{
		roverService.deploy("-1 4 N");		
	}
	
	@Test(expectedExceptions = RoverDeployException.class)	
	public void testDeployOutOfYposition() throws RoverDeployException{
		roverService.deploy("3 6 S");		
	}
	
	@Test(expectedExceptions = RoverDeployException.class)	
	public void testDeployOutOfXandYposition() throws RoverDeployException {
		roverService.deploy("-2 6 S");		
	}

	@Test(expectedExceptions = RoverDeployException.class)	
	public void testDeployBadFacing() throws RoverDeployException{	
		roverService.deploy("2 1 Q");		
	}
	
	/* ---- test explore method ---- */
	@Test
	public void testTurnLeftExplore() throws RoverExporeException, RoverDeployException{
		roverService.deploy("1 2 N");
		roverService.explore("L");		
		Assert.assertEquals(roverService.getRover().getFacing(), 'W');
	}
	
	@Test
	public void testTurnRightExplore() throws RoverDeployException, RoverExporeException{
		roverService.deploy("1 2 N");
		roverService.explore("R");	
		Assert.assertEquals(roverService.getRover().getFacing(), 'E');
	}
	
	@Test	
	public void testMoveExplore() throws RoverDeployException, RoverExporeException {
		roverService.deploy("1 2 N");
		roverService.explore("M");
		Assert.assertEquals(roverService.getRover().getPosY(), 3);		
	}
	
	@Test(expectedExceptions = RoverExporeException.class)	
	public void testBadInputData() throws RoverDeployException, RoverExporeException{
		roverService.deploy("1 2 N");
		roverService.explore("Q");	
	}
	
	// below two test cases from NBN should not include in this class, as above test cases
	// already tested this case. 
	@Test
	public void testTestCase1FromNBN() throws RoverDeployException, RoverExporeException{		
		roverService.deploy("1 2 N");
		roverService.explore("LMLMLMLMM");	
		Assert.assertEquals(roverService.getRover().showCurrentPosition(), "1 3 N");
	}
	
	@Test
	public void testTestCase2FromNBN() throws RoverDeployException, RoverExporeException{		
		roverService.deploy("3 3 E");
		roverService.explore("MMRMMRMRRM");	
		Assert.assertEquals(roverService.getRover().showCurrentPosition(), "5 1 E");
	}
	
}
