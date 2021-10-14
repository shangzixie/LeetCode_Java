# LeetCode 347. Top K Frequent Elements

[LeetCode 347  Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)

## Methods

![3](../Image/3.png)

方法二, k为n时候最糟糕,还是nlogn复杂度

### Method 1

* `Time Complexity`: o(n)
* `Intuition`: buckets sort
* `Key Points`: use map to store num and frequency, then build a buckets array, find top k
* `Algorithm`:

### Code

* `Code Design`:

```javascript
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    const buckets = [];
    const num2count = {};

    // maintain map, key is num, value is frequency
    for (let num of nums) {
        if (!num2count[num]) {
            num2count[num] = 1;
            continue;
        }
        num2count[num] += 1;
    }
    // build buckets
    for (let num in num2count) {
        const count = num2count[num];
        if (!buckets[count]) {
            buckets[count] = [];
        }
        buckets[count].push(num);
    }

    let ans = [];
    for (let i = buckets.length - 1; i > 0 && ans.length <　k; i--) {
        if (buckets[i]) {
            ans = ans.concat(buckets[i]);
        }
    }
    return ans;
};

```

## Reference

[buckets sort](https://www.youtube.com/watch?v=lm6pBga98-w)