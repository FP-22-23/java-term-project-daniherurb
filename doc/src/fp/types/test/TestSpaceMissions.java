package fp.types.test;

import java.time.LocalDate;

import fp.domain.SpaceMissions;
import fp.domain.SpaceMissionsFactory;
import fp.types.Orbit;

public class TestSpaceMissions {

	public static void main(String[] args) {
		 SpaceMissions spacemissions = SpaceMissionsFactory.readSpaceMissions("data/SpaceMissions.csv");
		
		 System.out.println("test -> existsSpaceMission()");
		 System.out.println("================================");
		 testExistsSpaceMission(spacemissions, LocalDate.of(2006, 3, 24));
		 testExistsSpaceMission(spacemissions, LocalDate.of(2007, 3, 21));
		 
		 System.out.println("");
		 System.out.println("test -> countTypeOfOrbit()");
		 System.out.println("================================");
		 testCountTypeOfOrbit(spacemissions, Orbit.EARTHMOONL2);
		 testCountTypeOfOrbit(spacemissions, Orbit.GEOSTATIONARYTRANSFERORBIT);
		 
		 System.out.println("");
		 System.out.println("test -> succesfulSpaceMissions()");
		 System.out.println("================================");
		 testSuccesfulSpaceMissions(spacemissions);
		 
		 System.out.println("");
		 System.out.println("test -> typesOfVehicleByCompany()");
		 System.out.println("================================");
		 testTypesOfVehicleByCompany(spacemissions);
		 
		 System.out.println("");
		 System.out.println("test -> typesOfVehicleByCompany()");
		 System.out.println("================================");
		 testNumberOfSpaceMissionsByCompany(spacemissions);
		 
		 
	}
		 
	private static void testExistsSpaceMission(SpaceMissions spacemissions, LocalDate l) {
		try {
		String msg = String.format(
				"Does there exist at least one space mission in the date " + l + 
				"? : " + spacemissions.existsSpaceMission(l));
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}				
	}
	
	private static void testCountTypeOfOrbit(SpaceMissions spacemissions, Orbit o) {
		try {
		String msg = String.format(
				"Amount of space missions with a type of orbit " + o + 
				" : " + spacemissions.countTypeOfOrbit(o));
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}				
	}
	
	private static void testSuccesfulSpaceMissions(SpaceMissions spacemissions) {
		try {
		String msg = String.format(
				"List of succesful missions:" + spacemissions.succesfulSpaceMissions());
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}
		
	}
	
	private static void testTypesOfVehicleByCompany(SpaceMissions spacemissions) {
		try {
		String msg = String.format(
				"Map of vehicles by company:" + spacemissions.typesOfVehicleByCompany());
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}
		
	}
	
	private static void testNumberOfSpaceMissionsByCompany(SpaceMissions spacemissions) {
		try {
		String msg = String.format(
				"Number of space missions by company:" + spacemissions.numberOfSpaceMissionsByCompany());
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}
		
	}
	
}