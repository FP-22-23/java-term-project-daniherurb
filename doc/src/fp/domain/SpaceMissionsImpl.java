package fp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


import fp.types.Orbit;



public class SpaceMissionsImpl implements SpaceMissions {

	private List<SpaceMission> spacemissions;

	public SpaceMissionsImpl() {
		spacemissions = new ArrayList<SpaceMission>();
	}

	public SpaceMissionsImpl(Collection<SpaceMission> spaceMissions) {
		this.spacemissions = new ArrayList<SpaceMission>(spaceMissions);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpaceMissionsImpl other = (SpaceMissionsImpl) obj;
		return Objects.equals(spacemissions, other.spacemissions);
	}

	@Override
	public String toString() {
		return "Space Missions = " + spacemissions;
	}

	@Override
	public Integer getNumberOfSpaceMissions() {
		return spacemissions.size();
	}

	@Override
	public void addSpaceMission(SpaceMission s) {
		spacemissions.add(s);
		
	}
	
	@Override
	public void addSpaceMissions(Collection<SpaceMission> smCollection) {
		spacemissions.addAll(smCollection);
		
	}
	
	@Override
	public void deleteSpaceMission(SpaceMission s) {
		spacemissions.remove(s);
		
	}
	
	@Override
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
	
	@Override
	public Integer countTypeOfOrbit(Orbit o) {
		Integer res = 0;
		for (SpaceMission s:spacemissions) {
			if (s.getPayload().getOrbit() == o) {
				res = res + 1;	
			}
		}
		return res;
	}

	@Override
	public List<SpaceMission> succesfulSpaceMissions() {
		List<SpaceMission> res = new ArrayList<SpaceMission>();
		for (SpaceMission s:spacemissions) {
			if (s.getSuccesful()==true) {
				res.add(s);
			}
		}
		return res;
	}

	@Override
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

	@Override
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

	
	

	
	
	
	
}
