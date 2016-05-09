package au.com.new1step.apps.rover.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import au.com.new1step.apps.rover.exception.RoverDeployException;
import au.com.new1step.apps.rover.exception.RoverExporeException;
import au.com.new1step.apps.rover.service.PlateauService;
import au.com.new1step.apps.rover.service.RoverService;
import au.com.new1step.apps.rover.service.impl.PlateauServiceImpl;
import au.com.new1step.apps.rover.service.impl.RoverServiceImpl;

public class SingleThreadMarsRoverDemo {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PlateauService ps = new PlateauServiceImpl();
		RoverService rs = null;
		int num = 0;
		
		do{			
			System.out.println("\n\n===== Mars Rovers Application =====");
			System.out.println("========= Functions [1,2,3,4,5] =============");
			System.out.println(" 1. Setup Plateau (1st input line)");
			System.out.println(" 2. Deploy Rover (2nd input line)");
			System.out.println(" 3. Instruct Rover Exploring (3rd input line)");			
			System.out.println(" 4. Show Current Position");
			System.out.println(" 5. Exit");
			
			try{
				System.out.print("Please select [1,2,3,4,5]: ");
				num = Integer.parseInt(reader.readLine());
			}catch(Exception ioe) {
				System.out.println("Please choose 1 to 5 options");
				continue;
			}			
			
			switch(num){
				case 1:
				     rs = setupPlateau(reader, ps, rs);    break;
				case 2:
					 deployRover(reader,rs);               break;
				case 3:
					 RoverExploring(reader,rs);            break;
				case 4:
					 showCurrentPosition(rs);              break;
			}	
			
		}while(num != 5);
	}
	
	public static RoverService setupPlateau(BufferedReader reader, PlateauService ps, RoverService rs) {		
		System.out.println("===== Setup Plateau =====");		
		System.out.println("===== Enter First Input Line =====");
		String line;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println("ERROR - occurs at Reading First Input Line.");
			System.out.println("Please re-enter !");
			return null;
		}
		return new RoverServiceImpl(ps.setupPlateau(line));		
	}
	
	public static void deployRover(BufferedReader reader, RoverService rs) {
		if(rs == null){
			System.out.println("Please run \"1. Setup Plateau (1st input line)\" before this step");
			return;
		}
		System.out.println("===== Deploy Rover =====");		
		System.out.println("====== Enter Second Input Line ======");
		String line;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println("ERROR - occurs at Reading Second Input Line.");
			System.out.println("Please re-enter !");
			return;
		}
		try {
			rs.deploy(line);
		} catch (RoverDeployException e) {
			System.out.println(e.getMessage());
			System.out.println("Please re-enter !");
		}
	}
	
	public static void RoverExploring(BufferedReader reader, RoverService rs) {	
		if(rs == null){
			System.out.println("Please run \"1. Setup Plateau (1st input line)\" before this step");
			return;
		}
		System.out.println("===== Instruct Rover Exploring =====");		
		System.out.println("====== Enter Third Input Line ======");
		String line;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println("ERROR - occurs at Reading Third Input Line.");
			System.out.println("Please re-enter !");
			return;
		}
		try {
			rs.explore(line);;
		} catch (RoverExporeException | RoverDeployException e) {
			System.out.println(e.getMessage());
			System.out.println("Please re-enter !");
		}
	}
	
	public static void showCurrentPosition(RoverService rs) {
		if(rs == null){
			System.out.println("Please run \"1. Setup Plateau (1st input line)\" before this step");
			return;
		}
		System.out.println(rs.getRover().showCurrentPosition());
	}
}
