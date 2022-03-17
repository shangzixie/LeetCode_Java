# [LeetCode 2044. Count Number of Maximum Bitwise-OR Subsets](https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/)

## Methods

先理解这道题的含义, 给一个数组. 数组里面每一个元素element, 可以选可以不选. 对所有选择的元素进行 `OR`运算, 要求所能得到最大的值是?

### Method 1

* `Time Complexity`: O(2^n^)
* `Space Complexity`: O(1)
* `Intuition`:
* `Key Points`: enumerate all possibilities -> dfs
* `Algorithm`:

暴力通过枚举, 利用排列组合的recursion的方法

### Code1

* `Code Design`:

```python
class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        self.maxOR = 0
        self.count = 0
        self.dfs(nums, 0, 0)

        return self.count

    def dfs(self, nums, startIndex, curOR):
        if curOR > self.maxOR:
            self.maxOR = curOR
            self.count = 1
        elif curOR == self.maxOR:
            self.count += 1

        for i in range(startIndex, len(nums)):
            tempCurOR = curOR
            curOR |= nums[i]
            self.dfs(nums, i + 1, curOR)
            curOR = tempCurOR
```

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
