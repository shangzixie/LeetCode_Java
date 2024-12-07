# 29. Divide Two Integers

[LeetCode 29](https://leetcode.com/problems/divide-two-integers/)

## Methods

### Method 1

if for iterator, every time `dividend -= divisor` until negtive, the time complexity is high;

so everytime, we could `dividend -= 2 * divisor ` let divisor time 2 to reduce the time complexity.

### Key Points

time complexity is O(logn ^ 2);

### Code

```python
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend == -2147483648 and divisor == -1:
            return 2147483647
        ans = 0
        a = abs(dividend)
        b = abs(divisor)

        while a - b >= 0:
            power = 1
            while a - (b << power) > 0:
                power += 1
            power -= 1
            a -= (b << power)
            ans += 1 << power
        if divisor * dividend > 0:
            return ans
        else:
            return -ans
```

----------------------

### Method 2

in this question, it all base 32-bit. so all type is int;
could try decrease x from max

### Key Points

time complexity O(32)

```java
class Solution {
    public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;

        int a = Math.abs(A), b = Math.abs(B), res = 0;
        for (int x = 31; x >= 0; x--)
            if ((a >>> x) - b >= 0) { // a >>> x is a / 2^x
                res += 1 << x;
                a -= b << x;
            }
        return (A > 0) == (B > 0) ? res : -res;
    }
}
```

## Reference

https://www.youtube.com/watch?v=htX69j1jf5U