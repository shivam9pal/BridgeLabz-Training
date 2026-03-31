package week05.gcrcodebase.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateCSV {

    public static void main(String[] args) {

        String inputFile = "employee.csv";
        String outputFile = "updated_employees.csv";
        String line;

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {

            // Read and write header
            line = br.readLine();
            bw.write(line);
            bw.newLine();

            // Process remaining lines
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                // Increase salary by 10% for IT department
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary + (salary * 0.10);
                }

                // Write updated record
                bw.write(data[0] + "," + data[1] + "," + department + "," + (int)salary);
                bw.newLine();
            }

            System.out.println("CSV file updated successfully. Check: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

