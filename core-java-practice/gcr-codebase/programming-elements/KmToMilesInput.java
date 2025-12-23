package week01.programmingElements;
import java.util.Scanner;


public class KmToMilesInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Taking Distance as user input
        System.out.print("Enter kilometers: ");
        double km = input.nextDouble();
        // Displaying the converted distance 
        double miles = km / 1.6;
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
    }
}
