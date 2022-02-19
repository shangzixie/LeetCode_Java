# [LeetCode 50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)

## Methods

### Method 1

* `Time Complexity`: O(logn), 是个一叉树, 深度为logn.
* `Space Complexity`: O(logn)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

一开始考虑为下方代码, 但是, 没考虑n为奇数或为偶数或为负数, 然后23行需要两次重复的递归, 可以优化

```python
    def dfs(self, x, n):
        if n == 0: return 1:

        return  self.dfs(x, n // 2) *  self.dfs(x, n // 2)
```

所以最终结果:

```python
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            return self.dfs(1/x, -n)
        return self.dfs(x, n)


    def dfs(self, x, n):
        if n == 0: return 1

        half_value = self.dfs(x, n // 2)
        if n % 2 == 0:
            return half_value * half_value
        else:
            return x * half_value * half_value
```
