package LeetCode_Java.Greedy.Trapping_Rain_Water;

public class Trapping_Rain_Water {
    public int trapRainWater(int[] heights) {
        // write your code here
        int left = 0, right = heights.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;

        while (left <= right){
            if (leftMax < rightMax){
                leftMax = Math.max(leftMax, heights[left]);
                ans += leftMax - heights[left];
                left++;
            }else{
                rightMax = Math.max(rightMax, heights[right]);
                ans += rightMax - heights[right];
                right--;
            }
        }
        return ans;

    }
}
