package LeetCode_Java;

import java.util.Stack;

public class deBug {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";

        for (String token : tokens){
            if (operators.contains(token)){
                int a = stack.pop();
                int b = stack.pop();
                if (token.equals("+")) stack.push(b + a);
                else if (token.equals("-")) stack.push(b - a);
                else if (token.equals("*")) stack.push(b * a);
                else stack.push(b / a);
                continue;
            }
            stack.push(Integer.valueOf(token));
        }
        return stack.pop();
    }
}
