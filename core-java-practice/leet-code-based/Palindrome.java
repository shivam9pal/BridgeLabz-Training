package week01.leetcode;

public class Palindrome {
	public boolean isPalindrome(int x) {
        String s=Integer.toString(x);
        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
