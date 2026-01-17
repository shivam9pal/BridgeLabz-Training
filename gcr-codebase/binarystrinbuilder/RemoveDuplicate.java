package week03.gcrcodebase.binarystrinbuilder;

import java.util.HashSet;

class RemoveDuplicate {
	public static String removeDuplicates(String str) {
		StringBuilder sb=new StringBuilder();
		HashSet<Character> set=new HashSet<>();
		
		for(char ch:str.toCharArray()) {
			if(!set.contains(ch)) {
				sb.append(ch);
				set.add(ch);
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String input = "programming";
        String output = removeDuplicates(input);
        System.out.println("Original: " + input);
        System.out.println("Without duplicates: " + output);
	}
}
