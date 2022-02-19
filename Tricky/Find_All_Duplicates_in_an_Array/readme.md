# [LeetCode 442. Find All Duplicates in an Array](https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/)

## Methods

### Method 1

same to [First_Missing_Positive](Tricky/First_Missing_Positive)

* `Time Complexity`: O(n)
* `Space Complexity`: O(1)
* `Intuition`: use `set` to store all duplicate numbers -> all items are in the range [1,n], and use constant extra space -> use origin input array to replace `set`
* `Key Points`: `input array` replace `set`
* `Algorithm`:

### Code1



* `Code Design`:

```python
class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        ans = []
        for i in range(len(nums)):
            cur = nums[i]
            if nums[abs(cur) - 1] < 0:
                ans.append(abs(cur))
                continue
            nums[abs(cur) - 1] *= -1
        return ans
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
