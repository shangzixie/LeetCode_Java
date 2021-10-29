# [LeetCode 80. Remove Duplicates from Sorted Array II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/submissions/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Intuition`: 双指针
* `Key Points`:
* `Algorithm`:

其实相当于有两个数组, `slow`指针指向新开的数组, `fast`指向原来的数组. 照着这种思路, 做出来和`inplace`没区别

用`count`记录重复的数字个数, 与前一位比较.

每次先更新`count`, 再根据`count`来决定是否将当前数字`nums[fast]`给copy到`slow`处

### Code

* `Code Design`:

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
