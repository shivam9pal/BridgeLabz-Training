package week04.gcrcodebase.annotation.intermediate4;

import java.lang.reflect.Field;

class User {

    @MaxLength(20)
    private String username;

    @MaxLength(50)
    private String email;

    public User(String username, String email) {
        validateFields();
        if (username.length() > 20) {
            throw new IllegalArgumentException("Username exceeds max length of 20");
        }
        if (email.length() > 50) {
            throw new IllegalArgumentException("Email exceeds max length of 50");
        }
        this.username = username;
        this.email = email;
    }

    private void validateFields() {
        for (Field field : User.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength ml = field.getAnnotation(MaxLength.class);
                System.out.println("Field: " + field.getName() + " | Max Length: " + ml.value());
            }
        }
    }
}

public class Intermediate4_MaxLength {

    public static void main(String[] args) {
        try {
            User user1 = new User("john_doe", "john@example.com");
            System.out.println("User created successfully");

            User user2 = new User("this_username_is_way_too_long", "test@example.com");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
