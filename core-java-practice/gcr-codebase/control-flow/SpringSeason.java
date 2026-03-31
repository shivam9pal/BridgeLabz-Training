package week01.flowControl.level1;

public class SpringSeason {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide month and day as command line arguments");
            return;
        }
        
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        
        // Spring Season is from March 20 to June 20
        boolean isSpring = false;
        
        if (month == 3 && day >= 20) {
            isSpring = true;
        } else if (month == 4 || month == 5) {
            isSpring = true;
        } else if (month == 6 && day <= 20) {
            isSpring = true;
        }
        
        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
