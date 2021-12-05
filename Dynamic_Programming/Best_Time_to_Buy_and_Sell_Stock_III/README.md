# [LeetCode 123. Best Time to Buy and Sell Stock III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

every day, stockholder will have 4 status:

    1. has hold the 1st stock - hold1
    2. has sold the 1st stock - sold1
    3. has hold the 2nd stock - hold2
    4. has sold the 2nd stock - sold2

so we have four arrays, which means:
    1. hold1[k] - if I hold this stock the first time, the profit is hold1[k]
    2. sold1[k] - if I sold the stock the first time, the profit is sold1[k]
    3. hold2[k] - if I hold this stock the second time, the profit is hold2[k]
    4. sold2[k] - if I sold the stock the second time, the profit is sold2[k]

so when the kth day, the stockholder has 4 status:

1. if the person maybe has bought the 1st stock:
the profit of hold1 = max(the current day he bought the stock, bought it before) --->  hold1[k] = max(0-prices[k], hold1[k-1])

2. he maybe has sold the 1st stock:
the profit of sold1 = max(the current day he sold the stock, sold it before) ---> sold1[k] = max( hold1[k-1]+ prices[k], sold1[k-1])

3. he maybe has bought the 2nd stock:
the profit of hold2 = max(the current day he bought the stock, bought it before) ---> hold2[k] = max(sold1[k-1] - prices[k], hold2[k-1])

4. he maybe has sold the 2nd stock:
the profit of sold2 = max(the current day he sold the stock, sold it before) ---> sold2[k] = max(hold2[k-1] + prices[k], sold2[k-1])

so the coding could be

![dP8v1v8](https://i.imgur.com/dP8v1v8.png)


then we need to consider the initial condition:

`hold1[0] = 0, sold1[0] = 0, hold2[0] = 0, sold2[0] = 0`  ???

No, because the 0th day, if the persong don't has a stock, it only has a status: `hold1[0] = 0 - prices[0] : bought the stock`
the same to hold2;

so
`hold1[0] = -prices[0] , sold1[0] = 0, hold2[0] = MIN_VALUE, sold2[0] = 0`

### Code1

* `Code Design`:

```Java
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

```

## Reference1
