# [LeetCode 647. Palindromic Substrings](https://leetcode-cn.com/problems/palindromic-substrings/)

## Methods

### Method 1

* `Time Complexity`: O(n^2)
* `Space Complexity`:
* `Intuition`: dp
* `Key Points`:
* `Algorithm`:

![28](../../Image/28.png)
![27](../../Image/27.png)

### Code

* `Code Design`:

```javascript
/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function(s) {
    const dp = new Array(s.length).fill(false).map(() => new Array(s.length).fill(false));
    let ans = 0;
    // i ~ j
    for (let j = 0; j < s.length; j++) {
        for (let i = 0; i <= j; i++) {
            if (s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1])) {
                dp[i][j] = true;
                ans++;
            }
        }
    }
    return ans;
};
```

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: 中心扩展法
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```java

class Solution {
    public int countSubstrings(String s) {
        // 中心扩展法
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            // left和right指针和中心点的关系是？
            // 首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            // 大致的关系出来了，可以选择带两个特殊例子进去看看是否满足。
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}

```

## Reference
