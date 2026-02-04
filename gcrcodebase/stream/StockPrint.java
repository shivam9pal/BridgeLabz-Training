package week06.gcrcodebase.stream;

import java.util.Arrays;
import java.util.List;

class Stock {
    String symbol;
    double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public String toString() {
        return symbol + " -> $" + price;
    }
}

public class StockPrint {

    public static void main(String[] args) {

        List<Stock> liveFeed = Arrays.asList(
                new Stock("AAPL", 189.45),
                new Stock("GOOGL", 2735.20),
                new Stock("TSLA", 720.50),
                new Stock("AMZN", 3342.88)
        );

        System.out.println("=== Live Stock Price Updates ===");

        liveFeed.stream()
                .forEach(System.out::println);  // print each update
    }
}

