# java-term-project-daniherurb
java-term-project-daniherurb created by GitHub Classroom

## **Space Flights Data**

#### *Description*
This Java proyect is going work over different space flight missions and their status. Since there has been a lot of space flight failures,
especially in the early years of rocket development, it is important to study and understand all the factors that could lead to 
this tragedies in order to prevent them. Each line of the CSV describes a space flight mission and all the characteristics surrounding the
mission such as the weather conditions or the reason of the mission's failure.

#### *Types*

**SpaceMission Type** - Main type of the proyect, that describes a space mission and all its attributes. The properties of the type are:<br>
* company: the name of the company that carried out the flight, of type String<br>
* launchDate: date of the launch, of type LocalDate
* launchTime: time of the launch, of type LocalTime
* launchSite: location of the launch, of type String
* temperature: temperature at the time of the deployment, of type Integer
* windSpeed: wind speed at the time of the deployment, of type Integer
* humidity: humidity at the time of the deployment, of type Integer
* vehicleType: type of vehicle, of type String
* litoffThrust: the rocket litoff thrust in kilonewtons, of type Integer
* payloadtoOrbit: payload to orbit in kilograms, of type Integer
* rocketHeight: height of the rocket in meters, of type Double
* fairingDiameter: rocket fairing diameter in meters, of type Dobule
* payload: payload specifications, of type Payload
* succesful: whether the launch was succesfull or not, of type Boolean
* failureReason: in case of failure, the reason why it happened, of type String
* weather: weather conditions at the time of the deployment, a derived property of type ArrayList 

***Constructors of the type***<br>
The first constructor creates an object of type SpaceMission with all its attributes. The second constructor creates and object of type 
SpaceMission with only the String attributes as parameters and the rest set to null.

**Payload Type** - Auxiliary type of the proyect, that describes the specifications of the payload. The properties of the type are:
* name: the name of the payload, of type String
* type: the type of the payload, of type String
* mass: the mass of the payload in kilograms, of type Double
* orbit: the orbit the payload is programmed to reach, of type Orbit

***Constructor of the type***<br>
The constructor of the type creates an object of type Payload with all its attributes.

**Orbit type** - Enum type, that describes the orbit the payload is programmed to reach. It can take the values of: LOWEARTHORBIT, MEDIUMEARTHORBIT, HIGHEARTHORBIT, GEOSTATIONARYTRANSFERORBIT, SUNSYNCHRONOUSORBIT, POLARORBIT, SUNEARTHORBIT, HELIOCENTRICORBIT, MARSORBIT, EARTHMOONL2, SUBORBITAL.

**SpaceMissions Type** - Collection property to store items of the base type<br>
***Constructors of the type***<br>
* One with all basic properties
* One with all basic properties and a collection of the type SpaceMission
* One with all basic properties and a stream of objects of the same type

***Operations of the type***<br>
* getNumberOfSpaceMissions() -> returns the number of space missions
* addSpaceMission(SpaceMission s) -> adds a space mission
* addSpaceMissions(Collection<SpaceMission> smCollection) -> adds a collection of space missions
* deleteSpaceMission(SpaceMission s) -> deletes a space mission

***Methods of the type***<br> 
* existsSpaceMission(LocalDate launchDate) -> returns true if a space mission happened in the same input date
* countTypeOfOrbit(Orbit o) -> returns number of space missions with that orbit type
* succesfulSpaceMissions() -> returns a list of filtered succesful spacemissions
* typesOfVehicleByCompany() -> returns a map with keys being the companies and the values being the type of vehicles they have used
* numberOfSpaceMissionsByCompany() -> returns a map with keys being the companies and the values being the total space missions they have done
* existsSpaceMissionStr(LocalDate launchDate) -> returns true if a space mission happened in the same input date (implemented with streams)
* countTypeOfOrbit(Orbit o) -> returns number of space missions with that orbit type (implemented with streams)
* succesfulSpaceMissions() -> returns a list of filtered succesful spacemissions (implemented with streams)
* maximumLitoffThrust() -> returns the SpaceMission with the greater Litoff Thrust
* sortAndFilterAfterLaunchDate(LocalDate ld) -> returns a list of space missions that happened after the input LocalDate sorted by date
* typesOfVehicleByCompanyStr() -> returns a map with keys being the companies and the values being the type of vehicles they have used (implemented with streams)
* averageTemperatureByLaunchSite() -> returns a map with keys being launching sites and values being the average temperature on said site
* spaceMissionWithGreatestRocketHeightByCompany() -> returns a map with keys being companies and the values being the space mission with the greatest rocket height belonging to said company
* nSpaceMissionsWithBiggestFairingDiameterByCompany(Integer i) -> returns a sorted map with keys being companies and the values being a list of i space missions with the biggest fairing diameter
* mostUsedVehicleType() -> returns the most used vehicle type (using a map)
    
**SpaceMissions Factory** - Factory of space missions from a CSV file<br>
***Methods of the type***<br>
* readSpaceMissions(String fileName) -> receives a string formatted as the lines of the CSV file, and returns an object of the base type
* parseSpaceMission(String line) -> receives a string containing the name and path of the CSV file, and returns a list of objects of the base type 

### *More details*
Each type also has their own getters and setters, a specified criterion of equality and a criterion of natural order, appart from 
a test to check the proper functioning of the type. There are also some constraints implemented to properties with the util Checkers.





