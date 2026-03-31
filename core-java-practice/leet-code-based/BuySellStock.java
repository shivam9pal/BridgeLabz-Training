package week01.leetcode;

class BuySellStock {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=Integer.MAX_VALUE;
        int profit=0;

        for(int i=0;i<n;i++){
            if(buy>prices[i]){
                buy=prices[i];
            }else{
                profit=Math.max(profit,prices[i]-buy);
            }
        }
        return profit;
    }
    
    public static void main(String[] args) {
        BuySellStock solution = new BuySellStock();
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit for [7, 1, 5, 3, 6, 4]: " + solution.maxProfit(prices1));
      
    }
}
