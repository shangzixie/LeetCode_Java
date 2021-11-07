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

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```java
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    const set = new Set();
    let left = 0, right = 0;
    let ans = 0;
    for (;right < s.length; right++) {
        while (set.has(s[right])) {
            set.delete(s[left]);
            left++;
        }
        // 如果当前windwo没有s[right]
        if (!set.has(s[right])) {
            set.add(s[right]);
            ans = Math.max(ans, right - left + 1);
        }
    }
    return ans;
};

```

----------------------

### Method 3

* `Time Complexity`: O(n)
* `Space Complexity`:
* `Intuition`: 滑动窗口 + map
* `Key Points`:
* `Algorithm`:

[PPT动画](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/)

### Code

* `Code Design`:

```java

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}

```

## Reference

[method 3](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/)
