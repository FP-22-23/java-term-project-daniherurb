package fp.types.test;

import fp.types.Orbit;
import fp.types.Payload;

public class TestPayload {

	public static void main(String[] args) {
		
		Payload p1 = new Payload("DemoSat","MassSimulator",19.50, Orbit.LOWEARTHORBIT);
		Payload p2 = new Payload("DemoSat","MassSimulator",19.50, Orbit.LOWEARTHORBIT);
		Payload p3 = new Payload("Explorer", "Human remains", 0.00, Orbit.LOWEARTHORBIT);
		
		System.out.println("Is p1 equal to p2? " + p1.equals(p2));
		System.out.println("Is p1 equal to p3? " + p1.equals(p3));
		System.out.println(p1);
		System.out.println(p3);
		
	}

}
