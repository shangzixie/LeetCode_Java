# 67. Add Binary

[LeetCode 67](https://leetcode.com/problems/add-binary/)


## Methods

### Method 1
* `Time Complexity`: O(n) 
* `Intuition`: carries on a value of 2 instead of a value of 10 
* `Algorithm`: 
Binary addition is much like your normal everyday addition (decimal addition), except that it carries on a value of 2 instead of a value of 10.

### Key Points


### Code
```java
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0; 
        StringBuffer sb = new StringBuffer(); 
        while(i >= 0 || j >= 0){ 
            if (i >= 0) carry += a.charAt(i) - '0';
            if (j >= 0) carry += b.charAt(j) - '0';
            sb.append(carry % 2); 
            carry /= 2;
            i--; 
            j--; 
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

```


## Reference

http://web.math.princeton.edu/math_alive/1/Lab1/BinAdd.html