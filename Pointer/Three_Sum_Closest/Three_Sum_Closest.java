package LeetCode_Java.Pointer.Three_Sum_Closest;

import java.util.Arrays;

//-----------------------------------------method 1  (too complex)------------------------------------
public class Three_Sum_Closest {
    int ans = Integer.MAX_VALUE;
    int diff = Integer.MAX_VALUE;
    public int threeSumClosest(int[] numbers, int target) {
        Arrays.sort(numbers);
        for (int i =0; i < numbers.length; i++){
            twoSum(i + 1, numbers.length - 1, numbers[i], target, numbers);
            if (diff == 0) return ans;
        }
        return ans;
    }

    private void twoSum(int left, int right, int c, int target, int[] nums){
        while (left < right){
            if (nums[left] + nums[right] < target - c){
                if (diff > Math.abs(nums[left] + nums[right] + c - target)){
                    diff = Math.abs(nums[left] + nums[right] + c - target);
                    ans = nums[left] + nums[right] + c;
                }
                left++;
            }else if (nums[left] + nums[right] > target - c){
                if (diff > Math.abs(nums[left] + nums[right] + c - target)){
                    diff = Math.abs(nums[left] + nums[right] + c - target);
                    ans = nums[left] + nums[right] + c;
                }
                right--;
            }else{
                diff = 0;
                ans = nums[left] + nums[right] + c;
                break;
            }
        }
    }

//-----------------------------------------method 2------------------------------------
    private int threeSumClosest1(int[] numbers, int target) {
        Arrays.sort(numbers);
        int bestSum = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++){
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right){
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (Math.abs(target - sum) < Math.abs(target - bestSum)){
                    bestSum = sum;
                }

                if (sum < target){
                    left++;
                }else if (sum > target){
                    right--;
                }else{
                    return bestSum;
                }
            }

        }
        return bestSum;
    }



}