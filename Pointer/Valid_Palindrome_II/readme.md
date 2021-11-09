# [LeetCode 680. Valid Palindrome II](https://leetcode-cn.com/problems/valid-palindrome-ii/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`: O(1)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

当左右指针遇到了不等元素时，删除 `left` 或者 `right` 指向元素后， 我们只用判断剩下的string是否为回文串

### Code

* `Code Design`:

```javascript
/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function(s) {
    let left = 0, right = s.length - 1;
    while (left < right) {
        while (left < right && s[left] === s[right]) {
            left++;
            right--;
        }
        if (left < right) return isPalindrome(left, right- 1, s) || isPalindrome(left + 1, right, s);
    }
    return true;
};

var isPalindrome = function(left, right, s) {
    while (left < right) {
        if (s[left] === s[right]) {
            left++;
            right--;
        } else {
            return false;
        }
    }
    return true;
}

```

## Reference
