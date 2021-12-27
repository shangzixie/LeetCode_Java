# [LeetCode 702. Search in a Sorted Array of Unknown Size](https://leetcode-cn.com/problems/search-in-a-sorted-array-of-unknown-size/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

无限大, 就让`right`每次扩大2倍

### Code1

* `Code Design`:

```python
class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """

        left, right = 0, 1
        while reader.get(right) < target:
            right = right * 2
        if reader.get(right) == target:
            return right

        while left + 1 < right:
            mid = (left + right) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                left = mid
            else:
                right = mid

        if reader.get(left) == target:
            return left
        elif reader.get(right) == target:
            return right

        return -1
```

## Reference1

