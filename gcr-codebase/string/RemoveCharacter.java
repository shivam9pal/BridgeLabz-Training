package week01.string.extras;

class RemoveCharacter {
    public static void main(String[] args) {
        String str = "Hello World";
        char remove = 'l';
        String result = "";
        //Removing the character
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != remove) {
                result += str.charAt(i);
            }
        }
        //Displaying Result 
        System.out.println("Modified String: " + result);
    }
}

