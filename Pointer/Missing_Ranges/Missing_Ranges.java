package LeetCode_Java.Pointer.Missing_Ranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Missing_Ranges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> result = new ArrayList<>();
        long pointer = lower;
        //利用一个指针跟num比较


        for (int num : nums){
            if (pointer == num){
                pointer++;
            }else{
                if (pointer == num - 1){
                    result.add(pointer + "");
                }else if (pointer < num){ //注意这里
                    result.add(pointer + "->" + (num -1));
                }
                pointer =(long)num + 1;
            }

        }

        if (pointer == upper){
            result.add(pointer+ "");
        }else if (pointer < upper){
            result.add(pointer + "->" + upper);
        }
        return result;
    }




    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648,-2147483648,0,2147483647,2147483647};
        int lower = -2147483648;
        int upper = 2147483647;
        findMissingRanges(nums, lower, upper);
    }
}
