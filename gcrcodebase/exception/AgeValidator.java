package week04.gcrcodebase.exception;

import java.util.Scanner;

//Custom Exception
class InvalidAgeException extends Exception {
 public InvalidAgeException(String message) {
     super(message);
 }
}

public class AgeValidator {

 // Method to validate age
 static void validateAge(int age) throws InvalidAgeException {
     if (age < 18) {
         throw new InvalidAgeException("Age must be 18 or above");
     }
     System.out.println("Age is valid.");
 }

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     try {
         System.out.print("Enter your age: ");
         int age = sc.nextInt();

         validateAge(age);

     } catch (InvalidAgeException e) {
         System.out.println("Age must be 18 or above");

     } catch (Exception e) {
         System.out.println("Please enter a valid number.");

     } finally {
         sc.close();
     }
 }
}

