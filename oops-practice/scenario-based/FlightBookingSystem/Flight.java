package week02.scenario.FlightBookingSystem;

public abstract class Flight {
	private int flightNo;
	private String flightName;
	private double fare;
	private String origin;
	private String destination;
	
	Flight(int flightNo,String flightName,double Fare,String origin,String destination){
		this.flightName=flightName;
		this.flightNo=flightNo;
		this.destination=destination;
		this.origin=origin;
		this.fare=fare;
	}

	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", flightName=" + flightName + ", fare=" + fare + ", origin=" + origin
				+ ", destination=" + destination + "]";
	}

	public int getFlightNo() {
		return flightNo;
	}

	public String getFlightName() {
		return flightName;
	}

	public double getFare() {
		return fare;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}
	
	
	
	
	
}
