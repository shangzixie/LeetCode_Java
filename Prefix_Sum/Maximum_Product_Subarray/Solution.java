package Prefix_Sum.Maximum_Product_Subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int prefixProduct = 1;
        int minPositive = 1, maxNegtive = 1;
        int ans = Integer.MIN_VALUE;

        for (int num : nums) {
            prefixProduct *= num;

            if (prefixProduct > 0) {
                ans = Math.max(ans, prefixProduct / minPositive);
                minPositive = Math.min(minPositive, prefixProduct);
            } else if (prefixProduct < 0) {
                ans = Math.max(ans, prefixProduct / maxNegtive);
                maxNegtive = maxNegtive == 1 ? prefixProduct : Math.max(maxNegtive, prefixProduct);
            } else {
                ans = Math.max(ans, 0);
                prefixProduct = 1;
                minPositive = 1;
                maxNegtive = 1;
            }

        }
        return ans;
    }

}
