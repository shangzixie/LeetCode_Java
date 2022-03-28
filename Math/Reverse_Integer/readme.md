# [LeetCode 7. Reverse Integer](https://leetcode-cn.com/problems/reverse-integer/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

reverse string

### Code1

* `Code Design`:

```python
class Solution:
    def reverse(self, x: int) -> int:
        isNegtive = False
        if x < 0: isNegtive = True
        if isNegtive:
            x = -x

        strNum = str(x)
        reverse = strNum[::-1]
        num = int(reverse)
        if isNegtive is True and num > 2**31:
            return 0
        if isNegtive is not True and num > 2** 31 - 1:
            return 0
        if isNegtive:
            return -num
        return num
```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code2

* `Code Design`:

```java


```

## Reference2
