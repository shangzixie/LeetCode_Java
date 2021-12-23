# [LeetCode 50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)

## Methods

### Method 1

* `Time Complexity`: O(2^n), 
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

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

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code2

* `Code Design`:

```java


```

## Reference2
