package week_4;

public class DetectCapital_520 {
	public boolean detectCapitalUse(String word) {
        if (Character.isUpperCase(word.charAt(0))) {
            if (word.length() > 1 && Character.isUpperCase(word.charAt(1))) {
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isLowerCase(word.charAt(i))) {
                        return false;
                    }
                }
            }else {
                for (int i = 1; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
            }

        }else {
            for (int i = 0; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
	public static void main(String[] args) {
		DetectCapital_520 dc = new DetectCapital_520();
		String word = "FlaG";
		System.out.println(dc.detectCapitalUse(word));
	}
}
