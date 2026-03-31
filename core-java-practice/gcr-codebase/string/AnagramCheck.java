package week01.string.extras;

class AnagramCheck {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        if (s1.length() != s2.length()) {
            System.out.println("Not Anagrams");
            return;
        }

        int[] freq = new int[256];
        //Storing the frequency
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int i : freq) {
            if (i != 0) {
                System.out.println("Not Anagrams");
                return;
            }
        }
        //Displaying the Result
        System.out.println("Anagrams");
    }
}

