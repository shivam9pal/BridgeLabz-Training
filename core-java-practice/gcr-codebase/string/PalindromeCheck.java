package week01.string.extras;

class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";
        String rev = "";
        //Removing the elements 
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        //checking and printing 
        if (str.equals(rev)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
