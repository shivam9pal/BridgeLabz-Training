package scenarioBased;

import java.util.Scanner;

public class SandeepFitness {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] pushUp = new int[7];
        int day = 0;
        //Taking input from user of activity
        while (day < 7) {
            System.out.print("Enter 1 to enter pushups or 0 to skip day: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.printf("Enter pushups done on day %d: ", day + 1);
                pushUp[day] = sc.nextInt();
                day++;
            } else if (choice == 0) {
                pushUp[day] = 0;
                day++;
            } else {
                System.out.println("Invalid input! Enter only 1 or 0.");
            }
        }

        int sum = 0;
        int skip = 0;
        int workoutDays = 0;
        double average;
        //Extracting the PushUp
        for (int p : pushUp) {
            if (p == 0) {
                skip++;
            } else {
                sum += p;
                workoutDays++;
            }
        }
        //Calculating average
        if(workoutDays>0) {
        	average = (double) sum / workoutDays;
        }else {
        	average=0;
        }
        
        //Displaying the reuslt 
        System.out.println("\n--- Weekly Fitness Report ---");
        System.out.printf("Average Pushups: %.2f\n", average);
        System.out.printf("Days Skipped: %d\n", skip);

        sc.close();
    }
}
