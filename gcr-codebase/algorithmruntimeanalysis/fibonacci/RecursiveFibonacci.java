package week3.dsa.algorithmruntimeanalysis.fibonacci;

public class RecursiveFibonacci {
    
    // O(2^n) - exponential growth, infeasible for large N
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}
