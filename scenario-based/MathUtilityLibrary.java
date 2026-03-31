package week02.scenario;


class MathUtility {

    // factorial method
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // prime check
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // nth Fibonacci number
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci not defined for negative numbers.");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

public class MathUtilityLibrary {

	public static void main(String[] args) {
        System.out.println("Factorial(5): " + MathUtility.factorial(5));
        System.out.println("Factorial(0): " + MathUtility.factorial(0));
        System.out.println("Is 7 prime? " + MathUtility.isPrime(7));
        System.out.println("Is 1 prime? " + MathUtility.isPrime(1));
        System.out.println("GCD(48, 18): " + MathUtility.gcd(48, 18));
        System.out.println("GCD(-12, 8): " + MathUtility.gcd(-12, 8));
        System.out.println("Fibonacci(7): " + MathUtility.fibonacci(7));
        System.out.println("Fibonacci(0): " + MathUtility.fibonacci(0));

	}

}
