package LeetCode_Java.Stack.Valid_Parentheses;

import java.util.Stack;

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
                continue;
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
