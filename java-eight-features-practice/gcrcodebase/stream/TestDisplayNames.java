package week06.gcrcodebase.stream;



import java.util.Arrays;
import java.util.List;

class TestDisplayNames {

    public static void main(String[] args) {

        List<String> customerNames = Arrays.asList(
                "john",
                "emma",
                "david",
                "sophia",
                "alex"
        );

        System.out.println("=== Customer Names for Display ===");

        customerNames.stream()
                     .map(String::toUpperCase)  // convert to uppercase
                     .sorted()                 // alphabetical order
                     .forEach(System.out::println);
    }
}


