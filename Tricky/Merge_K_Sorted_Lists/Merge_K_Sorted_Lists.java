package LeetCode_Java.Tricky.Merge_K_Sorted_Lists;

import LeetCode_Java.buildinClass.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Lists {
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((h1, h2)-> h1.val - h2.val);
        for (ListNode node : lists){
            if (node == null) continue;
            heap.add(node);
        }

        while (!heap.isEmpty()){
            ListNode top = heap.poll();
            tail.next = top;
            tail = tail.next;
            top = top.next;
            if (top != null){
                heap.add(top);
            }
        }


        return dummy.next;
    }
}
