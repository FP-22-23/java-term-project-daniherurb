package fp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.types.Orbit;

public class SpaceMissions {
	
	
	private List<SpaceMission> spacemissions;

	public SpaceMissions() {
		spacemissions = new ArrayList<SpaceMission>();
	}

	public SpaceMissions(Collection<SpaceMission> spaceMissions) {
		this.spacemissions = new ArrayList<SpaceMission>(spaceMissions);
	}
	
	public SpaceMissions(Stream<SpaceMission> spaceMissions) {
		this.spacemissions = spaceMissions.collect(Collectors.toList());
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpaceMissions other = (SpaceMissions) obj;
		return Objects.equals(spacemissions, other.spacemissions);
	}

	public String toString() {
		return "Space Missions = " + spacemissions;
	}

	public Integer getNumberOfSpaceMissions() {
		return spacemissions.size();
	}


	public void addSpaceMission(SpaceMission s) {
		spacemissions.add(s);
		
	}
	
	public void addSpaceMissions(Collection<SpaceMission> smCollection) {
		spacemissions.addAll(smCollection);
		
	}
	
	
	public void deleteSpaceMission(SpaceMission s) {
		spacemissions.remove(s);
		
	}
	
	
	//SECOND DELIVERY - IMPLEMENTATION WITH LOOPS
	 
	
	// a) Exists method
	
	public boolean existsSpaceMission(LocalDate l) {
		Boolean res = false;
	    	for (SpaceMission s:spacemissions) {
	    		if (s.getLaunchDate().equals(l)) {
	    			res = true;
	    			break;
	    		}
	    	}
			return res;
	}
	
	
	// b) Counter method
	
	public Integer countTypeOfOrbit(Orbit o) {
		Integer res = 0;
		for (SpaceMission s:spacemissions) {
			if (s.getPayload().getOrbit() == o) {
				res = res + 1;	
			}
		}
		return res;
	}

	
	// c) A selection with filtering
	
	public List<SpaceMission> succesfulSpaceMissions() {
		List<SpaceMission> res = new ArrayList<SpaceMission>();
		for (SpaceMission s:spacemissions) {
			if (s.getSuccesful()==true) {
				res.add(s);
			}
		}
		return res;
	}

	
	/* d) A grouping method that returns a Map in which the keys are a property 
	 *    of the base type, and the values a collection (List, Set, SortedSet) 
	 *    of objects of the base type.
	 */
	
	public Map<String, Set<String>> typesOfVehicleByCompany() {
			Map<String, Set<String>> res = new HashMap<String, Set<String>>();
			for(SpaceMission s:spacemissions) {
				String key = s.getCompany();
					if (res.containsKey(key)) {
						res.get(key).add(s.getVehicleType());
					} else {
						Set<String> vehicletypes = new HashSet<String>();
						vehicletypes.add(s.getVehicleType());
						res.put(key, vehicletypes);
					}
				}
			return res;
	}
	
	
	/* e) A grouping method that returns a Map in which the keys are a property of the base type,
	 *  and the counts or sum values of the base type objects stored 
	 *  in the container that have that property as their value.
	 */
	
	public Map<String, Integer> numberOfSpaceMissionsByCompany() {
		Map<String, Integer> res = new HashMap<String, Integer>();
		for(SpaceMission s:spacemissions) {
			String key = s.getCompany();
				if (res.containsKey(key)) {
					res.put(key, res.get(key) + 1);
				} else {
					Set<String> vehicletypes = new HashSet<String>();
					vehicletypes.add(s.getVehicleType());
					res.put(key, 1);
				}
			}
		return res;
	}
	
	
	//THIRD DELIVERY - IMPLEMENTATION WITH STREAMS
	
	
	// 1) exists method
	
	public boolean existsSpaceMissionStr(LocalDate launchDate) {
		return spacemissions.stream()
				.anyMatch(s -> s.getLaunchDate().equals(launchDate));
		}
	
	
	// 2) counter method
	
	public Integer countTypeOfOrbitStr(Orbit o) {
		return (int) spacemissions.stream()
				.filter(s -> s.getPayload().getOrbit().equals(o))
				.count();
		}
	
	
	// 3) A selection with filtering
	
	public List<SpaceMission> succesfulSpaceMissionsStr() {
		return spacemissions.stream()
				.filter(s -> s.getSuccesful().equals(true))
				.collect(Collectors.toList());
		}
	
	
	// 4) A maximum with filtering
	
	public SpaceMission maximumLitoffThrust() {
		return spacemissions.stream()
				.max(Comparator.comparing(s -> s.getLitoffThrust()))
				.get();
		}
	
	
	// 5) A selection, with filtering and sorting
	
	public List<SpaceMission> sortAndFilterAfterLaunchDate(LocalDate ld){
		return spacemissions.stream()
				.filter(s -> s.getLaunchDate().isAfter(ld))
				.sorted(Comparator.comparing(SpaceMission::getLaunchDate))
				.collect(Collectors.toList());
		}
	
	
	// 6) Method 4 of the second delivery, but implemented with streams
	
	public Map<String, Set<String>> typesOfVehicleByCompanyStr() {
		return spacemissions.stream()
				.collect(Collectors.groupingBy(s -> s.getCompany(),
						Collectors.mapping(SpaceMission :: getVehicleType,
								Collectors.toSet())));
		}
	
	
	// 7) Method whose implementation is used collectingAndThen
	
	public Map<String, Integer> averageTemperatureByLaunchSite() {
		return spacemissions.stream()
		        .collect(Collectors.groupingBy(SpaceMission::getLaunchSite,
		                Collectors.collectingAndThen(
		                        Collectors.averagingInt(SpaceMission::getTemperature),
		                           temperatureMean -> temperatureMean.intValue())));
		}
	
	
	/* 8) A method that returns a Map in which the keys are an attribute or a function over an attribute,
	 *    and the values are maximum/minimum of the elements that have that value.
	 */
	
	public Map<String, SpaceMission> spaceMissionWithGreatestRocketHeightByCompany() {
		Map<String,List<SpaceMission>> res = spacemissions.stream()
				.collect(Collectors.groupingBy(SpaceMission::getCompany));
			
		return res.entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey(),
						 e -> Collections.max(e.getValue(),
								Comparator.comparing(SpaceMission::getRocketHeight))));
		}

		
	/* 9) A method that returns a SortedMap in which the keys are an attribute or a function over an attribute, 
	 *    and the values are lists with the n best or worst elements that share the value of that attribute 
	 *    (or function over the attribute).
	 */
	
	public SortedMap<String, List<SpaceMission>> nSpaceMissionsWithBiggestFairingDiameterByCompany(Integer i) {
		return spacemissions.stream()
		        .collect(Collectors.groupingBy(SpaceMission::getCompany, TreeMap::new,
		        Collectors.collectingAndThen(Collectors.toList(), list -> sortAndLimit(list, i))));
		}

	private List<SpaceMission> sortAndLimit(List<SpaceMission> list, Integer i) {
	    return list.stream()
		        .sorted(Comparator.comparing(SpaceMission::getFairingDiameter).reversed())
		        .limit(i)
		        .collect(Collectors.toList());
		}
	
	
	// 10) A method that calculates a Map and returns the key with the associated value (largest or smallest) of the entire Map.
	
	public String mostUsedVehicleType() {
		Map<String, Long> res = spacemissions.stream()
				.collect(Collectors.groupingBy(SpaceMission::getVehicleType,
							Collectors.counting()));
			
		return res.entrySet().stream()
		.max(Comparator.comparing(s -> s.getValue()))
		.get()
		.getKey();
		
		}	
	
}
