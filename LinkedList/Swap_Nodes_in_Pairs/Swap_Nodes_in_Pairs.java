package LeetCode_Java.LinkedList.Swap_Nodes_in_Pairs;

import LeetCode_Java.buildinClass.ListNode;

public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;

        while (p.next != null && p.next.next != null ){//terminal condition
            swapTwoNode(p, p.next, p.next.next);
            p = p.next.next;
        }
        return dummy.next;

    }

    //use 3 nodes to swap 2 nodes
    private void swapTwoNode(ListNode pre, ListNode p1, ListNode p2){
        p1.next = p2.next;
        p2.next = p1;
        pre.next = p2;
    }
}
