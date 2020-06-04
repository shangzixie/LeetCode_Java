package LeetCode_Java.Binary_Search.Search_in_Rotated_Sorted_Array_II;

public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;

        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return true;  // could remove

            //mid is at left part
            if (nums[start] < nums[mid]){
                if (nums[start] <= target && target <= nums[mid]) end = mid;
                else start = mid;
            //mid is at right part
            }else if(nums[start] > nums[mid]){
                if (nums[mid] <= target && target <= nums[end]) start = mid;
                else end = mid;
            }else {
                //If nums[start] == nums[mid], just move start to the next index.
                //So the worst case, that the array's elements are same, is O(n).
                start++;
            }
        }
        if (nums[start] == target || nums[end] == target) return true;
        return false;
    }
}
