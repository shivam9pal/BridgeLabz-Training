package week01.extrasBuiltInFunction;

import java.time.LocalDate;

public class DateCompare {
	
	public static void main(String[] args) {
	
		//Taking LocalDate
		LocalDate today=LocalDate.of(2025,12,29);
		LocalDate tommorrow=LocalDate.of(2025,12,30);
		
		//Displaying the compared dates
		if(today.isBefore(tommorrow)) {
			System.out.println("today is before tommorrow");
		}else if(today.isAfter(tommorrow)) {
			System.out.println("today is After tommorrow");
		}else if(today.isEqual(tommorrow)) {
			System.out.println("today & tommorrow are same date");
		}
		
	}
}
