package week01.flowControl.level1;

import java.util.Scanner;

class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the numbers ");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();
        
        // Check if first number is the largest
        if (number1 > number2 && number1 > number3) {
            System.out.println("Is the first number the largest? true");
        } else {
            System.out.println("Is the first number the largest? false");
        }
        
        // Check if second number is the largest
        if (number2 > number1 && number2 > number3) {
            System.out.println("Is the second number the largest? true");
        } else {
            System.out.println("Is the second number the largest? false");
        }
        
        // Check if third number is the largest
        if (number3 > number1 && number3 > number2) {
            System.out.println("Is the third number the largest? true");
        } else {
            System.out.println("Is the third number the largest? false");
        }
        
        
    }
}
