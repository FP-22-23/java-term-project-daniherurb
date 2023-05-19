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
		 System.out.println("test -> numberOfSpaceMissionsByCompany()");
		 System.out.println("================================");
		 testNumberOfSpaceMissionsByCompany(spacemissions);
		
		 //third delivery
		 
		 System.out.println("");
		 System.out.println("test -> existsSpaceMissionStr()");
		 System.out.println("================================");
		 testExistsSpaceMissionStr(spacemissions, LocalDate.of(2006, 3, 24));
		 testExistsSpaceMissionStr(spacemissions, LocalDate.of(2007, 3, 21));
		 
		 System.out.println("");
		 System.out.println("test -> countTypeOfOrbitStr()");
		 System.out.println("================================");
		 testCountTypeOfOrbitStr(spacemissions, Orbit.EARTHMOONL2);
		 testCountTypeOfOrbitStr(spacemissions, Orbit.GEOSTATIONARYTRANSFERORBIT);
		 
		 System.out.println("");
		 System.out.println("test -> succesfulSpaceMissions()");
		 System.out.println("================================");
		 testSuccesfulSpaceMissionsStr(spacemissions);
		 
		 System.out.println("");
		 System.out.println("test -> maximumLitoffThrust()");
		 System.out.println("================================");
		 testMaximumLitoffThrust(spacemissions);
		 
		 System.out.println("");
		 System.out.println("test -> sortAndFilterAfterLaunchDate()");
		 System.out.println("================================");
		 testSortAndFilterAfterLaunchDate(spacemissions, LocalDate.of(2006, 3, 24));
		 
		 System.out.println("");
		 System.out.println("test -> typesOfVehicleByCompanyStr()");
		 System.out.println("================================");
		 testTypesOfVehicleByCompanyStr(spacemissions);

		 System.out.println("");
		 System.out.println("test -> averageTemperatureByLaunchSite()");
		 System.out.println("================================");
		 testAverageTemperatureByLaunchSite(spacemissions);
		 
		 System.out.println("");
		 System.out.println("test -> spaceMissionWithGreatestRocketHeightByCompany()");
		 System.out.println("================================");
		 testSpaceMissionWithGreatestRocketHeightByCompany(spacemissions);
		
		 System.out.println("");
		 System.out.println("test -> nSpaceMissionsWithBiggestFairingDiameterByCompany()");
		 System.out.println("================================");
		 testNSpaceMissionsWithBiggestFairingDiameterByCompany(spacemissions, 2);

		 System.out.println("");
		 System.out.println("test -> mostUsedVehicleType()");
		 System.out.println("================================");
		 testMostUsedVehicleType(spacemissions);
		 
		 
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
	
	//third delivery
	
	private static void testExistsSpaceMissionStr(SpaceMissions spacemissions, LocalDate l) {
		try {
		String msg = String.format(
				"Does there exist at least one space mission in the date " + l + 
				"? : " + spacemissions.existsSpaceMissionStr(l));
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}				
	}
	
	private static void testCountTypeOfOrbitStr(SpaceMissions spacemissions, Orbit o) {
		try {
		String msg = String.format(
				"Amount of space missions with a type of orbit " + o + 
				" : " + spacemissions.countTypeOfOrbitStr(o));
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}				
	}
	
	private static void testSuccesfulSpaceMissionsStr(SpaceMissions spacemissions) {
		try {
		String msg = String.format(
				"List of succesful missions:" + spacemissions.succesfulSpaceMissionsStr());
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}
		
	}
	
	private static void testMaximumLitoffThrust(SpaceMissions spacemissions) {
		try {
		String msg = String.format(
				"Space mission with maximun litoff thrust:" + spacemissions.maximumLitoffThrust());
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}
		
	}
	
	private static void testSortAndFilterAfterLaunchDate(SpaceMissions spacemissions, LocalDate ld) {
		try {
		String msg = String.format(
				"List of sorted space missions after the given date:" + spacemissions.sortAndFilterAfterLaunchDate(ld));
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}
		
	}
	
	private static void testTypesOfVehicleByCompanyStr(SpaceMissions spacemissions) {
		try {
		String msg = String.format(
				"Types of vehicles by company: " + spacemissions.typesOfVehicleByCompanyStr());
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}				
	}
	
	private static void testAverageTemperatureByLaunchSite(SpaceMissions spacemissions) {
		try {
		String msg = String.format(
				"Average temperature by launch site:  " + spacemissions.averageTemperatureByLaunchSite());
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}				
	}
	
	private static void testSpaceMissionWithGreatestRocketHeightByCompany(SpaceMissions spacemissions) {
		try {
		String msg = String.format(
				"Space mission with the greates rocket height by company:" + spacemissions.spaceMissionWithGreatestRocketHeightByCompany());
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}
		
	}
	
	private static void testNSpaceMissionsWithBiggestFairingDiameterByCompany(SpaceMissions spacemissions, Integer i) {
		try {
		String msg = String.format(
			i + " space missions with the biggest fairing diameter by company:" + spacemissions.nSpaceMissionsWithBiggestFairingDiameterByCompany(i));
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}
		
	}
	
	private static void testMostUsedVehicleType(SpaceMissions spacemissions) {
		try {
		String msg = String.format(
				"Most used vehicle type: " + spacemissions.mostUsedVehicleType());
				System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		}
		
	}
	
	
	
}