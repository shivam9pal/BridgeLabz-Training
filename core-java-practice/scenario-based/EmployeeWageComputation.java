package scenarioBased;


public class EmployeeWageComputation {
	//Attendance of Employee and also for full time and partTime
	public static int isPresent() {
		int value=(int)(Math.random() * 2);
		if(value==1) {
			return 1;
		}
		return 0;
	} 
	//Calculate Wage of An Employee
	public static double[] wageOfEmployee() {
		final int wagePerHour=20;
		final int maxHours=100;
		final int maxDays=20;
		final int fullWorkingHours=8;
		final int partTimeHours=8;
		int totalWorkingHours=0;
		int totalWorkingDays=0;
		double employeeWage=0;
		boolean partOrFull =true;
		
		//Calculating wages
		while(totalWorkingHours<=maxHours && totalWorkingDays< maxDays) {
			
			//increasing day
			totalWorkingDays++;
			//check for Employee Attendance
			if(isPresent()==0) {
				System.out.println("Day " + totalWorkingDays + ":Today Employee is Absent");
				continue;
			}else {
				
				switch(isPresent()) {
				case 1:
					totalWorkingHours+=fullWorkingHours;
					System.out.println("Day " + totalWorkingDays + ":Today Employee is Full Time");
					break;
				case 0:
					totalWorkingHours+=partTimeHours;
					partOrFull=false;
					System.out.println("Day " + totalWorkingDays + ":Today Employee is Part Time");
				}
				
			}
			//Calculating dailyWage
			int dailyWage=0;
			if(partOrFull) {
				dailyWage=fullWorkingHours*wagePerHour;
			}else {
				dailyWage=partTimeHours*wagePerHour;
			}
			employeeWage+=dailyWage;
			//Displaying  daily Wages
			System.out.println("Daily Wage :"+ dailyWage +" Of day :" );
			System.out.println("---------------------------------------");
			
		}
		return new double[] {employeeWage,totalWorkingDays,totalWorkingHours};
	}
	
	public static void main(String[] args) {
		System.out.println("----Welcome to employee wage computation program -----");
		double[] employeeMonthlyData=wageOfEmployee();
		double totalWage=employeeMonthlyData[0];
		int monthlyWorkingDays=(int)employeeMonthlyData[1];
		int monthlyWorkinghours=(int)employeeMonthlyData[2];
		//Displaying the Total Wage
		System.out.println("---Monhtly Wage Summary -----");
		System.out.println("\nThe Complete Monthly Wage of Worker is :" +totalWage);
		System.out.printf("\nThe Total working hours :%d\nThe total working hours are %d",monthlyWorkinghours,monthlyWorkingDays);
	} 
}
