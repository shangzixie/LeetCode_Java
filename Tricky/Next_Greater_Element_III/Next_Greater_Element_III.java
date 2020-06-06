package LeetCode_Java.Tricky.Next_Greater_Element_III;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class Next_Greater_Element_III {
    // n = 2 4 3 2 1
    public int nextGreaterElement(int n) {
        // n = 2 4 3 2 1

        // transfer every digit to array
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0){
            int num = n % 10;
            list.add(num);
            n /= 10;
        }
        // digits = 1 2 3 4 2
        int[] digits = new int[list.size()];

        for (int i = 0; i < digits.length; i++){
            digits[i] = list.get(i);
        }



        int i = 1;
        while (i < digits.length && digits[i] >= digits[i-1]){
            i ++;
        }
        if (i == digits.length) return -1;


        int j = 0;
        while (j < digits.length && digits[j] <= digits[i]){
            j++;
        }

        swap(digits, i, j);// 1 2 2 4 3 ...
        Arrays.sort(digits, 0, i);
        reverse(digits, 0, i-1);


        long result = 0;
        for (int y = digits.length-1; y >=0; y--){
            result *= 10;
            result += digits[y];
        }

        return result>Integer.MAX_VALUE? -1 : (int)result;

    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int start, int end){
        while (start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

}
