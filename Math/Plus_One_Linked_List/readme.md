# [LeetCode 369. Plus One Linked List](https://www.lintcode.com/problem/plus-one-linked-list/description)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`: two pointers `slow` and `fast`. `slow` is the last number that is not `9`, `fast` points to the last digit.
* `Algorithm`:

two pointers `slow` and `fast`. `slow` is the last number that is not `9`, `fast` points to the last digit. Then if `fast` is 9, let `slow` plus one , every digits bigger than `slow` become `0`

### Code1

* `Code Design`:

```java
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0); // if num = 999, need dummy.val + 1
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;
        // slow is the last number that is not 9, fast is the last digit
        while (fast.next != null) {
            if (fast.val != 9) slow = fast;
            fast = fast.next;
        }

        // if the last digit is not 9, plus 1 and return ans directly
        if (fast.val != 9) {
            fast.val++;
            return head;
        }

        // if the last digit is 9
        slow.val++;
        slow = slow.next;
        while (slow != null) {
            slow.val = 0;
            slow = slow.next;
        }
        if (head.val == 0) return dummy;
        return head;
    }
}
```

the code could be optimized. let `slow` be the last number not `9`.  then `slow` plus 1, all digits after `slow` become 0.

```java
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        for (ListNode fast = dummy; fast != null; fast = fast.next) {
            if (fast.val != 9) slow = fast;
        }

        slow.val++;
        slow = slow.next;
        while (slow != null) {
            slow.val = 0;
            slow = slow.next;
        }

        if (head.val == 0) return dummy;
        return head;

    }
}

```

## Reference1