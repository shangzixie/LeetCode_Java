package LeetCode_Java;

public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] height) {
        if (height.length == 1) return height[0];

        int slow = 0, fast = 1, maxResult = Integer.MIN_VALUE;
        int minHight = height[slow];
        int area = height[slow];

        // move fast
        while (fast < height.length){
            minHight = Math.min(minHight, height[fast]);
            area = (fast - slow + 1) * minHight;
            if (area > maxResult){
                area = maxResult;
                slow ++;
            }
        }

        return 4;
    }
}
