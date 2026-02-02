package week04.gcrcodebase.reflection;

import java.lang.reflect.Field;

class Person {
    private int age = 25;

    public void display() {
        System.out.println("Age: " + age);
    }
}


public class PrivateFieldReflection {

    public static void main(String[] args) {
        try {
            // Create object of Person
            Person person = new Person();

            // Display original value
            person.display();

            // Get the Class object
            Class<?> cls = person.getClass();

            // Get the private field 'age'
            Field field = cls.getDeclaredField("age");

            // Allow access to private field
            field.setAccessible(true);

            // Modify the private field value
            field.set(person, 40);

            // Retrieve the updated value
            int updatedAge = (int) field.get(person);

            System.out.println("Updated Age (via reflection): " + updatedAge);

            // Display again using method
            person.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

