package practiceProblemDay1;
import java.util.Scanner;

public class AreaOfCircle {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking User input
        System.out.print("Enter radius= ");
        double radius = sc.nextDouble();
        
        // Printing the are of Circle 
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle = " + area);
    }

}
