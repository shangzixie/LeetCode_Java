package LeetCode_Java.Dynamic_Programming.Best_Time_to_Buy_and_Sell_Stock_IV;

public class Best_Time_to_Buy_and_Sell_Stock_IV {

    public int maxProfit(int K, int[] prices) {
        int n = prices.length;

        //if k means infinite number
        if (K / 2 >= n){
            int diff = 0;
            int ans = 0;
            for (int i =1; i < n; i++){
                diff = prices[i] - prices[i-1];
                if (diff> 0){
                    ans += diff;
                }
            }
            return ans;
        }

        int[] hold = new int[K+1];
        int[] sold = new int[K+1];
        hold[0] = 0;
        sold[0] = 0;
        for (int i = 0 ; i < n; i++){
            int[] holdOld = hold;
            int[] soldOld = sold;

            for (int j = 1; j <= K; j++){
                hold[j] = Math.max(holdOld[j], soldOld[j-1] - prices[i]);
                sold[j] = Math.max(soldOld[j], holdOld[j] + prices[i]);
            }
        }

        int result = Integer.MIN_VALUE;
        for(int j = 0; j <= K; j++){
            result = Math.max(result, sold[j]);
        }

        return result;

    }
}
