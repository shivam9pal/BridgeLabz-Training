package week01.programmingElements.level2;

import java.util.Scanner;

public class DistanceConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking user input 
        System.out.print("Enter distance in feet: ");
        double feet = sc.nextDouble();
        // Converting the distance
        double yards = feet / 3;
        double miles = yards / 1760;
        // displaying the distnace 
        System.out.println("The distance in yards is " 
                + yards + " while the distance in miles is " + miles);
    }
}

