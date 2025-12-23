package practiceProblemDay1;
import java.util.Scanner;

public class AverageOfThree {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking User input 
        System.out.print("Enter Three number sperated By Spaces= ");
        double a = sc.nextDouble();        
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        // Printing the Average
        double average = (a + b + c) / 3;
        System.out.println("Average = " + average);
    }

}
