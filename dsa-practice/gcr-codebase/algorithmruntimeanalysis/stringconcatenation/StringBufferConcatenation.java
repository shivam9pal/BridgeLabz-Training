package week3.dsa.algorithmruntimeanalysis.stringconcatenation;

public class StringBufferConcatenation {
    
    // O(N) - thread-safe, slightly slower than StringBuilder
    public static String usingStringBuffer(int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
}
