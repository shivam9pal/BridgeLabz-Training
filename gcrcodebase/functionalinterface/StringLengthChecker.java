package week06.gcrcodebase.functionalinterface;

import java.util.function.Function;

class StringLengthChecker {
	public static void main(String[] args) {
		
		Integer length=5;
		
		//function for length checker
		Function<String, Boolean> isStringGreater= str->str.length()>length;
		
		System.out.println(isStringGreater.apply("hellooo"));
	}
}
