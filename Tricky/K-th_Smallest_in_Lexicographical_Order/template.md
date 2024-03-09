# [LeetCode 440. K-th Smallest in Lexicographical Order](https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: dictionary tree
* `Key Points`:
* `Algorithm`:

![137](/Image/137.png)
![138](/Image/138.png)
![139](/Image/139.png)
![140](/Image/140.png)

### Code1

* `Code Design`:

![141](/Image/141.png)

define `cur` as current node, `left` and `right` as the most left son node and the most  right son node of `cur`.
k is the kth number in the dictionary tree, we also could define it as still need k steps to find the answer.

```python
class Solution(object):
    def findKthNumber(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        cur = 1
        k -= 1
        while k:
            steps = self.getSteps(cur, n)
            if steps <= k:
                k -= steps
                cur += 1
            else:
                cur *= 10
                k -= 1
        return cur

    def getSteps(self, cur, n):
        steps, left, right = 0, cur, cur
        while left <= n:
            steps += min(right, n) - left + 1
            left *= 10
            last = last * 10 + 9
        return steps
```

## Reference1

[LeetCode Solution](https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/description/)