package week06.gcrcodebase.stream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Logging {

    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
                "TXN1001",
                "TXN1002",
                "TXN1003",
                "TXN1004"
        );

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("=== Transaction Logs ===");

        transactionIds.stream()
                .forEach(id -> {
                    String timeStamp = LocalDateTime.now().format(formatter);
                    System.out.println("[" + timeStamp + "] Transaction Logged: " + id);
                });
    }
}

