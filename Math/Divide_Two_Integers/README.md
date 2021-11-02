# 29. Divide Two Integers

[LeetCode 29](https://leetcode.com/problems/divide-two-integers/)

## Methods

### Method 1

if for iterator, every time `dividend -= divisor` until negtive, the time complexity is high;

so everytime, we could `dividend -= 2 * divisor ` let divisor time 2 to reduce the time complexity.

### Key Points

time complexity is O(logn ^ 2);

### Code

```java
class Solution {
    public int divide(int dividend, int divisor) {
        //System.out.println(Integer.MIN_VALUE - 1);
        //System.out.println(Integer.MAX_VALUE);
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        while(a - b >= 0){

            int x = 0; // x is power which means 2^x
            //find the max value of x
            while( a - (b << 1 << x) >= 0){
                x++;
            }
            a -= b << x; // a = a - b * 2^x
            res += 1 << x; // res = res + 1 * 2^x
        }
        return (dividend >= 0) == (divisor >= 0) ? res :-res;
    }
}

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