# Basic Knowledge Must need to know about LinkedList

## Find the middle of a LikedList

if use dummy:

```java
class solution{
    public void middle(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) { // fast == null for odd, fast.next == null for even
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}

```

if not use dummy

```java
class solution{
    public void middle(ListNode head) {
        ListNode slow = head, fast = head; // if not use dummy, fast = slow = head
        while (fast.next != null && fast.next.next != null) { // fast == null for odd, fast.next == null for even
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}

```

## [Reverse a LinkedList](./Reverse_Linked_List)

```java
class solution{
    public ListNode reverseLinkedList(ListNode head) {

        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode tempNext = cur.next; // the third point is used for moving of the second pointer
            cur.next = prev;
            prev = cur;
            cur = tempNext;
        }
        return prev;
    }
}
```

dfs

```javascript
var reverseList = function(head) {
    if (!head) return null;
    if (!head.next) return head;
    const tail = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return tail;
};
```

## merge two sorted LinkedList

合并两条有序链表 — 递归

```java
private ListNode merge2Lists(ListNode l1, ListNode l2) {
    if (l1 == null) {
        return l2;
    }
    if (l2 == null) {
        return l1;
    }
    if (l1.val < l2.val) {
        l1.next = merge2Lists(l1.next, l2);
        return l1;
    }
    l2.next = merge2Lists(l1, l2.next);
    return l2;
}
```

合并两条有序链表 — 迭代

```java
private ListNode merge2Lists(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            tail.next = l1;
            l1 = l1.next;
        } else {
            tail.next = l2;
            l2 = l2.next;
        }
        tail = tail.next;
    }

    tail.next = l1 == null? l2: l1;

    return dummyHead.next;
}
```