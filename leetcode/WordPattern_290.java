package week_4;

import java.util.*;

public class WordPattern_290 {
	public boolean wordPattern(String pattern, String s) {
		String[] arr = s.split(" ");
		if (pattern.length() != arr.length) {
			return false;
		}
		HashMap<Character, String> hm = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			boolean containsKey = hm.containsKey(ch);
			if (hm.containsValue(arr[i]) && !containsKey) {
				return false;
			}
			if (containsKey && !hm.get(ch).equals(arr[i])) {
				return false;
			} else {
				hm.put(ch, arr[i]);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		WordPattern_290 wp = new WordPattern_290();
		String pattern = "abba";
		String s = "dog cat cat dog";
		System.out.println(wp.wordPattern(pattern, s));
	}
}
