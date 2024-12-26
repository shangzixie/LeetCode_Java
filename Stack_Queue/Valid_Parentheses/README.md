# 20. Valid Parentheses

[LeetCode 20](https://leetcode.com/problems/valid-parentheses/)


## Methods

### Method 1
I. `()[] valid`

II. `([)] invalid`

III. `([]) valid`

from above, could confirm the conditions:

from I: bracket appear in pairs, so we could use stack 

from II and III: if current bracket is right bracket `]`, the last closest left bracket must be `[` to match it; we could use `stack.peek()`  

### Code
```java
public class Valid_Parentheses {
    public boolean isValidParentheses(String s) {
        /*  ()[] valid
            ([)] invalid
            ([]) valid
           condition 1. ( ) appear in pairs
                     2. when cur  bracket is right bracket, it must match cloest left bracket
        */

        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length() ;i++ ){
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{'){
                stack.add(s.charAt(i));
                continue;//this is important 
            }else if (s.charAt(i) == ']'){
                if (stack.isEmpty() || stack.peek() != '[') return false;
            }else if (s.charAt(i) == ')'){
                if (stack.isEmpty() || stack.peek() != '(') return false;
            }else if (s.charAt(i) == '}'){
                if (stack.isEmpty() || stack.peek() != '{') return false;
            }
            stack.pop();
        }
        return stack.isEmpty()? true:false;

    }
}

```

## Reference