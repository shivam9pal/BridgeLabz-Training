package week06.gcrcodebase.stream;

import java.util.Arrays;
import java.util.List;

public class EmailNotification {

    public static void main(String[] args) {

        List<String> emails = Arrays.asList(
                "john@example.com",
                "emma@example.com",
                "david@example.com",
                "sophia@example.com"
        );

        System.out.println("=== Sending Email Notifications ===");

        emails.stream()
              .forEach(email -> sendEmail(email));
    }

    // Simulated email sending method
    public static void sendEmail(String email) {
        System.out.println("Notification email sent to: " + email);
    }
}

