package LeetCode_Java.Pointer.emove_Duplicates_from_Sorted_Array_II;

import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_Array_II {
    public static int removeDuplicates(int[] nums) {
        // edge case
        if (nums.length <= 2) return nums.length;

        int count = 1, slow = 0, fast = 1;
        for (fast= 0; fast < nums.length; fast++){
            if (fast >= 1 && nums[fast] == nums[fast-1]){
                count += 1;
            }else{
                count = 1;
            }
            if (count <=2){
                nums[slow] = nums[fast];
                slow += 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        return slow ;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));

    }
}
