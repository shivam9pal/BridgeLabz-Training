package week01.leetcode;

public class Palindrome {

    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome solution = new Palindrome();

        // Test 
        System.out.println("Is 121 palindrome? " + solution.isPalindrome(121));
    }
}
