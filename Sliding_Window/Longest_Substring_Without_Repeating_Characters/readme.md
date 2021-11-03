# [LeetCode 3. Longest Substring Without Repeating Characters](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

## Methods

### Method 1

* `Time Complexity`:
* `Intuition`: sliding window
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```javascript
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if (!s) return 0;

    const set = new Set();
    let left = 0, right = 0;
    let ans = 0;

    for (; left < s.length; left++) {
        while (s[right] && !set.has(s[right])) {
            set.add(s[right]);
            right += 1;
            // update ans
            ans = Math.max(set.size, ans);
        }
        set.delete(s[left]);
    }
    return ans;
};

```

## Reference
