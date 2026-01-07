package week02.scenario.ridemanagementsystem;

class PeakHourPricing implements FareCalculator {
	@Override
	public double calculateFare(double distance) {
		return distance*20;// returning fare for peak hour 	
		}
}
