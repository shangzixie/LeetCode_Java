package LeetCode_Java.Binary_Search.Search_in_Rotated_Sorted_Array;


/*
大 --- 大大  小小 --- 小

firstly, through nums[mid] and nums[start] determine which part mid is.
Secondly, judge target is at which side
 */

public class Search_in_Rotated_Sorted_Array {


    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int start = 0 , end = nums.length -1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;

            // mid in left part
            if (nums[start] <= nums[mid]){
                if (nums[start] <= target && target <= nums[mid]) end = mid; // target is at left of mid
                else start = mid;
                // mid in left part
            }else{
                if (nums[mid] <= target && target <= nums[end]) start = mid; // target is at right of mid
                else end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}
