package week01.programmingElements;

import java.util.Scanner;

public class FeetConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taken user input 
        System.out.print("Enter distance in feet: ");
        double feet = sc.nextDouble();

        double yards = feet / 3;
        double miles = yards / 1760;
        // Displaying the results 
        System.out.println("Distance in yards is " + yards +
                " and in miles is " + miles);
    }
}
