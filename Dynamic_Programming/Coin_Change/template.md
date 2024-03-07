# [LeetCode 322. Coin Change](https://leetcode.cn/problems/coin-change/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: dp
* `Key Points`:
* `Algorithm`:

![131](/Image/131.png)
![132](/Image/132.jpeg)
![133](/Image/133.png)
![134](/Image/134.png)
![135](/Image/135.png)

### Code1

* `Code Design`:

```python
class Solution(object):
    def coinChange(self, coins, amount):
        dp = [float('inf') for _ in range(amount + 1)]
        dp[0] = 0
        for i in range(amount + 1):
            for value in coins:
                if (value > amount + 1):
                    continue
                dp[i] = min(dp[i], dp[i - value] + 1)
        return dp[amount] if dp[amount] != float('inf') else - 1
```
