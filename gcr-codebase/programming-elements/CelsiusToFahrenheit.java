package practiceProblemDay1;
import java.util.Scanner;

public class CelsiusToFahrenheit {

	
		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
			// Taking user Input 
	        System.out.print("Enter temperature in Celsius= ");
	        double celsius = sc.nextDouble();
			// Converting and Printing the Temprature 
	        double fahrenheit = (celsius * 9 / 5) + 32;
	        System.out.println("Temperature in Fahrenheit = " + fahrenheit);

	}

}
