package week01.string.level3;


import java.util.Scanner;
public class BMIIndexCalculator {
	
	//Method to calculate BMI and return status
    public static String[] calculateBMI(double weightKg, double heightCm) {
        double heightMeter = heightCm / 100; 
        double bmi = weightKg / (heightMeter * heightMeter);

        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[] {
                String.format("%.2f", bmi),
                status
        };
    }
    
    // Method to process height & weight array and return result array
    	    public static String[][] generateBMIReport(double[][] data) {
    	        String[][] result = new String[data.length][4];

    	        for (int i = 0; i < data.length; i++) {
    	            double weight = data[i][0];
    	            double height = data[i][1];

    	            String[] bmiData = calculateBMI(weight, height);

    	            result[i][0] = String.valueOf(height);
    	            result[i][1] = String.valueOf(weight);
    	            result[i][2] = bmiData[0];
    	            result[i][3] = bmiData[1];
    	        }
    	        return result;
    	    }
    	    
    	 // Method to display data in tabular format
    	    public static void displayReport(String[][] report) {
    	        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
    	        

    	        for (String[] row : report) {
    	            System.out.printf("%-10s\t%-10s\t%-6s\t%s\n",
    	                    row[0], row[1], row[2], row[3]);
    	        }
    	    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//input data array
		double[][] inputData=new double[10][2];
		
		//Taking 2-d array Input 
		
		for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1));
            System.out.print("Weight (kg): ");
            inputData[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            inputData[i][1] = sc.nextDouble();
        }
		
		
		// Displaying the Results
		String[][] bmiReport = generateBMIReport(inputData);
        displayReport(bmiReport);

        sc.close();
	}

}
