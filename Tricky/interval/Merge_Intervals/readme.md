# [LeetCode 56. Merge Intervals](https://leetcode-cn.com/problems/merge-intervals/)

## Methods

### Method

you need read [basic interval](/Tricky/interval/readme.md) first
we need to check overlapping, use union to insert the overlapping intervals, then insert other non-overlapping intervals.

### Code

```python
class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(intervals) <= 1:
            return intervals
        ans = []
        intervals.sort(key=lambda x : x[0])
        nextInterval = [0,0]
        for i in range(len(intervals) - 1):
            curInterval = intervals[i]
            nextInterval = intervals[i + 1]
            if curInterval[1] < nextInterval[0]:
                ans.append(curInterval)
            else:
                # nextInterval[0] = min(nextInterval[0], curInterval[0]) 没必要这么写, 因为一定nextInterval[0]大
                nextInterval[0] = curInterval[0]
                nextInterval[1] = max(nextInterval[1], curInterval[1])
        ans.append(nextInterval)
        return ans
```

```python
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) <= 1:
            return intervals

        intervals.sort(key = lambda intervals: intervals[0])
        ans = [intervals[0]]
        for i in range(1, len(intervals)):
            cur = intervals[i]
            last = ans[-1]
            if cur[0] > last[1]:
                ans.append(cur)
            else:
                ans[-1][1] = max(cur[1], last[1])
        return ans
```

## Reference