# 26. Remove Duplicates from Sorted Array

[LeetCode 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

## Methods

### Method 1

use `fast` and `slow` pointers. If we consider how to compare duplicate numbers, we will be nervous. We just focus on the fast pointer with `fast - 1` pointer.
`slow` points to the end of non-duplicate array, `fast` points to next non-duplicate number with `slow`

### Key Points


### Code

```python
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return 1
        slow, fast = 1, 1
        while fast <= len(nums) - 1:
            if nums[fast] == nums[fast - 1]:
                fast += 1
            else:
                nums[slow] = nums[fast]
                fast += 1
                slow += 1
        return slow
```

## Reference