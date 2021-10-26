# [LeetCode 147. Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/)

## Methods

### Method 1

* `Time Complexity`:
* `Intuition`: two pointer
* `Key Points`:
* `Algorithm`:

一个指针`cur`指向某个需要被移动的节点; 其值比后面节点大
一个指针`prev`用来遍历链表,找到`cur`节点应该插入的位置

### Code

* `Code Design`:

```javascript
/**
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
var insertionSortList = function(head) {
    if (!head) return null;

    const dummy = new ListNode(Number.NEGATIVE_INFINITY, head);
    let cur = dummy;
    let prev = dummy;

    while (cur.next) {
        // cur.next 位置正确
        if (cur.val <= cur.next.val) {
            cur = cur.next;
        } else { // cur.next节点应该往前移动
            // 把该节点存起来 并从链表中抽离
            let temp = cur.next;
            cur.next = cur.next.next;
            // 找它应该的位置
            prev = dummy;
            while (prev.next.val < temp.val) {
                prev = prev.next;
            }
            // 插入
            temp.next = prev.next;
            prev.next = temp;
        }
    }
    return dummy.next;
};

```

## Reference

[video](https://www.youtube.com/watch?v=N1VVLLan6S0)