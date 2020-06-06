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

    //----------------------------method 2----------------
    public ListNode reverse1(ListNode head) {
        if (head.next == null) return head;
        ListNode tail = reverse(head.next); // 姑且相信递归可以把后面的都搞定，并且找到最后那个节点
        head.next.next = head; // 后面翻转后最后的尾巴应该指向当前的头，而尾巴不就正是原来的next嘛。。。
        head.next = null; // 别忘了当前的头现在得指向null
        return tail; // 返回尾巴收工
    }
}
