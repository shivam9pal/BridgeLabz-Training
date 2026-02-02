package week05.gcrcodebase.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Employee {
    String id, name, department;
    int salary;

    Employee(String id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class SortCSVBySalary {

    public static void main(String[] args) {

        String filePath = "employees.csv";
        List<Employee> employees = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            // Read data into list
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                employees.add(new Employee(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3])
                ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort by salary descending
        employees.sort((e1, e2) -> e2.salary - e1.salary);

        System.out.println("Top 5 Highest-Paid Employees:\n");

        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            Employee e = employees.get(i);
            System.out.println("ID        : " + e.id);
            System.out.println("Name      : " + e.name);
            System.out.println("Department: " + e.department);
            System.out.println("Salary    : " + e.salary);
            System.out.println("---------------------------");
        }
    }
}

