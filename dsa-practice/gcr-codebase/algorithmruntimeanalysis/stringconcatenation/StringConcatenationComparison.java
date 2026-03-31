package week3.dsa.algorithmruntimeanalysis.stringconcatenation;

public class StringConcatenationComparison {
    
    public static void main(String[] args) {
        int[] operationCounts = {1000, 10000, 1000000};
        
        System.out.println("String Concatenation Performance Comparison");
        
        for (int count : operationCounts) {
            compareStringConcatenation(count);
        }
    }
    
    private static void compareStringConcatenation(int count) {
        System.out.printf("Operations Count: %,d\n", count);
        
        // String (skip for very large counts)
        if (count <= 10000) {
            long startTime = System.nanoTime();
            StringConcatenation.usingString(count);
            long stringTime = System.nanoTime() - startTime;
            System.out.printf("String: %.2fms\n", stringTime / 1_000_000.0);
        } else {
            System.out.println("String: 30m (Unusable)");
        }
        
        // StringBuilder
        long startTime = System.nanoTime();
        StringBuilderConcatenation.usingStringBuilder(count);
        long stringBuilderTime = System.nanoTime() - startTime;
        System.out.printf("StringBuilder: %.2fms\n", stringBuilderTime / 1_000_000.0);
        
        // StringBuffer
        startTime = System.nanoTime();
        StringBufferConcatenation.usingStringBuffer(count);
        long stringBufferTime = System.nanoTime() - startTime;
        System.out.printf("StringBuffer: %.2fms\n\n", stringBufferTime / 1_000_000.0);
    }
}
