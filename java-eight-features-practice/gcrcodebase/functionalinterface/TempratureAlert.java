package week06.gcrcodebase.functionalinterface;

import java.util.function.Predicate;

class TempratureAlert {
	public static void main(String[] args) {
		double threshold=37.5;
		//predicate
		Predicate<Double> isThreshold=temp->temp>threshold;
		
		double[] readings = {36.8, 37.2, 38.1, 39.0, 36.5};
		
		for(Double t: readings) {
			if(isThreshold.test(t)) {
				System.out.println("ALERT! High Temperature: " + t);
			}else {
                System.out.println("Normal Temperature: " + t);
            }
		}
	}
}
