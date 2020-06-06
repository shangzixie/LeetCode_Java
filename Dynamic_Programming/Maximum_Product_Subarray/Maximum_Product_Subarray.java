package LeetCode_Java.Dynamic_Programming.Maximum_Product_Subarray;

import java.util.Arrays;

public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        // method 1
        if (nums.length == 1) return nums[0];

        int[] preProduct = new int[nums.length];
        int negMax = nums[0] < 0? nums[0] : Integer.MIN_VALUE;
        int posMin = nums[0] > 0? nums[0] : Integer.MAX_VALUE;
        preProduct[0] = nums[0];
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < preProduct.length; i++){
            preProduct[i] = preProduct[i-1] * nums[i];

            if (preProduct[i-1] == 0){
                negMax = nums[i] < 0? nums[i] : Integer.MIN_VALUE;
                posMin = nums[i] > 0? nums[i] : Integer.MAX_VALUE;
                preProduct[i] = nums[i];
            }

            if (preProduct[i] > 0) posMin = Math.min(preProduct[i], posMin);
            else if (preProduct[i] < 0) negMax = Math.max(preProduct[i], negMax);


            int a = Math.max(preProduct[i] / negMax, preProduct[i] / posMin);
            int b = Math.max(nums[i], a);
            int c = Math.max(preProduct[i], b);
            ans = Math.max(ans, c);


        }

        return ans;
    }

    public int maxProduct2(int[] nums) {
        // method 2 ===best method
        // write your code here
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];
        int ans = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length; i++){
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
        }

        for(int i = 0; i < nums.length; i++){
            ans = Math.max(max[i], ans);
        }
        return ans;
    }

}
