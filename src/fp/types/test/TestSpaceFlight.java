package fp.types.test;

import java.time.LocalDate;
import java.time.LocalTime;

import fp.domain.SpaceMission;
import fp.types.Orbit;
import fp.types.Payload;


public class TestSpaceFlight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Payload p1 = new Payload("DemoSat","MassSimulator", 19.50, Orbit.LOW_EARTH);
		Payload p2 = new Payload("Trailblazer", "Communication Satellite", null, Orbit.LOW_EARTH);
		
		SpaceMission sm1 = new SpaceMission("SpaceX", LocalDate.of(2006, 3, 21), LocalTime.of(22, 30), "Marshall Islands",
				86, 9, 74, "Falcon 1", 343, 470, 22.25,1.50, p1, false, "Engine failure during launch");
		
		SpaceMission sm2 = new SpaceMission("SpaceX", LocalDate.of(2006, 3, 21), LocalTime.of(22, 30), "Marshall Islands",
				86, 9, 74, "Falcon 1", 343, 470, 22.25,1.50, p1, false, "Engine failure during launch");
		
		SpaceMission sm3 = new SpaceMission("SpaceX", LocalDate.of(2008, 8, 16), LocalTime.of(3, 34), "Marshall Islands",
				0, 0, 0, "Falcon 1", 343, 470, 22.25,1.50, p2, false, "Collision during launch");
		
		SpaceMission sm4 = sm1;
		
		SpaceMission sm5 = new SpaceMission("US Air Force", "Cape Canaveral", "Titan IIIIC", "Payload fairing disintegrated at T+78 seconds leading to a loss of the launch vehicle");
		
		System.out.println("Is sm1 equal to sm2? " + sm1.equals(sm2));
		System.out.println("Is sm1 equal to sm3? " + sm1.equals(sm3));
		System.out.println("Is sm1 equal to sm4? " + sm1.equals(sm4));
		System.out.println(sm1);
		System.out.println(sm3);
		System.out.println(sm5);
		
		
	}
}