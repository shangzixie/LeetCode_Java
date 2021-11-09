# [LeetCode 160. Intersection of Two Linked Lists](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`: O(1)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

自己写的代码:  具体思路看注释

### Code1

* `Code Design`:

```javascript
/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    let p1 = headA, p2 = headB;
    // 先两个指针遍历各自的linked list, 其中一个到末尾就停止
    while (p1 !== null && p2 !== null) {
        p1 = p1.next;
        p2 = p2.next;
    }
    // 此时把遍历到末尾的那个指针移动到另一个linked list头部
    if (p1 === null) p1 = headB;
    else if (p2 === null) p2 = headA;

    // 之后再遍历, 直到相遇位置. 但是如果其中一个遍历到了末尾, 就再把它移动到头部. 该指针和上面那个移动到头部的指针一定不是同一个
    // 如果两个指针都遍历到了末尾, 说明没有重合节点, 此时两个指针都把两个linked list都遍历了一遍. 返回空
    while (p1 !== null || p2 !== null) {
        if (p1 === null) p1 = headB;
        else if (p2 === null) p2 = headA;
        if (p1 === p2) return p1;
        p1 = p1.next;
        p2 = p2.next;
    }
    return null;
};
```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

中止情况就两种: 1. 要么有交叉, 两个指针都指向交叉节点 2. 要么没有交叉, 两个指针都指向对方linked list的末尾空节点

### Code2

* `Code Design`:

```javascript
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        // 中止情况就两种: 1. 要么有交叉, 两个指针都指向交叉节点 2. 要么没有交叉, 两个指针都指向对方linked list的末尾空节点
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

```

## Reference2
