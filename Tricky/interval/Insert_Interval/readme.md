# [LeetCode 57. Insert Interval](https://leetcode.com/problems/insert-interval/)

## Methods


### Method 1

* `Time Complexity`: O(n)
* `Intuition`: find an appropriate position to insert the `newInterval`, then merge them.
* `Algorithm`:

you need read [basic interval](/Tricky/interval/readme.md) first

If we discuss it in categories, we will become very anxious. There are too many cases. So we just handle overlapping cases:

![150](/Image/150.png)
![151](/Image/151.png)

### Key Points

### Code

```python
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:   
        if len(intervals) == 0:
            return [newInterval]

        ans = []
        i = 0
        while i < len(intervals) and intervals[i][1] < newInterval[0]:
            ans.append(intervals[i])
            i += 1
        start, end = newInterval[0], newInterval[1]
        while i < len(intervals) and end >= intervals[i][0]:
            start = min(start, intervals[i][0])
            end = max(end, intervals[i][1])
            i += 1
        ans.append([start, end])
        while i < len(intervals):
            ans.append(intervals[i])
            i += 1
        return ans
```

```python
class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        if len(intervals) == 0:
            return [newInterval]
        ans = []
        hasAppend = False
        for curInterval in intervals:
            if curInterval[1] < newInterval[0]:
                ans.append(curInterval)
            elif curInterval[0] > newInterval[1]:
                if hasAppend is False:
                    ans.append(newInterval)
                    hasAppend = True
                ans.append(curInterval)
            else:
                newInterval[0] = min(newInterval[0], curInterval[0])
                newInterval[1] = max(newInterval[1], curInterval[1])
        if hasAppend:
            return ans
        ans.append(newInterval)
        return ans
```

## Reference

[LeetCode Solution](https://leetcode.cn/problems/insert-interval/solutions/472151/cha-ru-qu-jian-by-leetcode-solution/)
