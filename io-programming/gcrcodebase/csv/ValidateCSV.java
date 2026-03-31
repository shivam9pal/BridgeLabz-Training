package week05.gcrcodebase.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {

    // Regex for email validation
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    // Regex for 10-digit phone number
    private static final String PHONE_REGEX = "^\\d{10}$";

    public static void main(String[] args) {

        String filePath = "contacts.csv";
        String line;

        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Pattern phonePattern = Pattern.compile(PHONE_REGEX);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String email = data[2];
                String phone = data[3];

                boolean isValid = true;

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid Email in row ID " + id + ": " + email);
                    isValid = false;
                }

                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Invalid Phone in row ID " + id + ": " + phone);
                    isValid = false;
                }

                if (!isValid) {
                    System.out.println("❌ Invalid Record: " + line);
                    System.out.println("-----------------------------");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

