# 66. Plus One

[LeetCode 66](https://leetcode.com/problems/plus-one/)


## Methods

### Method 1
* `Time Complexity`: O(1) 
* `Intuition`: use `carry` to operate every digit
* `Algorithm`: 
the last digit plus one, then for every early digit, plus them with `carray`
### Code
```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length; 
        
        // the last digit      
        int carry = 0; 
        if (digits[n - 1] == 9) {
            carry = 1; 
            digits[n - 1] = 0; 
        }else digits[n - 1]++; 
        
        // early digit
        for (int i = n - 2; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10; 
            if (digits[i]>= 10) digits[i] = digits[i] % 10; 
        }
        // if carry 1 digit
        if (carry > 0) {
            int[] ans = new int[n+1]; 
            ans[0] = carry; 
            for (int i = 0; i < n; i++) ans[i+1] = digits[i];
            return ans; 
        }
        return digits;
    }
}
```
but we could optimize the code. now we consider all situations: 
* `1.`just when all digits are `9` we need to carry one digit in head  
* `2.` we consider all situations, we set `x != 9 and x < 9`, so in `xxxxy`, `xxxy9999`, `xxxy9`, all `9` become `0`, all `y` plus 1; 


```java 

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length; 
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) digits[i] = 0; // just for the end digits is 9:  xxx9, xxx9999 
            else{
                digits[i] += 1; 
                return digits;
            }
        }        
        // if all is 9 
        int[] ans = new int[n+1]; 
        ans[0] = 1; 
        return ans;

    }
}
 
```  

## Reference