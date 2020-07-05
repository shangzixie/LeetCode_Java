package Stack.Monotonic_Stack.Largest_Rectangle_in_Histogram;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
    public static int largestRectangleArea(int[] heights) {
        int[] leftLess = new int[heights.length];
        int[] rightLess = new int[heights.length];
        leftLess[0] = -1;
        rightLess[heights.length - 1] = heights.length;

        for (int i = 1; i < heights.length; i++) {
            int j = i - 1;
            while (j >= 0 && leftLess[j] >= heights[i]) j = leftLess[j];
            leftLess[i] = j;
        }
        for (int i = heights.length - 2; i >=0; i--) {
            int j = i + 1;
            while (j <= heights.length - 1 && heights[j] >= heights[i]) j = rightLess[j];
            rightLess[i] = j;
        }

        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (rightLess[i] - leftLess[i] - 1) * heights[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
