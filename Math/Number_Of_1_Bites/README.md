# [LeetCode 191. Number of 1 Bits](https://leetcode-cn.com/problems/number-of-1-bits/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`: 通过奇偶数判断
* `Algorithm`:

### Code1

* `Code Design`:

```python
class Solution:
    def hammingWeight(self, n: int) -> int:
        ans = 0
        while n != 0:
            if n % 2 == 1:
                ans += 1
            n = n >> 1
        return ans
```

## Reference1
