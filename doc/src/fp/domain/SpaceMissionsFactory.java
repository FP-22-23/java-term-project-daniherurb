package fp.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import fp.types.Orbit;
import fp.types.Payload;


public class SpaceMissionsFactory {
	
	public static SpaceMissions readSpaceMissions(String fileName) {
		SpaceMissions res=null;
		try {
			List<SpaceMission> spacemissions = Files.lines(Paths.get(fileName))
					.skip(1) //skip header
					.map(SpaceMissionsFactory::parseSpaceMission)
					.collect(Collectors.toList());
			
			res=new SpaceMissionsImpl(spacemissions);
			} catch(IOException e) {
			System.out.println("File not found: " + fileName);
			e.printStackTrace();
		}
	return res;
	}
		

	private static SpaceMission parseSpaceMission(String line) {
		String[] fields = line.split(",");
		
		String company = fields[0].trim();
		LocalDate launchDate = LocalDate.parse(fields[1].trim(), DateTimeFormatter.ofPattern("dd MM yyyy"));
		LocalTime launchTime = LocalTime.parse(fields[2].trim(), DateTimeFormatter.ofPattern("HH:mm"));
		String launchSite = fields[3].trim();
		Integer temperature = parseInteger(fields[4].trim());
		Integer windSpeed = parseInteger(fields[5].trim());
		Integer humidity = parseInteger(fields[6].trim());
		String vehicleType = fields[7].trim();
		Integer litoffThrust = parseInteger(fields[8].trim());
		Integer payloadToOrbit = parseInteger(fields[9].trim());
		Double rocketHeight = parseDouble(fields[10].trim());
		Double fairingDiameter = parseDouble(fields[11].trim());
		String payloadName = fields[12].trim();
		String payloadType = fields[13].trim();
		Double payloadMass = parseDouble(fields[14].trim());
		Orbit payloadOrbit = Orbit.valueOf(fields[15].trim().replace(" ","").toUpperCase());
		Boolean succesful = parseBoolean(fields[16].trim());
		String failureReason = fields[17].trim();
		
		Payload p = new Payload(payloadName, payloadType, payloadMass, payloadOrbit);
		return new SpaceMission(company, launchDate, launchTime, launchSite,
				temperature, windSpeed, humidity, vehicleType, litoffThrust,
				payloadToOrbit, rocketHeight, fairingDiameter, p, succesful, failureReason);
	}

	 
	private static Integer parseInteger(String s) { //parse integers
		if (!s.isEmpty()) {
			return Integer.parseInt(s);
		}
		else {
			return 0;
		}
	}
 
	private static Double parseDouble(String s) { //parse doubles
		if (!s.isEmpty()) {
			return Double.parseDouble(s);
		}
		else {
			return 0.0;
		}
	}
	
	private static Boolean parseBoolean(String s) { //parse boolean
		Boolean res = null;
		s = s.toUpperCase();
		if (s.equals("SUCCESS")) {
			res = true;
		}else {
			res = false;
		}
		return res;
	}
}

