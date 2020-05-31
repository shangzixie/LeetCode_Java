package LeetCode_Java.LinkedList.Reverse_Linked_List;

import LeetCode_Java.buildinClass.ListNode;


public class test {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        Reverse_Linked_List re = new Reverse_Linked_List();
        re.reverse(a);

    }
}
