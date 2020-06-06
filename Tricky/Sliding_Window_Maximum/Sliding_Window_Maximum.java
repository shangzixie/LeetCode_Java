package LeetCode_Java.Tricky.Sliding_Window_Maximum;

import java.util.LinkedList;
import java.util.List;

public class Sliding_Window_Maximum {
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new LinkedList<>();

        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        // 结果数组
        LinkedList<Integer> result = new LinkedList<>();
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.removeLast();
            }
            // 添加当前值对应的数组下标
            queue.add(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.removeFirst();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result.add(nums[queue.peek()]);
            }
        }


        return result;
    }
}
