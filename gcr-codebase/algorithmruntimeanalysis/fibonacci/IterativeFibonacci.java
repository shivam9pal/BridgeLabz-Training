package week3.dsa.algorithmruntimeanalysis.fibonacci;

public class IterativeFibonacci {
    
    // O(N) - significantly faster and memory-efficient
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
