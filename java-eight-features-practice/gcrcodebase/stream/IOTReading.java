package week06.gcrcodebase.stream;

import java.util.Arrays;
import java.util.List;

class IOTReading {
	 public static void main(String[] args) {
		 List<Double> sensorReadings = Arrays.asList(
	             22.5, 35.0, 18.2, 40.7, 29.9, 45.3
	     );

	     double threshold = 30.0;

	     System.out.println("=== Readings Above Threshold ===");

	     sensorReadings.stream()
	                   .filter(reading -> reading > threshold)
	                   .forEach(reading ->
	                       System.out.println("High Reading: " + reading)
	                   );
	 }
	
}
