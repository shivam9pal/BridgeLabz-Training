package week01.method;


public class BonusCalculator {

    //generate salary and years of service
    public static int[][] generateEmployeeData(int employees) {

        int[][] data = new int[employees][2];

        for (int i = 0; i < employees; i++) {
            data[i][0] = (int) (Math.random() * 90000) + 10000;

            data[i][1] = (int) (Math.random() * 10) + 1;
        }

        return data;
    }

    //calculate new salary and bonus
    public static double[][] calculateBonusAndNewSalary(int[][] employeeData) {

        int employees = employeeData.length;
        double[][] result = new double[employees][3];

        for (int i = 0; i < employees; i++) {
            int salary = employeeData[i][0];
            int years = employeeData[i][1];

            double bonus;

            if (years > 5) {
                bonus = salary * 0.05;   
            } else {
                bonus = salary * 0.02;   
            }

            double newSalary = salary + bonus;
            result[i][0] = salary;
            result[i][1] = bonus;
            result[i][2] = newSalary;
        }

        return result;
    }

    //calculate totals and display result in tabular format
    public static void displaySalaryDetails(
            int[][] employeeData,
            double[][] salaryResult) {

        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;

        System.out.println("Emp\tYears\tOld Salary\tBonus\t\tNew Salary");

        for (int i = 0; i < employeeData.length; i++) {

            int years = employeeData[i][1];
            double oldSalary = salaryResult[i][0];
            double bonus = salaryResult[i][1];
            double newSalary = salaryResult[i][2];

            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.printf("%d\t%d\t%.0f\t\t%.2f\t%.2f%n",(i + 1), years, oldSalary, bonus, newSalary
            );
        }

        System.out.printf("TOTAL\t\t%.0f\t\t%.2f\t%.2f%n",
                totalOldSalary, totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {

        int employees = 10;

        int[][] employeeData = generateEmployeeData(employees);

        double[][] salaryResult = calculateBonusAndNewSalary(employeeData);

        // Display all results
        displaySalaryDetails(employeeData, salaryResult);
    }
}

