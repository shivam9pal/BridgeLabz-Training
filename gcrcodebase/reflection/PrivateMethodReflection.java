package week04.gcrcodebase.reflection;
import java.lang.reflect.Method;

class Calculator {

    private int multiply(int a, int b) {
        return a * b;
    }
}


public class PrivateMethodReflection {

    public static void main(String[] args) {
        try {
            // Create object of Calculator
            Calculator calc = new Calculator();

            // Get Class object
            Class<?> cls = calc.getClass();

            // Get the private method 'multiply'
            Method method = cls.getDeclaredMethod("multiply", int.class, int.class);

            // Allow access to private method
            method.setAccessible(true);

            // Invoke the method
            Object result = method.invoke(calc, 6, 7);

            System.out.println("Result of multiply(6, 7): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

