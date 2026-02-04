package week06.gcrcodebase.stream;

import java.util.Arrays;
import java.util.List;

public class WelcomeMessage {

    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
                "John",
                "Emma",
                "David",
                "Sophia"
        );

        System.out.println("=== Welcome Messages ===");

        attendees.stream()
                 .forEach(name -> 
                     System.out.println("Welcome to the event, " + name + "!")
                 );
    }
}

