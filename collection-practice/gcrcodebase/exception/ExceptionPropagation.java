package week04.gcrcodebase.exception;

public class ExceptionPropagation {

    static void method1() {
        int x = 10 / 0;   // Throws ArithmeticException
    }

    static void method2() {
        method1();       // Calls method1()
    }

    public static void main(String[] args) {

        try {
            method2();   // Calls method2()

        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}

