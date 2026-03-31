package scenarioBased;

import java.util.Scanner;

public class BusRootDistanceTracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double totalDistance = 0.0;
        boolean continueJourney = true;
        //Making bus journey
        while (continueJourney) {

            System.out.print("Enter distance covered till next stop (in km): ");
            double distance = scanner.nextDouble();
            totalDistance += distance;

            System.out.println("Total distance covered so far: " + totalDistance + " km");

            System.out.print("Do you want to get off at this stop? (yes/no): ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("yes")) {
                continueJourney = false;
            }
        }
        //Displaying results
        System.out.println("Passenger got off the bus.");
        System.out.println("Total distance traveled: " + totalDistance + " km");

        scanner.close();
    }
}
