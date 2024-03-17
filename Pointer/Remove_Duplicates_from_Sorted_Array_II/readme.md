# [LeetCode 80. Remove Duplicates from Sorted Array II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/submissions/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Intuition`: 双指针
* `Key Points`:
* `Algorithm`:

其实相当于有两个数组, `slow`指针指向新开的数组, `fast`指向原来的数组. 照着这种思路, 做出来和`inplace`没区别

用`count`记录重复的数字个数, 与前一位比较.

每次先更新`count`, 再根据`count`来决定是否将当前数字`nums[fast]`给copy到`slow`处.

逻辑上, `fast`表示当前待检查元素 `nums[fast]`, `slow`表示当前待填充元素`nums[slow]`.

这里有个技巧, 当`count >= 2`时, `slow`不能每次更新两位, 只能更新一位. 因为`slow`每次更新一位, `fast`每次更新一位, 所以`slow`永远不会等于`fast`, 否则会出现`slow`更新两次, `fast`走一次, `slow`就等于`fast`的情况.

### Code

* `Code Design`:

```python
错误思路:
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) <= 1:
            return 1

        fast, slow = 1, 1
        count = 1
        while fast < len(nums):
            if nums[fast] == nums[fast - 1]:
                count += 1
            else:
                count = 1
            # 错误点在于每次fast移动一位后, slow要更新两个数, 这个时候可能slow会等于fast
            if count == 2:
                nums[slow] = nums[fast]
                slow += 1
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow
```

```javascript
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (!nums.length) return 0;

    let slow = 0; fast = 0, count = 1;
    for (; fast < nums.length; fast++) {
        // set count
        if (fast > 0 && nums[fast - 1] === nums[fast]) {
            count += 1;
        } else {
            count = 1;
        }
        if (count <= 2) {
            nums[slow] = nums[fast]
            slow += 1;
        }
    }

    return slow;
};

```

## Reference
