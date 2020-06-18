# 415. Add Strings

[LeetCode 45](https://leetcode.com/problems/add-strings/)


## Methods

### Method 1
it is the same tag to [Multiply String](../Multiply_Strings)

### Key Points
1. the last digit need to consider to carry 
2. if `num1.length` > `num2.length`

### Code
```java

//-------------by myself 
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) return addStrings(num2, num1); 
        
        int carry = 0; 
        int digit = 0; 
        String ans = ""; 
        
        int p1 = num1.length() - 1, p2 = num2.length() - 1; 
        while (p1 >= 0 && p2 >= 0) {
            int curNum = (num1.charAt(p1) -'0') + (num2.charAt(p2) - '0'); 
            System.out.println(curNum);
            digit = (curNum + carry) % 10; 
            carry = (curNum + carry) / 10; 
            ans = "" + digit + ans; 
            
            p1--;
            p2--; 
        }
        
        // if num1.length() > num2.length()
        while (p1 >= 0){
            int curNum = num1.charAt(p1) - '0'; 
            digit = (curNum + carry) % 10; 
            carry = (curNum + carry) / 10; 
            ans = "" + digit + ans; 
            p1--; 
        }
        // if the sum needs carry to more digit
        if (carry != 0) ans = "" + carry + ans; 
        return ans;
    }

//-------------after optimizing 
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
} 
```


## Reference
[LeetCode Solution](https://leetcode.com/problems/add-strings/discuss/90436/Straightforward-Java-8-main-lines-25ms)