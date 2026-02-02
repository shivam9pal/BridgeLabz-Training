package week04.gcrcodebase.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassInfoReflection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter fully qualified class name: ");
        String className = scanner.nextLine();

        try {
            // Load the class dynamically
            Class<?> cls = Class.forName(className);

            System.out.println("\nClass Name: " + cls.getName());

            // Display Constructors
            System.out.println("\n--- Constructors ---");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Display Fields
            System.out.println("\n--- Fields ---");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // Display Methods
            System.out.println("\n--- Methods ---");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found. Please check the class name.");
        }

        scanner.close();
    }
}

