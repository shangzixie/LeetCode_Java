package LeetCode_Java.Pointer.Remove_Nth_Node_From_End_of_List;

import LeetCode_Java.buildinClass.ListNode;

public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy, p2 = dummy;

        for (int i = 0; i < n; i++){
            p2 = p2.next;
        }

        while (p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;

        return dummy.next;
    }
}
