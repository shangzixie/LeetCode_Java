# 166. Fraction to Recurring Decimal

[LeetCode 166](https://leetcode.com/problems/fraction-to-recurring-decimal/)

## Methods

### Method 1

* `Time Complexity`: o(n). n is the repeating part
* `Intuition`: Notice that once the remainder starts repeating, so does the divided result.
* `Algorithm`:
use string to store the decimal part and use `map` to store `remainder` and its `position`.  if there is a repeat, we could use map to confirm.

### Key Points

1. 考虑正负数
2. 考虑整除情况

### Code

```python
class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        # 整除
        if numerator % denominator == 0:
            return str(numerator // denominator)

        ans = ''
        remainderMap = {}
        # 考虑负数
        if numerator < 0 and denominator > 0:
            ans += '-'
        if numerator > 0 and denominator < 0:
            ans += '-'
        a = abs(numerator)
        b = abs(denominator)
        # 先搞定整数部分
        ans += str(a // b)
        ans += '.'
        a %= b
        while a != 0:
            if a in remainderMap:
                index = remainderMap[a]
                ans = ans[:index] + '(' + ans[index:]
                ans += ')'
                return ans
            remainderMap[a] = len(ans)
            a *= 10
            ans += str(a // b)
            a %= b
        return ans

```

## Reference
