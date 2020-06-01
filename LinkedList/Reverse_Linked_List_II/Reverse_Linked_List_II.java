package LeetCode_Java.LinkedList.Reverse_Linked_List_II;

import LeetCode_Java.buildinClass.ListNode;

public class Reverse_Linked_List_II {

    //--------------------------recursion--------------------------
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        for (int i = 1; i <= n+1; i++){
            if (i < m){
                pre = pre.next;
            }
            end = end.next;
        }
        head = pre.next;

        pre.next = helper(pre.next, m, n);//connect pre -> tail and reverse linkedlist from m to n
        head.next = end; // connect head --> end

        return dummy.next;

    }
    private ListNode helper(ListNode node, int m, int n){
        if (m == n) return node;
        ListNode tail = helper(node.next, m + 1, n);
        node.next.next = node;
        node.next = null;

        return tail;
    }
    //--------------------------iterator--------------------------



}
