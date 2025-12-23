package week01.programmingElements;

public class ProfitLoss {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;
        // Calculating the profit 
        int profit = sellingPrice - costPrice;
        double profitPercent = (profit * 100.0) / costPrice;
        // Displaying the Profit
        System.out.println(
            "The Cost Price is  " + costPrice + " and Selling Price is " + sellingPrice + "\nThe Profit is " + profit + " and the Profit Percentage is " + profitPercent
            
        );
    }
}

