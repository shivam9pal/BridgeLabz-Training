package week05.gcrcodebase.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSV {

    public static void main(String[] args) {

        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentMap = new HashMap<>();
        String line;

        try {
            // Step 1: Read students1.csv
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            br1.readLine(); // skip header

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentMap.put(data[0], new String[]{data[1], data[2]}); // Name, Age
            }
            br1.close();

            // Step 2: Read students2.csv and merge
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            br2.readLine(); // skip header

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];

                if (studentMap.containsKey(id)) {
                    String name = studentMap.get(id)[0];
                    String age = studentMap.get(id)[1];
                    String marks = data[1];
                    String grade = data[2];

                    bw.write(id + "," + name + "," + age + "," + marks + "," + grade);
                    bw.newLine();
                }
            }

            br2.close();
            bw.close();

            System.out.println("CSV files merged successfully into " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

