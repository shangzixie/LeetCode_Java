# 32. Longest Valid Parentheses

[LeetCode 32](https://leetcode.com/problems/longest-valid-parentheses/)


## Methods

### Wrong method -- Attention, this is a wrong method 
Intuitively, using stack. 

If current is `(`, add it into stack. if current is `)`: 
1. if stack is not null, pop stack and `count++`
2. if `stack` is null, `count == 0`

this method will not pass this case `() ((( ()`. If there are lots of `(` between two valid parentheses.
the code will take `left valid parenthese` and `right valid parenthese` as continuous. output will be `4` but it should be `2`



### Code
```java
public class Solution {
    /**
     * @param s: a string
     * @return: return a integer
     */
    public int longestValidParentheses(String s) {
        LinkedList<Character> stack = new LinkedList<>(); 
        int count = 0; 
        int ans = Integer.MIN_VALUE;
        
        for (int i = 0; i < s.length();i++){
            if (s.charAt(i) == '(' ){
                stack.add('('); 
            }else{
                if (!stack.isEmpty()){
                    count += 2; 
                    stack.removeLast(); 
                }else{
                    count = 0; 
                }
                ans = Math.max(ans, count);        
            }
            
             
        }
        
        return ans == Integer.MIN_VALUE? 0 : ans; 
    }

}

```
### method 1-- time: O(n) space: O(1)
It is the best method, but so hard. 
 
So inorder to deal with `continuous issue` in `wrong method`,  we make use of two counters `left` and `right`. 

1. we start traversing the string from the left towards the right and for every `(` encountered, we increment the `left` counter and for every `)` encountered, we increment the `right` counter. 
2. Whenever `left` becomes equal to `right`, we calculate the length of the current valid string and keep track of maximum length substring found so far. 
3. If `right` becomes greater than `left` we reset `left` and `right` to 0 to deal with `continuous issue`

However, there is an issue:

There are only three cases for a string:

1. '(' are more than ')'
2. '(' are less than ')'
3. '(' and ')' are the same

Now, when you scan from left to right, you can only find the correct maxLength for `2` and `3`, because if it is case `1`, where '(' are more than ')' (e.g., "((()"), then `left` is always greater than `right` and `maxLength` does not have the chance to be updated.

Similarly, when you scan from right to left, you can only find the `maxLength` for cases `1` and `3`.

Therefore, the code needs to traverse the string from left to right and from right to left. A two-pass scan covers all the cases and is guaranteed to find the correct `maxLength`

### code 

```java
public class Solution {
    /**
     * @param s: a string
     * @return: return a integer
     */
    public int longestValidParentheses(String s) {

        int left = 0, right = 0; 
        int ans = 0;
        
        //from left to right 
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') left++;
            else right++; 
            
            if (left == right) ans = Math.max(ans, left * 2); 
            else if (left < right) left = right = 0; // right > left 
        }
        
        //from right to left 
        left = right = 0; 
        for (int i = s.length()- 1; i >= 0; i--){
            if (s.charAt(i) == '(') left++;
            else right++; 
            
            if (left == right) ans = Math.max(ans, left * 2); 
            else if (left > right) left = right = 0;  // left > right 
        }
        
        return ans;
    }

}

```
### method 2
optimize the `wrong method` by using stack. 
there are 4 situations:
    1. current is `(`
        1. stack is not null
        2. stack is null
    2. current is `)`
        1. stack is not null
        2. stack is null

so, we need consider `add` and `pop` from the 4 situations

add: 
 1. current is `(` (no matter stack is null or not) 
 2. current is `)` and stack is null (deal with continuous issue)
 
pop:
 1. current is `)` , stack is not null: pop a `(` from stack to form a valid parentheses
 2. current is `)`, stack is null: need to cut the continuity, so add the `)`

### code 

```python 

class Solution:
   """
   @param s: a string
   @return: return a integer
   """
   def longestValidParentheses(self, s):
      stack = [-1]
      maxlen = 0
      for i in range(len(s)):
         if s[i] == '(':  
            stack.append(i)
         else:
            j = stack.pop()
            if s[j] ==")" or j == -1:
               stack.append(i)
            elif s[j] == "(":
               maxlen = max(maxlen, i - stack[-1])
            
               
               
      
      return maxlen
```



## Reference
https://leetcode.com/problems/longest-valid-parentheses/solution/