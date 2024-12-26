package LeetCode_Java.Stack.Monotone_Stack.Next_Greater_Element;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Next_Greater_Element {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length -1; i >= 0; i--){
            while (!stack.empty() && stack.peek() <= nums2[i]){
                stack.pop();
            }

            if (stack.empty()){
                map.put(nums2[i], -1);
            }else{
                map.put(nums2[i], stack.peek());
            }

            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
