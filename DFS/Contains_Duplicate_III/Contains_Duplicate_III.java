package LeetCode_Java.DFS.Contains_Duplicate_III;

import java.util.TreeSet;

public class Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i ++){
            Integer ceil = set.ceiling(nums[i]); // the smallest number larger than nums[i]
            if (ceil != null && Long.valueOf(ceil) - Long.valueOf(nums[i]) <= t) return true;

            Integer floor = set.floor(nums[i]); // the largest number smaller than nums[i]
            if (floor != null && Long.valueOf(nums[i]) - Long.valueOf(floor) <= t ) return true;

            set.add(nums[i]);
            if (i >= k) set.remove(nums[i-k]);
        }
        return false;
    }
}
