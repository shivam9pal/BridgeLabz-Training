package week3.dsa.algorithmruntimeanalysis.stringconcatenation;

public class StringConcatenation {
    
    // O(N²) - immutable, creates new object each time
    public static String usingString(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "a";
        }
        return result;
    }
}
