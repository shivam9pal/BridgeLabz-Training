package week01.flowControl.level2;

import java.util.Scanner;

public class YoungestAndTallestFriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input       
        System.out.println(" Youngest and Tallest Friend ");
        
        System.out.print("Enter Amar's age: ");
        int amarAge = scanner.nextInt();
        System.out.print("Enter Amar's height (cm): ");
        double amarHeight = scanner.nextDouble();
        
        System.out.print("Enter Akbar's age: ");
        int akbarAge = scanner.nextInt();
        System.out.print("Enter Akbar's height (cm): ");
        double akbarHeight = scanner.nextDouble();
        
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = scanner.nextInt();
        System.out.print("Enter Anthony's height (cm): ");
        double anthonyHeight = scanner.nextDouble();
        
        // Find youngest
        String youngest = "Amar";
        int minAge = amarAge;
        
        if (akbarAge < minAge) {
            youngest = "Akbar";
            minAge = akbarAge;
        }
        if (anthonyAge < minAge) {
            youngest = "Anthony";
            minAge = anthonyAge;
        }
        
        // Find tallest
        String tallest = "Amar";
        double maxHeight = amarHeight;
        
        if (akbarHeight > maxHeight) {
            tallest = "Akbar";
            maxHeight = akbarHeight;
        }
        if (anthonyHeight > maxHeight) {
            tallest = "Anthony";
            maxHeight = anthonyHeight;
        }
        //Displaying Youngest and tallest
        System.out.println("\nYoungest friend: " + youngest + " (Age: " + minAge + ")");
        System.out.println("Tallest friend: " + tallest + " (Height: " + maxHeight + " cm)");
        
        scanner.close();
    }
}
