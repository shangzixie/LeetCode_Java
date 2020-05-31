package LeetCode_Java.LinkedList.Reverse_Linked_List;

import LeetCode_Java.buildinClass.ListNode;

public class Reverse_Linked_List {
    public ListNode reverse(ListNode head) {
        if (head.next == null) return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;
        p1.next = null;

        while (p2 != null){
            p2.next = p1;
            p1 = p2;
            p2 = p2.next;
        }

        return p1;
    }
}
