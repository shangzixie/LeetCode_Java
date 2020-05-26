package LeetCode_Java.Binary_Search.Search_in_Rotated_Sorted_Array;


/*
大 --- 大大  小小 --- 小

firstly, through nums[mid] and nums[start] determine which part mid is.
Secondly, judge target is at which side
 */

public class Search_in_Rotated_Sorted_Array {


    public static int search(int[] nums, int target) {
        int start = 0 , end = nums.length -1;

        while (start + 1 < end){
            int mid = start + (end - start) / 2;

            // mid in left part
            if (nums[start] <= nums[mid]){
                if (nums[start] <= target && target <= nums[mid]) end = mid; // target is at left of mid
                else start = end;
            }else{ // mid in left part
                if (nums[mid] <= target && target <= nums[end]) start = mid; // target is at right of mid
                else end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {6,8,9,1,3,5};
        int target = 5;
        System.out.println(search(nums, target));

    }
}
