package week01.string.extras;

class SubstringCount {
    public static void main(String[] args) {
        String str = "abababab";
        String sub = "ab";
        int count = 0;
        //Checking the Substring and increasing the count 
        for (int i = 0; i <= str.length() - sub.length(); i++) {
            if (str.substring(i, i + sub.length()).equals(sub)) {
                count++;
            }
        }
        //Displaying the Result 
        System.out.println("Occurrences: " + count);
    }
}

