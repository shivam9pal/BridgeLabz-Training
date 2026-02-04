package week06.gcrcodebase.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Invoice {
    private String transactionId;

    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice created for Transaction ID: " + transactionId;
    }
}

class Invoices {

    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
                "TXN1001",
                "TXN1002",
                "TXN1003"
        );

        System.out.println("=== Creating Invoices ===");

        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)   // Constructor Reference
                .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}

