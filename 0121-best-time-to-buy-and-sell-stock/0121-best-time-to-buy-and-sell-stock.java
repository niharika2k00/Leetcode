class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0], maxProfit = 0;

        // Kadane's Algorithm
        for (int i=0; i<prices.length; i++){
          minBuy = Math.min(minBuy, prices[i]);
          maxProfit = Math.max(maxProfit, prices[i] - minBuy);
        }

        return maxProfit;
    }
}