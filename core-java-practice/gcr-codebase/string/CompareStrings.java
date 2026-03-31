package week01.string.extras;

class CompareStrings {
    public static void main(String[] args) {
        String s1 = "apple";
        String s2 = "banana";
        //Comparing the Strings
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            i++;
        }
        //Displaying the Results
        if (i == s1.length() && i == s2.length())
            System.out.println("Strings are equal");
        else if (i == s1.length())
            System.out.println("apple comes before banana");
        else if (i == s2.length())
            System.out.println("banana comes before apple");
        else if (s1.charAt(i) < s2.charAt(i))
            System.out.println("apple comes before banana");
        else
            System.out.println("banana comes before apple");
    }
}

