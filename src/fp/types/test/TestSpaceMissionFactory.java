package fp.types.test;

import fp.domain.SpaceMissions;
import fp.domain.SpaceMissionsFactory;

public class TestSpaceMissionFactory {
		public static void main(String[] args) {
			testReadSpaceMissions("data/SpaceMissions.csv");
		}

		private static void testReadSpaceMissions(String file) {
			System.out.println("============ readSpaceMissions TEST =============");
			SpaceMissions spacemissions = SpaceMissionsFactory.readSpaceMissions(file);
			System.out.println("Space Missions: "+ spacemissions);
		}

	}
