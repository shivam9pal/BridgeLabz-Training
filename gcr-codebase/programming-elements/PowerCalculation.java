package practiceProblemDay1;
import java.util.Scanner;

public class PowerCalculation {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking the user input 
        System.out.print("Enter base= ");
        double base = sc.nextDouble();

        System.out.print("Enter exponent= ");
        double exponent = sc.nextDouble();
        // Displaying the Result 
        double result = Math.pow(base, exponent);
        System.out.println("Result = " + result);
    }

}
