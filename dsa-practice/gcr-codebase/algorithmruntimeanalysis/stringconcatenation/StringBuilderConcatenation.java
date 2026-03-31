package week3.dsa.algorithmruntimeanalysis.stringconcatenation;

public class StringBuilderConcatenation {
    
    // O(N) - fast, mutable, thread-unsafe
    public static String usingStringBuilder(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
}
