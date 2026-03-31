package week01.flowControl.level1;

import java.util.Scanner;

public class RocketCountdownFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter countdown value: ");
        int counter = scanner.nextInt();
        
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        
        System.out.println("Liftoff!");
        scanner.close();
    }
}
