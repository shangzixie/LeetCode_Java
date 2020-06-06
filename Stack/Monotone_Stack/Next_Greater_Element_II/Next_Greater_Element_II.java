package LeetCode_Java.Stack.Monotone_Stack.Next_Greater_Element_II;

import java.util.Stack;

public class Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;

        for (int i = nums.length * 2 - 1; i >= 0; i--){
            while (!stack.empty() && stack.peek() <= nums[i %n]){
                stack.pop();
            }

            res[i % n] = stack.empty()?-1:stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}
