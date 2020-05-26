package LeetCode_Java.Binary_Search.Find_Minimum_in_Rotated_Sorted_Array;

/*
https://www.youtube.com/watch?v=MzoL02wd5ag

 separate the nums to 2 parts;
  小————大 小小小————小小

 */


public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        // means it doesn't rotated
        if (nums[0] < nums[nums.length-1]) return nums[0];

        // if it rotated
        int start = 0, end = nums.length-1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            //if mid is minimum
            // 45671234
            //     |
            if (mid > 0 && nums[mid] < nums[mid-1]) return nums[mid];

            // binary search

            // min is at right part
            if (nums[mid] > nums[start])  start = mid;
            else end = mid;
        }

        return nums[start] < nums[end]? nums[start] : nums[end];
    }
}
