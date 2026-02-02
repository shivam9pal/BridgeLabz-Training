package week04.gcrcodebase.reflection;

import java.lang.reflect.Constructor;

class Student {

    private String name;
    private int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}


public class DynamicObjectCreation {

    public static void main(String[] args) {
        try {
            // Load the Student class at runtime
            Class<?> cls = Class.forName("Student");

            // Get the parameterized constructor
            Constructor<?> constructor =
                    cls.getConstructor(String.class, int.class);

            // Create object without using 'new'
            Object obj = constructor.newInstance("Alice", 101);

            // Call display() method
            cls.getMethod("display").invoke(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

