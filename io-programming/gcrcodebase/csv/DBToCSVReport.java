package week05.gcrcodebase.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBToCSVReport {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String password = "12345";

        String csvFile = "employee_report.csv";
        String query = "SELECT id, name, department, salary FROM employees";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))
        ) {

            // Write CSV header
            bw.write("Employee ID,Name,Department,Salary");
            bw.newLine();

            // Write data rows
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                String salary = rs.getString("salary");

                bw.write(id + "," + name + "," + dept + "," + salary);
                bw.newLine();
            }

            System.out.println("CSV report generated successfully: " + csvFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

