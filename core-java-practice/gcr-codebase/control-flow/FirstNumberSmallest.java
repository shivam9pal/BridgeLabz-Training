package week01.flowControl.level1;


import java.util.Scanner;

class FirstNumberSmallest {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers ");
        
        // Input values for three numbers
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();
        
        // Checking if first number is smaller than both second and third
        if (number1 < number2 && number1 < number3) {
            System.out.println("Is the first number the smallest? true");
        } else {
            System.out.println("Is the first number the smallest? false");
        }
        
       
    }
}
