package LeetCode_Java.LinkedList.Reverse_Nodes_in_k_Group;

import LeetCode_Java.buildinClass.ListNode;

public class test {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Reverse_Nodes_in_k_Group so = new Reverse_Nodes_in_k_Group();
        so.reverseKGroup(a, 2);
    }
}
