# 394. Decode String

[LeetCode 394](https://leetcode.com/problems/decode-string/submissions/)


## Methods

### Method 1
At first, from the case `3[a2[c]]`, we notice that need to calculate it from `c` to `a`, that is to say `3[a[cc]] -> 3[acc]`.
so we could use stack.

notice that there are some special case: 
1. `3[a12[c]]`(number is bigger than 10) :
    in this case, we need a string named `curNum`, we continue add the `curNum` until `[`
2. `2[abc]3[cd]ef`(the end of the input has letters), use a string `ans`. When face `[`, append `ans` and `curNum` . when face `]`, `ans = stack's string + ans`

### Key Points
in stack, append numbers and letters alternately. we append a number then we must append a letter.

### Code
```java
class Solution {
    public String decodeString(String s) {
        if (s.length() == 0) return "";

        LinkedList<String> stack = new LinkedList<>();
        String ans = "", preString = "", curNum = "";

        for (int i = 0;i< s.length();i++ ){
            char cur = s.charAt(i);
            //current is number
            if (Character.isDigit(cur)) curNum += cur;
            //current is letter
            else if (Character.isLetter(cur)) ans += cur;

            else if (cur == '['){
                //every time we need to append string then num so as to pop num first
                stack.add(ans);  // stack format:[string, num, string, num....]
                stack.add(curNum);
                ans = "";
                curNum = "";
                
            }else{ // if cur == ']'
                int num = Integer.valueOf(stack.removeLast()); //num will be pop at first
                preString = stack.removeLast();   // then  string will be pop 
                // ans = preString + ans * num
                ans = preString + ans.repeat(num);
            }
        }
        return ans;
    }
}

```


## Reference