package week01.extrasBuiltInFunction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormattingExample {
	
	public static void main(String[] args) {
		
		//Taking local date 
		LocalDate date=LocalDate.now();
		
		DateTimeFormatter formatA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatB = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatC = DateTimeFormatter.ofPattern("EEE, MM dd, yyyy");
		
		//Displaying dates in dfferent format
		System.out.println("Format A : "+ date.format(formatA));
		System.out.println("Format B : "+ date.format(formatB));
		System.out.println("Format C : "+ date.format(formatC));
	}

}
