package week01.flowControl.level3;

import java.util.Scanner;


public class AbundantNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking user input        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int sum = 0;
        
        
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }
        
       //Checking divisibility
        if (sum > number) {
            System.out.println(number + " is an Abundant Number");
        } else {
            System.out.println(number + " is Not an Abundant Number");
        }
        
        scanner.close();
    }
}
