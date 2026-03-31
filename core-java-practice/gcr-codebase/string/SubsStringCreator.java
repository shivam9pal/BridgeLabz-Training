package week01.string.level1;
import java.util.Scanner;

public class SubsStringCreator {

    
    public static String createSubstring(int start,int end, String str) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(str.charAt(i));
        }
        // StringBuilder to a final String and return it
        return result.toString();
    }

    
    public static boolean compareSubstringResult(String str1,String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        // Loop through the strings using a common index
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        
        System.out.println("Enter the String ");
        String mainString=sc.next();

       
        System.out.println("Enter the Start index");
        int startIndex=sc.nextInt();

        
        System.out.println("Enter the End index");
        int endIndex=sc.nextInt();

        // Call the custom method to create a substring
        String subByCharAt = createSubstring(startIndex,endIndex,mainString);
        System.out.println("Substring created with charAt(): " + subByCharAt);

        // Use the built-in Java method
        String subByBuiltIn = mainString.substring(startIndex, endIndex);
        System.out.println("Substring created with built-in substring(): " + subByBuiltIn);

        // Manually compare the two resulting substrings
        boolean areEqualManual = compareSubstringResult(subByCharAt, subByBuiltIn);
        System.out.println("Comparison using manual charAt() method: " + areEqualManual);

        // Compare the two substrings using the built-in equals()
        boolean areEqualBuiltIn = subByCharAt.equals(subByBuiltIn);
        System.out.println("Comparison using built-in equals() method: " + areEqualBuiltIn);

        sc.close();
    }
}
