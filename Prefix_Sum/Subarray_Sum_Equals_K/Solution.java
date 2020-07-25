package Prefix_Sum.Subarray_Sum_Equals_K;

import java.util.HashMap;

public class Solution {
    public int subarraySumEqualsK(int[] nums, int k) {
        // write your code here
        int prefixSum = 0;
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0 ,1); // the first num's prefix sum is 0;

        for (int num : nums) {
            prefixSum += num;
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

            if (map.containsKey(prefixSum - k)) ans += map.get(prefixSum - k);
        }


        return ans;
    }
}
