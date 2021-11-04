# [LeetCode 167. Two Sum II - Input Array Is Sorted](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)

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
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    let left = 0, right = numbers.length - 1;

    while (left < right) {
        let sum = numbers[left] + numbers[right];
        if (sum < target) {
            left++;
        } else if (sum > target) {
            right--;
        } else {
            return [left + 1, right + 1];
        }
    }
    return [left + 1, right + 1];
};

```

## Reference
