package week02.gcrcodebase.leetcode;

public class BestTimeStock {
	public static int maxProfit(int[] prices) {
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
		int[] prices= {7,1,5,3,6,4};
		int timeIndex=maxProfit(prices);
		System.out.println(timeIndex);

	}

}
