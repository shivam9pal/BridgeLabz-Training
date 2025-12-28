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
}
