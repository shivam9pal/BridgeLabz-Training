package week01.string.extras;

class VowelConsonantCount {
    public static void main(String[] args) {
  
        String str = "Hello World".toLowerCase();
        int vowels = 0, consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //Checking the condition
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        //Display the result
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}

