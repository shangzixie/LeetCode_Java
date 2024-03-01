# [LeetCode 755. Pour Water](https://leetcode.cn/problems/pour-water/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china)

## Methods

### Method 1

* `Time Complexity`: O(v * N)
* `Space Complexity`:
* `Intuition`: simulate the process of pouring water
* `Key Points`: for every water, find the left position, then find the right position. if all not required, then pour water at k
* `Algorithm`:

### Code1

* `Code Design`:

```python
class Solution(object):
    def pourWater(self, heights, volume, k):
        """
        :type heights: List[int]
        :type volume: int
        :type k: int
        :rtype: List[int]
        """

        while volume != 0:
            left = k
            for i in range(left, -1, -1):
                if heights[i] < heights[left]:
                    left = i
                elif heights[i] > heights[left]:
                    break
                else: # heights[i] == heights[left]
                    continue
            if left != k:
                heights[left] += 1
                volume -= 1
                continue
            right = k
            for i in range(k, len(heights)):
                if heights[right] > heights[i]:
                    right = i
                elif heights[right] < heights[i]:
                    break
                else: # heights[right] == heights[i]:
                    continue
            heights[right] += 1
            volume -= 1
        return heights
```

## Reference1

[LeetCode answer](https://leetcode.cn/problems/pour-water/solutions/243890/shi-yong-shuang-zhi-zhen-jie-jue-755-dao-shui-cyu-/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china)
