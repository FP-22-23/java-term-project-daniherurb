package fp.types;

import java.util.Objects;

public class Payload{ //AUXILIARY CLASS
	
	private String name; //name of the payload
	private String type; //type of payload
	private Double mass; //mass of the payload in kilograms
	private Orbit orbit; //orbit the payload is programmed to reach
	
	//CONSTRUCTOR
	public Payload(String name, String type, Double mass, Orbit orbit) {
		this.name = name;
		this.type = type;
		this.mass = mass;
		this.orbit = orbit;
	}
	
	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public Double getMass() {
		return mass;
	}
	public void setMass(Double mass) {
		this.mass = mass;
	}
	
	
	public Orbit getOrbit() {
		return orbit;
	}
	public void setOrbit(Orbit orbit) {
		this.orbit = orbit;
	}

	@Override
	public String toString() {
		return "Payload [name:" + name + ", type:" + type + ", mass:" + mass + ", orbit:" + orbit + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payload other = (Payload) obj;
		return Objects.equals(mass, other.mass) && Objects.equals(name, other.name) && orbit == other.orbit
				&& Objects.equals(type, other.type);
	}

	public int compareTo(Payload payload) {
		int res = this.type.compareTo(payload.type);
		if (res==0) {
			res = this.mass.compareTo(payload.mass);
		}
		return 0;
	}
	
	
	
	
	
}
