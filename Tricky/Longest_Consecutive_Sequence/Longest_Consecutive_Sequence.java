package LeetCode_Java.Tricky.Longest_Consecutive_Sequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {
    //method 1
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> bdryToLen = new HashMap<>();

        for (int num: nums){
            if (bdryToLen.containsKey(num)) continue;

            int leftNebor = num -1 ;
            int rightNebor = num + 1;
            int leftLen = bdryToLen.getOrDefault(leftNebor, 0);
            int rightLen = bdryToLen.getOrDefault(rightNebor, 0);

            if (leftLen != 0 && rightLen != 0){
                bdryToLen.put(num - leftLen, leftLen + rightLen + 1);
                bdryToLen.put(num + rightLen, leftLen + rightLen + 1);
                bdryToLen.put(num , leftLen + rightLen + 1);
            }else if (leftLen != 0){
                bdryToLen.put(num - leftLen, leftLen + 1);
                bdryToLen.put(num, leftLen + 1);
            }else if (rightLen != 0){
                bdryToLen.put(num + rightLen, rightLen + 1);
                bdryToLen.put(num , rightLen + 1);
            }else{
                bdryToLen.put(num , 1);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int num : bdryToLen.keySet()){
            ans = Math.max(ans, bdryToLen.get(num));
        }
        return ans;
    }
    //method 2
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums){
            set.add(num);
        }

        int longset = 0;
        for (int num : nums){
            int low = num - 1;
            while (set.contains(low)){
                set.remove(low);
                low -= 1;
            }
            int high = num + 1;
            while (set.contains(high)){
                set.remove(high);
                high += 1;
            }
            longset = Math.max(longset, high - low - 1);
        }
        return longset;
    }
}
