package LeetCode_Java.Monotone_Stack;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
    public static int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            while (stack.peek() != -1 && height[stack.peek()] > height[i]) {
                int TraHeight = height[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, TraHeight * width); // max(maxArea, height  * width)
            }
            stack.push(i);
        }
        // when traverse to the end of the array, pop all item from stack
        while (stack.peek() != -1) {
            int stackPop = stack.pop();
            maxArea = Math.max(maxArea, (height.length - stack.peek() - 1) * height[stackPop]);
        }

        return maxArea;
    }




    public static void main(String[] args) {
        int[] height = new int[]{2,1,5,6,2,3};
        largestRectangleArea(height);
    }
}
