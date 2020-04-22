package LeetCode_Java.Math.Rotate_Array;

public class Rotate_Array {
    public static int[] rotate(int[] nums, int k) {


        int i = 0;
        int det = k % nums.length;
        int n = nums.length;
        int num = nums[0];

        while(i != 0){
            int nextIndex = (i + det) % n;
            int nextNum = nums[nextIndex];
            nums[nextIndex] = num;
            i = nextIndex;
            num = nextNum;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int k = 3;
        rotate(nums, k);
    }
}
