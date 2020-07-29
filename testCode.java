import Math.Permutation_Sequence.Permutation_Sequence;

import java.util.*;

public class testCode {
    public static int findKthLargest(int[] nums, int k) {
        return dfs(nums, k, 0, nums.length - 1);
    }

    private static int dfs(int[] nums, int k, int start, int end) {
        if (start >= end) return nums[k];

        int left = start, right = end;
        int pivot = nums[(left + right) / 2];

        while (left <= right) {
            while (left <= right && nums[left] > pivot) left++;
            while (left <= right && nums[right] < pivot) right--;
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(nums));
        if (k <= right) return dfs(nums, k, start, right);
        return dfs(nums, k, left, end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        findKthLargest(nums, 2);
    }


}
