package week06.gcrcodebase.functionalinterface;

import java.time.LocalDate;

import javax.swing.text.DateFormatter;

interface DateTimeFormatter{
	static String format(LocalDate date,String pattern ) {
		DateTimeFormatter format=DateTimeFormatter.ofPattern(pattern);
		return date.format(format);
	}
}
class DateTimeFormat {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();

        String format1 = DateFormatter.format(today, "dd-MM-yyyy");
        String format2 = DateFormatter.format(today, "MMMM dd, yyyy");
        String format3 = DateFormatter.format(today, "yyyy/MM/dd");

        System.out.println("Format 1: " + format1);
        System.out.println("Format 2: " + format2);
        System.out.println("Format 3: " + format3);
	}
}	
