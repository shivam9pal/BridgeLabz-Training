package week02.scenario.ridemanagementsystem;

class NormalHourPricing implements FareCalculator {
	@Override
	public double calculateFare(double distance) {
		return distance *10;//normal fare
	}
}
