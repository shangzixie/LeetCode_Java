package LeetCode_Java.Greedy.Best_Time_to_Buy_and_Sell_Stock;

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int cur = prices[prices.length - 1];
        int highest = Integer.MIN_VALUE;
        int maxResult = 0;

        for (int i = prices.length-1; i >= 0; i--){
            if (prices[i] > highest) highest = prices[i];
            maxResult = Math.max(highest - prices[i], maxResult);
        }
        return maxResult;
    }
}
