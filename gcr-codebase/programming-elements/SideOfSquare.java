package week01.programmingElements.level2;
import java.util.Scanner;


public class SideOfSquare {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // taking user input 
        System.out.print("Enter perimeter of square: ");
        double perimeter = sc.nextDouble();
        // Calculating the side 
        double side = perimeter / 4;
        // Displaying the Side 
        System.out.println("The length of the side is " 
                + side + " whose perimeter is " + perimeter);
    }

}
