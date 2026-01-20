package week3.dsa.algorithmruntimeanalysis.fibonacci;

public class FibonacciComparison {
    
    public static void main(String[] args) {
        int[] fibonacciNumbers = {10, 30, 50};
        
        System.out.println("Fibonacci Computation Performance Comparison");
        
        for (int n : fibonacciNumbers) {
            compareFibonacci(n);
        }
    }
    
    private static void compareFibonacci(int n) {
        System.out.printf("Fibonacci(%d)\n", n);
        
        // Recursive (skip for large values)
        if (n <= 30) {
            long startTime = System.nanoTime();
            int result = RecursiveFibonacci.fibonacciRecursive(n);
            long recursiveTime = System.nanoTime() - startTime;
            System.out.printf("Recursive O(2^n): %.2fms (Result: %d)\n", 
                recursiveTime / 1_000_000.0, result);
        } else {
            System.out.println("Recursive O(2^n): Unfeasible (>1hr)");
        }
        
        // Iterative
        long startTime = System.nanoTime();
        int result = IterativeFibonacci.fibonacciIterative(n);
        long iterativeTime = System.nanoTime() - startTime;
        System.out.printf("Iterative O(N): %.2fms (Result: %d)\n\n", 
            iterativeTime / 1_000_000.0, result);
    }
}
