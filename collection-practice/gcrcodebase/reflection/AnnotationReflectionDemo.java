package week04.gcrcodebase.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)   // Available at runtime
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Book {
    public void show() {
        System.out.println("Book class method");
    }
}


public class AnnotationReflectionDemo {

    public static void main(String[] args) {
        try {
            // Load the Book class
            Class<?> cls = Class.forName("Book");

            // Check if annotation is present
            if (cls.isAnnotationPresent(Author.class)) {

                // Get the annotation
                Author author = cls.getAnnotation(Author.class);

                // Display annotation value
                System.out.println("Author Name: " + author.name());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

