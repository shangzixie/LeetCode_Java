# [LeetCode 15. 3Sum](https://leetcode-cn.com/problems/3sum/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

该题最主要是解决重复问题。

第一是通过`if (i > 0 && numbers[i] == numbers[i-1]) continue;`去重

第二是通过`if (results.size() != 0 && results.get(results.size()-1).get(1) == nums[start] && results.get(results.size()-1).get(2) == nums[end])`

`javascrit` 的sort是会把元素转成string, 所以要用回调

### Code

* `Code Design`:

```javascript
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
let results;
var threeSum = function(nums) {
    results = [];
    // js sort和 Java的不一样!!!!
    nums.sort((n1, n2) => n1 - n2);
    for (let i = 0; i < nums.length; i++) {
        if (i > 0 && nums[i - 1] === nums[i]) continue;
        twoSum(i + 1, nums.length - 1, -nums[i], nums);
    }
    return results;
};

var twoSum = function(left, right, target, nums) {
    while (left < right) {
        const sum = nums[left] + nums[right]
        if (left < right && target < sum) {
            right--;
            continue;
        }
        if (left < right && target > sum) {
            left++;
            continue;
        }
        if (left < right && target === sum) {
            const len = results.length;
            if (len !== 0 && results[len-1][0] === -target && results[len-1][1] === nums[left]) {
                left++;
                right--;
                continue;
            }
            results.push([-target, nums[left], nums[right]]);
                left++;
                right--;
        }
    }
}
```

## Reference
