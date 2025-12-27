package week01.string.extras;

class ReverseString {
    public static void main(String[] args) {
        String str = "BridgeLabz";
        String reversed = "";
        //Storing the reversed string
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        //Displaying the reversed String
        System.out.println("Reversed String: " + reversed);
    }
}

