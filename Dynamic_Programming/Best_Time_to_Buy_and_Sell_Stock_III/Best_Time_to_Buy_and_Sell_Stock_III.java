package LeetCode_Java.Dynamic_Programming.Best_Time_to_Buy_and_Sell_Stock_III;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Best_Time_to_Buy_and_Sell_Stock_III {
    //method 1
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int n = prices.length;

        int[] hold1 = new int[n];
        int[] sold1 = new int[n];
        int[] hold2 = new int[n];
        int[] sold2 = new int[n];

        hold1[0] = 0-prices[0];
        hold2[0] = Integer.MIN_VALUE;
        sold1[0] = 0;
        sold2[0] = 0;


        for (int k = 1; k < prices.length; k++){
            hold1[k] =  Math.max(0-prices[k], hold1[k-1]);
            sold1[k] = Math.max( hold1[k-1]+ prices[k], sold1[k-1]);
            hold2[k] = Math.max(sold1[k-1] - prices[k], hold2[k-1]);
            sold2[k] = Math.max(hold2[k-1] + prices[k], sold2[k-1]);
        }
        return Math.max(sold1[n-1], sold2[n-1]);
    }

    //method 2
    public static int maxProfit1(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE, sold1 = 0, sold2 = 0;

        for (int price: prices){
            int hold1_temp = hold1;
            int hold2_temp = hold2;
            int sold1_temp = sold1;
            int sold2_temp = sold2;

            hold1 = Math.max(0 - price, hold1_temp);
            sold1 = Math.max(hold1_temp + price, sold1_temp);
            hold2 = Math.max(sold1_temp - price, hold2_temp);
            sold2 = Math.max(hold2_temp + price, sold2_temp);
        }
        return Math.max(sold1, sold2);
    }


    // test
    public static void main(String[] args) {
        int[] prices = new int[]{1,2};
        maxProfit(prices);
    }
}
