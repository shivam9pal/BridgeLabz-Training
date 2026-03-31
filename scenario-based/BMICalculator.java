package scenarioBased;


import java.util.Scanner;
public class BMICalculator {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Taking users height and weight
		System.out.print("Enter height in meters: ");
        double heightInMeters = sc.nextDouble();
        System.out.print("Enter weight in kilograms: ");
        double weightInKg = sc.nextDouble();
        
        // BMI Formula: BMI = weight / (height * height)
        double bmi = weightInKg / (heightInMeters * heightInMeters);
        
        // Display calculated BMI
        System.out.printf("\nYour BMI is: %.2f\n", bmi);
        
     
        if (bmi < 18.5) {
            System.out.println("BMI Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("BMI Category: Normal");
        } else {
            System.out.println("BMI Category: Overweight");
        }

        sc.close();

		
		
		
	}
}
