package week03.scenariobased.aerovigil;

class FlightUtil {
		
	//valid capacity
	private int spiceJetCapacity=396;
	private int vistaraCapacity=615;
	private int indiGoCapacity=230;
	private int airArabiaCapacity=130;
	
	//valid fuel capacity
	private int spiceJetFuelCapacity=200000;
	private int vistaraFuelCapacity=300000;
	private int indiGoFuelCapacity=250000;
	private int airArabiaFuelCapacity=150000;
	
	//flight names 
	
	
	
	
	//validating flight Number 
		public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException{
			String pattern="^FL-[1-9][0-9]{3}$";
			if(flightNumber.matches(pattern)) {
				return true;
			}
			throw new InvalidFlightException("The flight number "+flightNumber+" is invalid");
		}
		
		//validating flight Name 
		public boolean validateFlightName(String flightName) throws InvalidFlightException{
			
			if(flightName.equalsIgnoreCase("SpiceJet") ||
					flightName.equalsIgnoreCase("Vistara") ||
					flightName.equalsIgnoreCase("IndiGo") ||
					flightName.equalsIgnoreCase("Air Arabia")) {
				return true;
			}
			throw new InvalidFlightException("The flight name "+flightName+" is invalid");
		}
		
		//validating Passenger Count
		public boolean validatePassengerCount(int passengerCount,String flightName) throws InvalidFlightException{
			
			if(flightName.equalsIgnoreCase("SpiceJet")) {
				if(passengerCount<=spiceJetCapacity && passengerCount>0) {
					return true;
				}else {
					throw new InvalidFlightException("The passenger count "+passengerCount+" is invalid for "+flightName);
				}
			}else if (flightName.equalsIgnoreCase("Vistara")) {
				if(passengerCount<=vistaraCapacity && passengerCount>0) {
					return true;
				}else {
					throw new InvalidFlightException("The passenger count "+passengerCount+" is invalid for "+flightName);
				}
			}else if (flightName.equalsIgnoreCase("IndiGo")) {
				if(passengerCount<=indiGoCapacity && passengerCount>0) {
					return true;
				}else {
					throw new InvalidFlightException("The passenger count "+passengerCount+" is invalid for "+flightName);
				}
			}else if (flightName.equalsIgnoreCase("Air Arabia")) {
				if(passengerCount<=airArabiaCapacity && passengerCount>0) {
					return true;
				}else {
					throw new InvalidFlightException("The passenger count "+passengerCount+" is invalid for "+flightName);
				}
			}
			
			throw new InvalidFlightException("The flight name "+flightName+" is invalid");
		}
		
		//validating the fuel capacity 
		public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
			
			if(flightName.equalsIgnoreCase("SpiceJet")) {
				if(currentFuelLevel>0 && currentFuelLevel<= spiceJetFuelCapacity ) {
					return spiceJetFuelCapacity-currentFuelLevel;
				}else {
					throw new InvalidFlightException("Invalid fuel level for "+flightName);
				}
			}else if(flightName.equalsIgnoreCase("Vistara")){
				if(currentFuelLevel>0 && currentFuelLevel<= vistaraFuelCapacity ) {
					return vistaraFuelCapacity-currentFuelLevel;
				}else {
					throw new InvalidFlightException("Invalid fuel level for "+flightName);
				}
			}else if(flightName.equalsIgnoreCase("IndiGo")){
				if(currentFuelLevel>0 && currentFuelLevel<= indiGoFuelCapacity ) {
					return indiGoFuelCapacity-currentFuelLevel;
				}else {
					throw new InvalidFlightException("Invalid fuel level for "+flightName);
				}
			}else if(flightName.equalsIgnoreCase("Air Arabia")){
				if(currentFuelLevel>0 && currentFuelLevel<= airArabiaFuelCapacity ) {
					return airArabiaFuelCapacity-currentFuelLevel;
				}else {
					throw new InvalidFlightException("Invalid fuel level for "+flightName);
				}
			}
			
			throw new InvalidFlightException("Invalid fuel level for "+flightName);
		}
		
		
		//
				
}
