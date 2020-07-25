import Math.Permutation_Sequence.Permutation_Sequence;

import java.util.*;

public class testCode {
    public void sort(int[] nums) {
        quickSort(0, nums.length - 1, nums);
    }
    public void quickSort(int start, int end, int[] nums) {
        if (start >= end) return;
        int left = start, right = end;
        int p = left + ( right - left) / 2;

        while (left <= right) {
            while (left <= right && nums[left] < nums[p]) left++;
            while (left <= right && nums[right] > nums[p]) right--;

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        //if p > k // k p
        //if p < k //    p k
        quickSort(start, right, nums);
        quickSort(left, end, nums);
    }
    public void quickSortNonRecursion(int[] nums) {
        // nums = [ 5 4 3 2 1]
        // stack
    }
    public void stack(int[] nums){

        Deque<Integer> stack = new ArrayDeque<>();
        int start = 0, end = nums.length - 1;
        stack.addLast(0);
        stack.addLast(nums.length - 1);
        while (start <= end) {
            int right = stack.removeLast();
            int left = stack.removeLast();
            int p = (right + left) / 2;

            while (left <= right && nums[left] < nums[p]) left++;
            while (left <= right && nums[right] > nums[p]) right--;

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            stack.addLast(start);
            stack.addLast(right);
            stack.addLast(left);
            stack.addLast(end);

        }
    }
}
