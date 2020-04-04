package LeetCode_Java.Tricky.Set_Mismatch;

public class Set_Mismatch {
    public int[] findErrorNums(int[] nums){
        int[] ans = new int[2];

        for (int i =0;i < nums.length ;i++ ){
            while (nums[i] != i + 1 && nums[nums[i]-1] != nums[i]){
                swap(nums, i, nums[i] -1);
            }
        }
        for (int i =0; i < nums.length; i++){
            if (nums[i] != i + 1){
                ans[0] = nums[i];
                ans[1] = i + 1;
            }
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
