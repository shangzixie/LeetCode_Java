# [LeetCode 795. Number of Subarrays with Bounded Maximum](https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/description/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`: O(1)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

我们可以将数组中的元素分为三类，并分别用 0, 1, 2 来表示：

1. 小于 `left`，用 0 表示；
2. 大于等于 `left` 且小于等于 `right`，用 1 表示；
3. 大于 `right`，用 2 表示。

所以，我们可以先求出只包含 0 或 1 的子区间数目，再减去只包括 0 的子区间数目。

设函数 `count(nums,lower)`, 可以求出数组`nums`中所有元素小于等于 `lower` 的子数组数目，那么题目所求就是 `count(nums,right)−count(nums,left)`

实现`count()`是有技巧的，这里实现count可以归结为一个小的 leetcode 问题。

假定数组`[2,1,3,1,4,1]`, left和right分别是`[2,3]`, 定义`x`为遍历到的当前的数。`cur`为以`x`为右边界的数组中，最大数不超过`lower`的子数组数目，`res`为所有子数组数目。

遍历过程：

`x = 2`, subarray = [2], cur = 1, res = 1
`x = 1`, suaarrray = [2,1], [1], cur = 2, res = 3
`x = 3`, subarray = [2,1,3], [1,3], [3], cur = 3, res = 6
`x = 1`, subarray = [2,1,3,1], [1,3,1], [3,1], [1], cur = 4, res = 10
`x = 4`, we need to cut it, re-calculate `cur`, cur = 0, res = 10
`x = 1`, subarray = [1], cur = 1, res = 11

```python
class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        def count(lower: int) -> int:
            res = cur = 0
            for x in nums:
                if x <= lower:
                    cur += 1
                else:
                    cur = 0
                res += cur
            return res
        return count(right) - count(left - 1)
```

## Reference1

[LeetCode Solution](https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/solutions/1986565/qu-jian-zi-shu-zu-ge-shu-by-leetcode-sol-7it1/)