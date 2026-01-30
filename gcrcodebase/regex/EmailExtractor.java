package week04.gcrcodebase.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EmailExtractor {
	public static void main(String[] args) {
		String regex="[A-Za-z0-9+_%.]+@[A-Za-z0-9.]+\\.[a-z]{2,}";
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the String to extract emails ->");
		String input=scanner.nextLine();
		
		
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(input);
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
