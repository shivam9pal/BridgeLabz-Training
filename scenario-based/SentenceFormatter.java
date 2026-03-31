package week02.scenario;

import java.util.Scanner;

public class SentenceFormatter {
	public static String fornatString(String str) {
		//base condition
		if(str.isEmpty() || str==null) {
			return str;
		}
		str.trim();
		StringBuilder sb=new StringBuilder();
		//check for character 
		boolean capitaLizeNext=true;
		boolean spaceAllow=false;
		//iterating through string 
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			//checking charcter
			if(Character.isLetter(ch)) {
				if(capitaLizeNext) {
					sb.append(Character.toUpperCase(ch));
					capitaLizeNext=false;
				}else {
					sb.append(ch);
				}
				spaceAllow=true;
			}
			
			
			//punctuation
			else if(ch=='.' || ch=='?' || ch=='!'){
				sb.append(ch);
				sb.append(' ');
				capitaLizeNext=true;
				spaceAllow=false;
			}else if(ch==' ' && spaceAllow) {
				sb.append(' ');
				spaceAllow=false;
			}
		}
		return sb.toString();
	}
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the paragraph to Check Formatting ");
		String userInput=sc.nextLine();
		String formattedString=fornatString(userInput);
		System.out.println(formattedString);
		
	}
}
