package LeetCode_Java.Stack.Stack.Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
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
