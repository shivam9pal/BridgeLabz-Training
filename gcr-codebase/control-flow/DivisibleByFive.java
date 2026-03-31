package week01.flowControl.level1;

import java.util.Scanner;

class DivisibleByFive {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number from user
        System.out.println("Enter=");
        int number = sc.nextInt();

        // Check divisibility 
        boolean result = (number % 5 == 0);

        System.out.println("Is the number " + number + " divisible by 5? " + result);

        sc.close();
    }
}

