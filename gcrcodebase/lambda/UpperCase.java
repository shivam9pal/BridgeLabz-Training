package week06.gcrcodebase.lambda;

import java.util.Arrays;
import java.util.List;

public class UpperCase {

    public static void main(String[] args) {

        List<String> employeeNames = Arrays.asList(
                "john",
                "emma",
                "david",
                "sophia"
        );

        System.out.println("=== Employee Names in Uppercase ===");

        employeeNames.stream()
                .map(String::toUpperCase)   // Method Reference
                .forEach(System.out::println);
    }
}
