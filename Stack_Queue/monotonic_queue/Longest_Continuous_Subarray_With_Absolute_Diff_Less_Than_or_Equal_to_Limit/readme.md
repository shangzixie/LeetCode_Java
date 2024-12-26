# [LeetCode 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit](https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

please read [double ended queue for sliding window](Stack_Queue\monotonic_queue\readme.md) first.

所以对于一个滑动窗口，我们可以维护两个单调队列，一个单调递增，一个单调递减，这样我们就可以在O(1)时间内得到当前窗口的最大值和最小值。

### Code1

* `Code Design`:

```python
class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        n = len(nums)
        max_to_min, min_to_max = deque(), deque()
        left = right = result = 0

        while right < n:
            while max_to_min and max_to_min[-1] < nums[right]:
                max_to_min.pop()
            while min_to_max and min_to_max[-1] > nums[right]:
                min_to_max.pop()
            max_to_min.append(nums[right])
            min_to_max.append(nums[right])

            while max_to_min and min_to_max and max_to_min[0] - min_to_max[0] > limit:
                if nums[left] == min_to_max[0]:
                    min_to_max.popleft()
                if nums[left] == max_to_min[0]:
                    max_to_min.popleft()
                left += 1
            result = max(result, right - left + 1)
            right += 1
        return result
```

## Reference1

youtube视频没啥用
[youtube](https://www.youtube.com/watch?v=p8-f0_CwWLk)
