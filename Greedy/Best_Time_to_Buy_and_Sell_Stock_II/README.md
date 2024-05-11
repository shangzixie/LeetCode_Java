# [LeetCode 122. Best Time to Buy and Sell Stock II](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

![1](https://i.imgur.com/bpyxnrY.png)

everytime, we buy it on bottom and sell it on top.
we will get the answer.

so how to realize the code?
we can calculate every day how many it will increase then to sum all the price of increasing difference

### Code1

* `Code Design`:

```python
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        ans = 0
        for i in range(1, len(prices)):
            if prices[i] - prices[i - 1] > 0:
                ans += prices[i] - prices[i - 1]
        return ans
```

## Reference1
