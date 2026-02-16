package scenarioBased;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

interface IEmpWageBuilder {

    void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);

    void computeEmpWage();

    int getTotalWage(String company);
}

class EmpWageController {

    private IEmpWageBuilder empWageBuilder;

    public EmpWageController(IEmpWageBuilder empWageBuilder) {
        this.empWageBuilder = empWageBuilder;
    }

    public void setupCompanies() {
        empWageBuilder.addCompanyEmpWage("TCS", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Infosys", 25, 22, 120);
        empWageBuilder.addCompanyEmpWage("Wipro", 22, 20, 110);
    }

    public void addCompany(String name, int wage, int days, int maxHrs) {
        empWageBuilder.addCompanyEmpWage(name, wage, days, maxHrs);
    }

    public void processWages() {
        empWageBuilder.computeEmpWage();
    }

    public void queryCompanyWage(String company) {
        System.out.println("Total Wage of " + company + " = " + empWageBuilder.getTotalWage(company));
    }
}

class CompanyEmpWage {

    public final String company;
    public final int empRatePerHour;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public int totalEmpWage;
    public List<Integer> dailyWages = new ArrayList<>();

    public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString() {
        return "Company: " + company + ", Total Wage: " + totalEmpWage;
    }
}

class EmpWageBuilder implements IEmpWageBuilder {

    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private List<CompanyEmpWage> companyEmpWageList = new ArrayList<>();
    private Map<String, CompanyEmpWage> companyMap = new HashMap<>();

    @Override
    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        CompanyEmpWage companyEmpWage
                = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        companyEmpWageList.add(companyEmpWage);
        companyMap.put(company, companyEmpWage);
    }

    @Override
    public void computeEmpWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            companyEmpWage.setTotalEmpWage(computeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage);
        }
    }

    private int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs, totalEmpHrs = 0, totalWorkingDays = 0;

        while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth
                && totalWorkingDays < companyEmpWage.numOfWorkingDays) {

            totalWorkingDays++;

            int empCheck = (int) (Math.random() * 3);  // UC1
            switch (empCheck) {                        // UC4
                case IS_PART_TIME:
                    empHrs = 4;                        // UC3
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;                        // UC2
                    break;
                default:
                    empHrs = 0;
            }

            int dailyWage = empHrs * companyEmpWage.empRatePerHour; // UC2
            companyEmpWage.dailyWages.add(dailyWage);               // UC13
            totalEmpHrs += empHrs;
        }

        return totalEmpHrs * companyEmpWage.empRatePerHour;         // UC5, UC6
    }

    @Override
    public int getTotalWage(String company) {
        return companyMap.get(company).totalEmpWage;                // UC13
    }
}

public class EmployeeWageComputation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        IEmpWageBuilder empWageBuilder = new EmpWageBuilder();
        EmpWageController controller = new EmpWageController(empWageBuilder);

        int choice;

        do {
            System.out.println("\n========= Employee Wage Computation =========");
            System.out.println("1. Add Company");
            System.out.println("2. Compute Wages for All Companies");
            System.out.println("3. Get Total Wage by Company");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Company Name: ");
                    String name = sc.next();

                    System.out.print("Enter Wage per Hour: ");
                    int wage = sc.nextInt();

                    System.out.print("Enter Working Days per Month: ");
                    int days = sc.nextInt();

                    System.out.print("Enter Max Hours per Month: ");
                    int maxHrs = sc.nextInt();

                    controller.addCompany(name, wage, days, maxHrs);
                    System.out.println("Company added successfully!");
                    break;

                case 2:
                    controller.processWages();
                    System.out.println("Wages computed successfully!");
                    break;

                case 3:
                    System.out.print("Enter Company Name: ");
                    String company = sc.next();
                    controller.queryCompanyWage(company);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }

}
