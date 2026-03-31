package week05.gcrcodebase.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CiuntCSVRows {
	public static void main(String[] args) {
		 String filePath = "src\\student.csv";
	        int rowCount = 0;
	        
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

	            // Skip header
	            br.readLine();

	            // Count remaining lines
	            while (br.readLine() != null) {
	                rowCount++;
	            }

	            System.out.println("Total number of records (excluding header): " + rowCount);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	}
}
