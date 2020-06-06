package LeetCode_Java.Prefix_Sum.Binary_Subarrays_With_Sum;

import java.util.HashMap;

public class Binary_Subarrays_With_Sum {

    public int numSubarraysWithSum(int[] A, int S) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0, count = 0;

        for (int num : A){
            preSum += num;
            count += map.getOrDefault(preSum - S, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;


    }
}
