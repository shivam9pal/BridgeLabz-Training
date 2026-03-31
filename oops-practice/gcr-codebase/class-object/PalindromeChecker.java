package week02.gcrCodebase.classObject;

public class PalindromeChecker {
	private String text;
	//checking 
    boolean isPalindrome() {
        String clean = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String rev = new StringBuilder(clean).reverse().toString();
        return clean.equals(rev);
    }
    //Displaying result
    void displayResult() {
        if (isPalindrome())
            System.out.println(text + " is palindrome");
        else
            System.out.println(text + " is not Palindrome");
    }

    public static void main(String[] args) {
        PalindromeChecker p1 = new PalindromeChecker();
        p1.text = "A man a plan a canal Panama";
        p1.displayResult();

        PalindromeChecker p2 = new PalindromeChecker();
        p2.text = "Hello";
        p2.displayResult();
    }

}
