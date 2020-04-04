package LeetCode_Java.HashMap.Longest_Consecutive_Sequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> numToCount = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);


        for (int i = 0; i< nums.length; i++){
            //build the map
            set.remove(nums[i]);
            int nextNum = nums[i] + 1;
            int count = numToCount.containsKey(nextNum) ? numToCount.get(nextNum) : 1;
            while (set.contains(nextNum)){
                count += 1;
                set.remove(nextNum);
                nextNum += 1;
            }
            if (numToCount.containsKey(nextNum)){
                numToCount.put(nums[i], count + numToCount.get(nextNum));
            }else{
                numToCount.put(nums[i], count);
            }

        }

        int ans = Integer.MIN_VALUE;
        for (int num : numToCount.keySet()){
            ans = Math.max(ans, numToCount.get(num));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,4,1,5,9,2,6,5};
        longestConsecutive(nums);
    }
}
