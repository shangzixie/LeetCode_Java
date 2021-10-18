# 523. Continuous Subarray Sum

[LeetCode 523](https://leetcode.com/problems/continuous-subarray-sum/)

## Methods

### Method 1

* `Time Complexity`:
* `Intuition`: 如果a % k == b % k, 则 a - b 为 k的倍数.利用这条知识, 如果找到两个prefix sum, 他们 % k的结果相同, 则两个prefix sum之间的数组就是结果
* `Key Points`: k为0怎么办
* `Algorithm`:

I think it's the most tricky part! <0,-1> can allow it to return true when the prefixSum % k == 0,
In addition, it also avoids the first element of the array is the multiple of k, since 0-(-1)=1 is not greater than 1. I think it's really beautiful and elegant here!

### Code

* `Code Design`:

```javascript
var checkSubarraySum = function(nums, k) {
    let prefixSum = 0;
    const prefixArray = new Map();
    prefixArray.set(0 ,-1);

    for (let i = 0; i < nums.length; i++) {
        prefixSum += nums[i];

        let remainder = prefixSum;

        // 如果k == 0, prefixSum等于0就是要满足的答案
        if (k != 0) remainder = prefixSum % k;

        if (prefixArray.has(remainder)) {
            if (i - prefixArray.get(remainder) > 1) {
                return true;
            }
        } else {
            prefixArray.set(remainder, i);
        }
    }

    return false;
};

```

## Reference

[video](https://www.youtube.com/watch?v=lAan667yWQ4)