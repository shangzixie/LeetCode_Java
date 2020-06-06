package LeetCode_Java.LinkedList.Reverse_Nodes_in_k_Group;

import LeetCode_Java.buildinClass.ListNode;

public class Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy, pre = dummy, tail = pre.next, cur = tail.next;


        while(true){
            // because it says "If the number of nodes is not a multiple of k
            // then left-out nodes in the end should remain as it is."

            // so move the `last` pointer to confirm if the rest nodes are bigger than k
            int count = k;
            while (last != null && count >=0){
                last = last.next;
                count--;
            }
            if (count >= 0 && last == null) break;

            //reverse nodes between pre and last
            tail = pre.next;
            cur = tail.next;
            while (cur != last){
                tail.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;

                cur = tail.next;
            }
            //update pre and last to the next loop;
            //notice that tail is the last node of the reversed linkedlist part
            pre = tail;
            last = tail;
        }

        return dummy.next;



    }
}
