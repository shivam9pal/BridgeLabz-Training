package week01.string.extras;

class ToggleCase {
    public static void main(String[] args) {
        String str = "JaVa";
        String result = "";
        //
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
            }
        }
        //Displaying the result
        System.out.println("Toggled String: " + result);
    }
}
