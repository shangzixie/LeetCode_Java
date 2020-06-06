package LeetCode_Java.Binary_Search.Median_of_Two_Sorted_Array;

import java.util.HashMap;

public class Median_of_Two_Sorted_Array {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int length = nums1.length + nums2.length;
        int left = 0;
        int right = nums1.length - 1;
        int leftNumInNums1 = 0;  // how many left numbers in numbers1
        int leftNumInNums2 = 0;  // how many left numbers in numbers2

        while (left + 1 < right){
            leftNumInNums1 = left + (right - left) / 2;
            leftNumInNums2 = length - leftNumInNums1;
        }

        return (double)0;
    }
}
