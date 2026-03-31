package week04.gcrcodebase.annotation.intermediate3;

import java.lang.reflect.Method;

class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++) {
            int x = i * 2;
        }
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 100000000; i++) {
            double x = Math.sqrt(i);
        }
    }

    @LogExecutionTime
    public long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

public class Intermediate3_LogExecutionTime {

    public static void main(String[] args) throws Exception {
        PerformanceTest pt = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                System.out.println("Executing: " + method.getName());
                long start = System.nanoTime();

                if (method.getName().equals("fibonacci")) {
                    pt.fibonacci(30);
                } else {
                    method.invoke(pt);
                }

                long end = System.nanoTime();
                long duration = end - start;
                System.out.println("Time: " + duration + " ns");
                System.out.println("Time: " + (duration / 1000000.0) + " ms");
                System.out.println();
            }
        }
    }
}
