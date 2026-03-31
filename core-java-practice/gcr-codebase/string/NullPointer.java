package week01.string.level1;

public class NullPointer{
	public static void handleNullPointerException() {
        String text = null;

        System.out.println("Attempting to access a String method within a try-catch block...");
        try {
            int length = text.length();
            System.out.println("String length: " + length); 

        } catch (NullPointerException e) {
            System.out.println("Caught the NullPointerException successfully!");
            System.out.println("Error message: " + e.getMessage());
           
            
        }finally {
            System.out.println("Finally block executed.");
        }
    }

    public static void main(String[] args) {
        try {
            generateNullPointerException();
        } catch (Exception e) {
            System.out.println("Caught the exception in main: " + e.getMessage());
            
        }

        System.out.println("Demonstrating NullPointerException Handling");
        handleNullPointerException();
    }

    public static void generateNullPointerException() {
        // Define the variable 
        String text = null;

        System.out.println("Attempting to call a String method on a null reference...");
        int length = text.length(); 
        // This line throws the NullPointerException.

        System.out.println("String length: " + length);
    }    
}

