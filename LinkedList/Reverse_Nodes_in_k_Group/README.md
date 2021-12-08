# 25.  Reverse Nodes in k-Group


[LeetCode 25](https://leetcode.com/problems/reverse-nodes-in-k-group/)


## Methods

### Method

just like [Reverse_Linked_List_II](../Reverse_Linked_List_II), we could use `end`, `start`, `pre` to reverse the linkedlists.

```

k = 3
dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
  |      |         |    |
 pre    start     end  next
```

### Key Points

every loop, don't forget to update the `pre` and `last`;

### Code

```java
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode pre = dummy;
    ListNode end = dummy;

    while (end.next != null) {
        for (int i = 0; i < k && end != null; i++) end = end.next;
        if (end == null) break;
        ListNode start = pre.next;
        ListNode next = end.next;
        end.next = null; // 先断开末尾再reverse
        pre.next = reverse(start);
        start.next = next;
        pre = start;

        end = pre;
    }
    return dummy.next;
}

private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
    }
    return pre;
}
```


## Reference

作者：reals
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。