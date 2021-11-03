# [LeetCode 136. Single Number](https://leetcode-cn.com/problems/single-number/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`: O(1)
* `Intuition`: XOR
* `Key Points`:
* `Algorithm`:

因为异或满足结合律和交换律; 且相同的数异或后为0, 0和任何数异或都为原数;
所以只要将数组中出现两次的数进行异或, 他们就会消去为0, 最后得到的数就是答案

### Code

* `Code Design`:

```javascript
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let ans = 0;
    for (let num of nums) {
        ans ^= num;
    }
    return ans;
};

```

## Reference

[官方视频](https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/)
