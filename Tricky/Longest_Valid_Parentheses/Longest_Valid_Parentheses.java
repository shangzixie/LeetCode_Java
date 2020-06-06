package LeetCode_Java.Tricky.Longest_Valid_Parentheses;

import java.util.LinkedList;

public class Longest_Valid_Parentheses {
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

        return ans;
    }
}
