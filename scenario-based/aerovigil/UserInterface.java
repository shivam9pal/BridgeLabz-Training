package week03.scenariobased.aerovigil;

import java.util.Scanner;

class UserInterface {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		FlightUtil flightUtil=new FlightUtil();
		System.out.println("Enter the flight details in this format : "
				+ "\n <FlightNumber>:<FlightName>:<PassengerCount>:<CurrentFuelLevel>.");
		//taking user input 
		try {
			String flightInput=sc.nextLine();
			String[] i=flightInput.split(":");
			
			//flight parameters
			String flightNumber=i[0];
			String flightName=i[1];
			int passengerCount=Integer.parseInt(i[2]);
			double currentFuelLevel=Double.parseDouble(i[3]);
			
			boolean flightNumberResponse=flightUtil.validateFlightNumber(flightNumber);
			boolean flightNameResponse=flightUtil.validateFlightName(flightName);
			boolean flightPassengerCountResponse=flightUtil.validatePassengerCount(passengerCount, flightName);
			
			double fuelToFill=flightUtil.calculateFuelToFillTank(flightName, currentFuelLevel);
			System.out.println("Fuel required to fill tank: "+fuelToFill+" liters");
			
		} catch (InvalidFlightException e) {
			System.out.println(e.getMessage());
		}
	}
}
