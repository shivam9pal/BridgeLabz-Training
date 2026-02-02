package week05.gcrcodebase.csv;

import java.io.FileWriter;

class WriteCSV {
	public static void main(String[] args) {
		String filePath="src\\employee.csv";
		
		try(FileWriter writer=new FileWriter(filePath)) {
			 writer.append("ID,Name,Department,Salary\n");

	            // Writing employee records
	            writer.append("201,John Smith,HR,45000\n");
	            writer.append("202,Alice Brown,IT,60000\n");
	            writer.append("203,David Lee,Finance,55000\n");
	            writer.append("204,Sophia Clark,Marketing,50000\n");
	            writer.append("205,Michael Scott,Sales,65000\n");
	            
	            System.out.println("CSV file created and data written successfully.");
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
