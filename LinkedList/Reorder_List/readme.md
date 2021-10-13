# 143. Reorder List

[LeetCode 143](https://leetcode.com/problems/reorder-list/)

## Methods

### Method 1

* `Time Complexity`:
* `Intuition`: `cut from half node` + `reverse() the 2nd part of the linkedlist` + `merge`
* `Algorithm`:

### Key Points

把linkelist 从中间断开 -> 然后翻转后半段 -> 再merge两个linkedlist

### Code

```java
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //initial linkedlist
        ListNode dummy = new ListNode();
        dummy.next = head;

        // find the mid node
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //cut
        ListNode secondHead = slow.next;
        slow.next = null;

        // reverse the 2nd part
        ListNode a = null;
        ListNode b = secondHead;
        ListNode c = b == null ? null : b.next;

            // a->b->c
        while (c != null) {
            b.next = a;

            a = b;
            b = c;
            c = c.next;
        }
        b.next = a; // don't forget the last node;

        // merge
        // 1->2->3
        // 5->4
        ListNode dummy3 = new ListNode();
        ListNode tail = dummy3;
        while (head != null && b != null) {
            tail.next = head;
            tail = tail.next;
            head = head.next;

            tail.next = b;
            b = b.next;
            tail = tail.next;
        }
        if (head != null) tail.next = head;
        if (b != null) tail.next = b;

        head = dummy3.next;
    }
}

```

## Reference