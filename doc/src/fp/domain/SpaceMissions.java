package fp.domain;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fp.types.Orbit;


public interface SpaceMissions {
		
	//returns the number of space missions
	Integer getNumberOfSpaceMissions();
	
	//adds a space mission
	void addSpaceMission(SpaceMission s);
	
	//adds a collection of spacemissions
	void addSpaceMissions(Collection<SpaceMission> smCollection);
	
	//deletes a space mission
	void deleteSpaceMission(SpaceMission s);
	
	//returns true if a space mission happened in the same input date
	boolean existsSpaceMission(LocalDate launchDate);
	
	//returns number of space missions with that orbit type
	Integer countTypeOfOrbit(Orbit o);
	
	//returns a list of filtered succesful spacemissions
	List<SpaceMission> succesfulSpaceMissions();
	
	//returns a map  with keys being the companies and the values being the type of vehicles they have used
	Map<String, Set<String>> typesOfVehicleByCompany();
	
	//returns a map with keys being the companies and the values being the total space missions they have done
	Map<String, Integer> numberOfSpaceMissionsByCompany();
	}


