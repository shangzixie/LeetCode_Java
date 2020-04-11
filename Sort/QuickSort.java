package LeetCode_Java.Sort;

public class QuickSort {
    public void main1(int[] nums){
        quickSort(nums, 0, nums.length -1); //用递归去排序
    }

    public void quickSort(int[] nums, int start, int end){
        if (start >= end) return;  //递归出口

        int left = start, right = end;

        int pivot = nums[ left + (right - left)/2]; //选择pivot，因为数据大部分有序，所以pivot选择到最好中间位置，这样左右均匀分布

        //将该数组大于pivot的移到其右侧，小于pivot的移到其左侧
        while (left <= right){
            while (left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            if (left <=right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }
        //此时分别处理pivot左边和右边
        quickSort(nums, start, right);
        quickSort(nums, left, end);

    }

}
