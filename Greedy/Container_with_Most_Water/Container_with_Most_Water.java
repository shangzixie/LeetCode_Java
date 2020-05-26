package LeetCode_Java.Greedy.Container_with_Most_Water;

import java.util.HashMap;
import java.util.Map;

public class Container_with_Most_Water {
    public int maxArea(int[] heights) {
        // write your code here
        if (heights.length == 0) return 0;

        int left = 0, right = heights.length - 1;
        int ans = Integer.MIN_VALUE;

        while (left <= right ){
            if (heights[left] <= heights[right]){
                ans = Math.max(ans, heights[left] * (right - left));
                left++;
            }
            else{
                ans = Math.max(ans, heights[right] * (right - left));
                right--;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        return ans;


    }
}
