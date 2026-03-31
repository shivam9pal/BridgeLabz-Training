package week01.flowControl.level3;

import java.util.Scanner;


public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int m = scanner.nextInt();
        
        System.out.print("Enter day: ");
        int d = scanner.nextInt();
        
        System.out.print("Enter year: ");
        int y = scanner.nextInt();
        
        // Calculate y0 
        int y0 = y - (14 - m) / 12;
        
        // Calculate x 
        int x = y0 + y0/4 - y0/100 + y0/400;
        
        // Calculate m0 
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        
        // Calculate d0 
        int d0 = (d + x + 31*m0 / 12) % 7;
        
        // Array of day names
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        //Displaying the Day
        System.out.println("Day of the week: " + d0 + " (" + days[d0] + ")");
        
        scanner.close();
    }
}
