# java-term-project-daniherurb
java-term-project-daniherurb created by GitHub Classroom

## **Space Flights Data**

#### *Description*
This Java proyect is going work over different space flight missions and their status. Since there has been a lot of space flight failures,
especially in the early years of rocket development, it is important to study and understand all the factors that could lead to 
this tragedies in order to prevent them. Each line of the CSV describes a space flight mission and all the characteristics surrounding the
mission such as the weather conditions or the reason of the mission's failure.

#### *Types*

**SpaceFlight Type** - Main type of the proyect, that describes a space mission and all its attributes. The properties of the type are:<br>
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
The first constructor creates an object of type SpaceFlight with all its attributes. The second constructor creates and object of type 
SpaceFlight with only the String attributes as parameters and the rest set to null.

**Payload Type** - Auxiliary type of the proyect, that describes the specifications of the payload. The properties of the type are:
* name: the name of the payload, of type String
* type: the type of the payload, of type String
* mass: the mass of the payload in kilograms, of type Double
* orbit: the orbit the payload is programmed to reach, of type Orbit

***Constructor of the type***<br>
The constructor of the type creates an object of type Payload with all its attributes.

**Orbit type** - Enum type, that describes the orbit the payload is programmed to reach. It can take the values of: LOW_EARTH, MEDIUM_EARTH, 
HIGH_EARTH, GEOSTATIONARY_TRANSFER,  SUN_SYNCHRONOUS, POLAR, SUN_EARTH, HELIOCENTRIC, MARS, EARTH_MOON

### *More details*

Each type also has their own getters and setters, a specified criterion of equality and a criterion of natural order, appart from 
a test to check the proper functioning of the type. There are also some constraints implemented to properties with the util Checkers.





