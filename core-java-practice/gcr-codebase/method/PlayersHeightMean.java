package week01.method;

import java.util.Random;

public class PlayersHeightMean {

    //sum of all heights
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }
    //mean height
    public static double findMean(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }
    //shortest height
    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }
        return shortest;
    }
    //tallest height
    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }

    public static void main(String[] args) {

        int[] heights = new int[11];
        Random random = new Random();

        // Generate random heights 
        for (int i = 0; i < heights.length; i++) {
            heights[i] = random.nextInt(101) + 150; 
        }

       
        System.out.println("Heights of football players (in cm):");
        for (int height : heights) {
            System.out.print(height + " ");
        }

        System.out.println("Height Analysis");

        int sum = findSum(heights);
        double mean = findMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        // Displayig results
        System.out.println("Sum of heights: " + sum + " cm");
        System.out.println("Mean height: " + mean + " cm");
        System.out.println("Shortest height: " + shortest + " cm");
        System.out.println("Tallest height: " + tallest + " cm");
    }
}
