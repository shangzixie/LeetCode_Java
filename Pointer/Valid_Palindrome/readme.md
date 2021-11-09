# [LeetCode 125. Valid Palindrome](https://leetcode-cn.com/problems/valid-palindrome/)

## Methods

### Method 1

### Code1

* `Code Design`:

```java
public class Valid_Palindrome {
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right){
            while(left <right && (!Character.isLetter(chars[left]) && !Character.isDigit(chars[left]))){
                left++;
            }
            while(left < right && (!Character.isLetter(chars[right]) && !Character.isDigit(chars[right]))){
                right--;
            }

            if (Character.toLowerCase(chars[left]) == Character.toLowerCase(chars[right])){
                left ++;
                right --;
            }else{
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s= "A man, a plan, a canal: Panama";
        isPalindrome(s);
    }
}

```

```javascript
/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
  s = s.toLowerCase();
  let left = 0, right = s.length - 1;
  while (left < right) {
    while (left < right && !isLetterOrNumber(s[left])) {
      left++;
    }
    while (left < right && !isLetterOrNumber(s[right])) {
      right--;
    }
    if (left < right && s[left] != s[right]) {
      return false;
    }
    left++;
    right--;
  }
  return true;
};

var isLetterOrNumber = function(char) {
  if (char.charCodeAt() >= 'a'.charCodeAt() && char.charCodeAt() <= 'z'.charCodeAt()) return true;
  if (char.charCodeAt() >= '0'.charCodeAt() && char.charCodeAt() <= '9'.charCodeAt()) return true;
  return false;
}
```
