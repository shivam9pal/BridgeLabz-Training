package week01.programmingElements.level2;

import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking user input 
        System.out.print("Enter base in cm: ");
        double base = sc.nextDouble();

        System.out.print("Enter height in cm: ");
        double height = sc.nextDouble();
        // Caluclating the area
        double areaCm = 0.5 * base * height;
        double areaIn = areaCm / (2.54 * 2.54);
        // displaying the Area
        System.out.println("The Area of the triangle in sq in is " 
                + areaIn + " and sq cm is " + areaCm);
    }
}

