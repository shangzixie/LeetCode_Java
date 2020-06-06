package LeetCode_Java.LinkedList.Reverse_Linked_List_II;

import LeetCode_Java.buildinClass.ListNode;

public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        //confirm position of pre
        for(int i = 0;i < m-1; i++) pre = pre.next;

        //confirm cur and tail
        ListNode tail = pre.next;
        ListNode cur = tail.next;

        //reverse
        for(int i =0; i < n - m; i++){ //operate n - m times
            //swap
            tail.next = cur.next; //cut
            cur.next = pre.next; // connect it; it is not `then.next = cur.next`
            pre.next = cur;      // connect its pre

            //re-locate then; we don't need to move cur, because after swap, cur has been moved
            cur = tail.next;
        }

        return dummy.next;
    }

}
