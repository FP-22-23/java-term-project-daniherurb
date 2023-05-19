package fp.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.types.Payload;
import fp.utils.Checkers;



public class SpaceMission {

	private String company; //space company that carried out the flight
	private LocalDate launchDate; //date of the launch
	private LocalTime launchTime; //time of the launch
	private String launchSite; //location of the launch
	private Integer temperature; //temperature in the exact time of deployment
	private Integer windSpeed; //wind speed in the exact time of deployment
	private Integer humidity; //humidity in the exact time of the deployment
	private String vehicleType; //vehicle type
	private Integer litoffThrust; //the rocket litoff thrust in kiloNewtons
	private Integer payloadToOrbit; //payload to orbit in kilograms
	private Double rocketHeight; //rocket height in meters
	private Double fairingDiameter; //rocket fairing diameter in meters
	private Payload payload; //payload specifications
	private Boolean succesful; //whether the launch was a failure or a success
	private String failureReason; //in case of a failure, the reason it happened
	
	//CONSTRUCTORS
	public SpaceMission(String company, LocalDate launchDate, LocalTime launchTime, String launchSite,
			Integer temperature, Integer windSpeed, Integer humidity, String vehicleType, Integer litoffThrust,
			Integer payloadToOrbit, Double rocketHeight, Double fairingDiameter, Payload payload, Boolean succesful, String failureReason) {
		
		Checkers.check("Humidity value must be between 0 and 100", 0<=humidity && humidity<=100);
		Checkers.check("Date must be before or today", !launchDate.isAfter(LocalDate.now()));
		
		this.company = company;
		this.launchDate = launchDate;
		this.launchTime = launchTime;
		this.launchSite = launchSite;
		this.temperature = temperature;
		this.windSpeed = windSpeed;
		this.humidity = humidity;
		this.vehicleType = vehicleType;
		this.litoffThrust = litoffThrust;
		this.payloadToOrbit = payloadToOrbit;
		this.rocketHeight = rocketHeight;
		this.fairingDiameter= fairingDiameter;
		this.payload = payload;
		this.succesful = succesful;
		this.failureReason = failureReason;
	}
	
	public SpaceMission(String company, String launchSite, String vehicleType, String failureReason) {
		
		this.company = company;
		this.launchDate = null;
		this.launchTime = null;
		this.launchSite = launchSite;
		this.temperature = null;
		this.windSpeed = null;
		this.humidity = null;
		this.vehicleType = vehicleType;
		this.litoffThrust = null;
		this.payloadToOrbit = null;
		this.rocketHeight = null;
		this.fairingDiameter= null;
		this.payload = null;
		this.succesful = null;
		this.failureReason = failureReason;
	}
	
	//DERIVED PROPERTY 
	//property weather, of type list, that includes the temperature, wind speed and humidity at the exact time of the launch
	public List<Integer> getWeather(){ 
		List<Integer> weather = new ArrayList<Integer>();
		weather.add(temperature);
		weather.add(windSpeed);
		weather.add(humidity);
		return weather;
	}
	
	//GETTERS AND SETTERS
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public LocalDate getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(LocalDate launchDate) {
		this.launchDate = launchDate;
	}

	public LocalTime getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(LocalTime launchTime) {
		this.launchTime = launchTime;
	}

	public String getLaunchSite() {
		return launchSite;
	}

	public void setLaunchSite(String launchSite) {
		this.launchSite = launchSite;
	}

	public Integer getTemperature() {
		return temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public Integer getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Integer windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Integer getLitoffThrust() {
		return litoffThrust;
	}

	public void setLitoffThrust(Integer litoffThrust) {
		this.litoffThrust = litoffThrust;
	}

	public Integer getPayloadToOrbit() {
		return payloadToOrbit;
	}

	public void setPayloadToOrbit(Integer payloadToOrbit) {
		this.payloadToOrbit = payloadToOrbit;
	}

	public Double getRocketHeight() {
		return rocketHeight;
	}

	public void setRocketHeight(Double rocketHeight) {
		this.rocketHeight = rocketHeight;
	}

	public Double getFairingDiameter() {
		return fairingDiameter;
	}

	public void setFairingDiameter(Double fairingDiameter) {
		this.fairingDiameter = fairingDiameter;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	public Boolean getSuccesful() {
		return succesful;
	}

	public void setSuccesful(Boolean succesful) {
		this.succesful = succesful;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	
	//REPRESENTATION DEFINED AS A STRING
	@Override
	public String toString() {
		return "SpaceMission [company=" + company + ", launchDate=" + launchDate + ", launchTime=" + launchTime
				+ ", launchSite=" + launchSite + ", temperature=" + temperature + ", windSpeed=" + windSpeed
				+ ", humidity=" + humidity + ", vehicleType=" + vehicleType + ", litoffThrust=" + litoffThrust
				+ ", payloadToOrbit=" + payloadToOrbit + ", rocketHeight=" + rocketHeight + ", fairingDiameter="
				+ fairingDiameter + ", payload=" + payload + ", succesful=" + succesful + ", failureReason="
				+ failureReason + "]";
	}
	
	//EQUALITY CRITERIA
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpaceMission other = (SpaceMission) obj;
		return Objects.equals(company, other.company) && Objects.equals(failureReason, other.failureReason)
				&& Objects.equals(fairingDiameter, other.fairingDiameter) && Objects.equals(humidity, other.humidity)
				&& Objects.equals(launchDate, other.launchDate) && Objects.equals(launchSite, other.launchSite)
				&& Objects.equals(launchTime, other.launchTime) && Objects.equals(litoffThrust, other.litoffThrust)
				&& Objects.equals(payload, other.payload) && Objects.equals(payloadToOrbit, other.payloadToOrbit)
				&& Objects.equals(rocketHeight, other.rocketHeight) && Objects.equals(succesful, other.succesful)
				&& Objects.equals(temperature, other.temperature) && Objects.equals(vehicleType, other.vehicleType)
				&& Objects.equals(windSpeed, other.windSpeed);
	}
	
	//NATURAL ORDER
	public int compareTo(SpaceMission s) {
		int res = this.launchDate.compareTo(s.launchDate);
		if (res==0) {
			res = this.launchSite.compareTo(s.launchSite);
		}
		if (res==0) {
			res = this.launchTime.compareTo(s.launchTime);
		}
		if (res==0) {
			res = this.company.compareTo(s.company);
		}
		if (res==0) {
			res = this.payload.compareTo(s.payload);	
		}
		
		return res;
	}
	
	
	
	
	
	
}
