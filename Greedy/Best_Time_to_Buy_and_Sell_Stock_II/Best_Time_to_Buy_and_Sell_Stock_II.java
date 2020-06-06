package LeetCode_Java.Greedy.Best_Time_to_Buy_and_Sell_Stock_II;

public class Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        int result = 0;

        for (int i = 0; i < prices.length-1; i++){
            int diff = prices[i+ 1] - prices[i];
            if (diff > 0) result += diff;
        }
        return result;
    }

}
