package review.flighbookingsystem;

abstract class Flight {
	
	private String name;
	private String origin;
	private String destination;
	private int baseFare;
	private int seats;
	
	Flight(String name,String origin,String destination,int baseFare, int seats){
		this.name=name;
		this.origin=origin;
		this.destination=destination;
		this.baseFare=baseFare;
		this.seats=seats;
	}

	String getName() {
		return name;
	}

	String getOrigin() {
		return origin;
	}

	String getDestination() {
		return destination;
	}

	int getBaseFare() {
		return baseFare;
	}
	int getSeats() {
		return seats;
	}

	@Override
	public String toString() {
		return "Flight \nname=" + name + ",\n origin=" + origin + ",\n destination=" + destination + ",\n baseFare=" + baseFare
				+ "\n";
	}
	
}
