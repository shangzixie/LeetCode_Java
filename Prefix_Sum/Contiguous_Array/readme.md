# [LeetCode 525. Contiguous Array](https://leetcode-cn.com/problems/contiguous-array/)

## Methods

### Method 1

* `Time Complexity`: o(N)
* `Space Complexity`: o(N)
* `Intuition`: prefix sum + map
* `Key Points`: let 0 as -1
* `Algorithm`:

由于「0 和 1 的数量相同」等价于「1 的数量减去 0 的数量等于 0」，我们可以将数组中的 0 视作 −1，则原问题转换成「求最长的连续子数组，其元素和为 0」。

实现方面, 只需要维护一个prefixSum和一个map, map用来存储的key:value为 每个前缀和:第一次出现的下标.
只记录第一次出现下标, 是因为要求最长的subarray, 如果当前的prefixSum的下标为`j`, 上次出现相同prefixSum时候的下标为 `i 或 i + a 或 i + b`, 最长的答案应该为`j - i`

### Code

* `Code Design`:

```java

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {
    const prefixSumToIndex = new Map();
    prefixSumToIndex.set(0, -1);

    let prefixSum = 0;
    let ans = 0;
    for (let i = 0; i < nums.length; i++) {
        // 如果当前nums[i]为0, 则当成 -1处理
        prefixSum += nums[i] === 0 ? -1 : nums[i];
        if (prefixSumToIndex.has(prefixSum)) {
            const leftIndex = prefixSumToIndex.get(prefixSum);
            ans = Math.max(ans, i - leftIndex);
        } else {
            prefixSumToIndex.set(prefixSum, i);
        }
    }
    return ans;
};
```

## Reference

[leetcode ans](https://leetcode-cn.com/problems/contiguous-array/solution/lian-xu-shu-zu-by-leetcode-solution-mvnm/)