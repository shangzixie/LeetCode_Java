# [LeetCode 88. Merge Sorted Array](https://leetcode.cn/problems/merge-sorted-array/description/)

## Methods

### Method 1

* `Time Complexity`: O(m + n)
* `Space Complexity`: O(1)
* `Intuition`:
* `Key Points`: three pointers
* `Algorithm`:

![167](/Image/167.png)

```
nums1 = [x,x,x,x,o,o,o]
               |     |
            <- i  <-end
nums2 = [y,y,y]
             |
           <-j
```

### Code1

* `Code Design`:

```python
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        [1,2,2(3),4,5,6,7,0,0,0]
                  i
        [2,5,6]
         j
        """
        i, j, end = m - 1, n - 1, len(nums1) - 1
        while i >= 0 and j >= 0:
            if nums1[i] > nums2[j]:
                nums1[i], nums1[end] = nums1[end], nums1[i]
                i -= 1
            else:
                nums2[j], nums1[end] = nums1[end], nums2[j]
                j -= 1
            end -= 1
        while i >= 0:
            nums1[end] = nums1[i]
            i -= 1
            end -= 1
        while j >= 0:
            nums1[end] = nums2[j]
            j -= 1
            end -= 1
        return nums1
```

## Reference1

[LeetCode Solution](https://leetcode.cn/problems/merge-sorted-array/solutions/2385610/dao-xu-shuang-zhi-zhen-wei-shi-yao-dao-x-xxkp/)