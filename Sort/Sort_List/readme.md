# [LeetCode 148. Sort List](https://leetcode.cn/problems/sort-list/description/)

## Methods

### Method 1

* `Time Complexity`: ![6](../../Image/6.png)
* `Intuition`:
* `Key Points`: merge sort
* `Algorithm`:

### Code

* `Code Design`:

```javascript
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function(head) {
    if (!head) return null;

    return divided(head);
};

var findMid = function(node) {
    let slow = node;
    let fast = node.next;
    while (fast && fast.next) {
        fast = fast.next.next;
        slow = slow.next;
    }

    return slow;
}

var divided = function(node) {
    if (!node.next) return node;

    // find mid node
    let mid = findMid(node);
    let rightStart = mid.next;

    // split
    mid.next = null;
    // continue divided
    let left = divided(node);
    let right = divided(rightStart);

    return merge(left, right);
}

var merge = function(list1, list2) {
    const dummy = new ListNode();
    let tail = dummy;
    let p1 = list1;
    let p2 = list2;

    while(p1 && p2) {
        if (p1.val > p2.val) {
            tail.next = p2;
            p2 = p2.next;
        } else {
            tail.next = p1;
            p1 = p1.next;
        }
        tail = tail.next;
    }

    if (p1) {
        tail.next = p1;
    } else {
        tail.next = p2;
    }
    return dummy.next;
};
```

```python
class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None:
            return None
        return self.divided(head)
    def divided(self, head):
        if head.next == None:
            return head

        mid = self.findMiddle(head)
        right_head = mid.next
        mid.next = None
        left_head = self.divided(head)
        right_head = self.divided(right_head)
        # print(left_head, right_head)
        return self.merge(left_head, right_head)
    def merge(self, left_head, right_head):
        print("left head:", left_head.val, "right_head:", right_head.val)
        dummy = ListNode()
        p = dummy
        while left_head != None and right_head != None:
            if left_head.val <= right_head.val:
                p.next = left_head
                left_head = left_head.next
            else:
                p.next = right_head
                right_head = right_head.next
            p = p.next
        while left_head != None:
            p.next = left_head
            p = p.next
            left_head = left_head.next
        while right_head != None:
            p.next = right_head
            p = p.next
            right_head = right_head.next
        return dummy.next
    def findMiddle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        fast = head.next
        slow = head
        while fast != None and fast.next != None:
            fast = fast.next.next
            slow = slow.next
        return slow
```

```golang

func sortList(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }
    return divided(head)
}

func divided(head *ListNode) *ListNode {
    if head.Next == nil {
        return head
    }
    mid := findMiddle(head)
    rightHead := mid.Next
    mid.Next = nil
    left := divided(head)
    right := divided(rightHead)
    return merge(left, right)
}

func merge(left *ListNode, right *ListNode) *ListNode {
    dummy := &ListNode{}
    p := dummy
    for left != nil && right != nil {
        if left.Val <= right.Val {
            p.Next = left
            left = left.Next
        } else {
            p.Next = right
            right = right.Next
        }
        p = p.Next
    }
    for left != nil {
        p.Next = left
        left = left.Next
        p = p.Next
    }
    for right != nil {
        p.Next = right
        right = right.Next
        p = p.Next
    }
    return dummy.Next
}

func findMiddle(head *ListNode) *ListNode {
    fast := head.Next
    slow := head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }
    return slow
}
```

## Reference
