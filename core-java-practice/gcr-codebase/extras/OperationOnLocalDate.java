package week01.extrasBuiltInFunction;

import java.time.LocalDate;

public class OperationOnLocalDate {
	public static void main(String[] args) {
		//Taken local date 
		LocalDate date=LocalDate.of(2025,12,10);
		
		LocalDate result=date.plusDays(7)
								.plusMonths(1)
								.plusYears(2)
								.minusWeeks(7);
		
		//Displaying Change in time 
		System.out.println("Local Date and time \t\t:" +date);
		System.out.println("Local Date and time after performing chgnges :" +result);
	}

}
