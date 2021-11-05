# [LeetCode 209. Minimum Size Subarray Sum](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`: O(1)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```javascript
/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(target, nums) {
    let left = 0, right = 0;
    let sum = 0;
    let ans = Number.MAX_VALUE;
    for (; left < nums.length; left++) {
        // right移动
        while (right < nums.length && sum < target) {
            sum += nums[right];
            right++;
        }
        // 移动left, 满足答案就update ans
        if (sum >= target) ans = Math.min(right - left, ans);
        sum -= nums[left];
    }
    return ans === Number.MAX_VALUE ? 0 : ans;
};

```

## Reference
