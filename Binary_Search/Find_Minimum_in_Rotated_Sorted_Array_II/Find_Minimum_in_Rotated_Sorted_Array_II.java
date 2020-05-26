package LeetCode_Java.Binary_Search.Find_Minimum_in_Rotated_Sorted_Array_II;
/*
consider this situation:

https://www.youtube.com/watch?v=MzoL02wd5ag

 小————大 小小小————小小

 */



public class Find_Minimum_in_Rotated_Sorted_Array_II {


    public int findMin(int[] nums){
        // edge case [1] or [ 123456] [111111]
        if (nums.length == 1 || nums[0] < nums[nums.length-1]) return nums[0];

        int start = 0 , end = nums.length -1 ;

        while (start + 1 < end){
            int mid = start + (end - start) / 2 ;

            if (nums[mid] < nums[start]) end = mid;
            else if (nums[mid] > nums[start]) start = mid;
            else start += 1;
        }
        return nums[start] < nums[end]? nums[start] : nums[end];
    }
}
