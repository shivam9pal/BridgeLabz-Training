package week01.flowControl.level3;

import java.util.Scanner;


public class LeapYearSingleIf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        
        // Single if condition using logical operators
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year");
        } else if (year < 1582) {
            System.out.println("Year must be 1582 or later (Gregorian calendar)");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
        
        scanner.close();
    }
}
