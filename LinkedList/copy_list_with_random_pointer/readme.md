# [LeetCode 138. Copy List with Random Pointer](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)

## Methods

### Method 1

* `Time Complexity`:
* `Intuition`: copy linkedlist as usual, but use a map to store node
* `Key Points`:
* `Algorithm`:

use a map to store node, use old node as new linked list random node, then copy random node

### Code

* `Code Design`:

```javascript
/**
 * // Definition for a Node.
 * function Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {Node} head
 * @return {Node}
 */
var copyRandomList = function(head) {
    if (!head) return;

    let old2new = new Map();
    let dummy = new Node();
    let newListTail = new Node(head.val);
    dummy.next = newListTail
    let originListTail = head;

    // 因为用的当前的节点originListTail当循环节点
    while (originListTail) {
        // 所以copy next node
        if (originListTail.next) {
            newListTail.next = new Node(originListTail.next.val);
        } else {
            newListTail.next = null;
        }
        // use old random
        newListTail.random = originListTail.random;
        // build map
        old2new.set(originListTail, newListTail);
        // move tail
        originListTail = originListTail.next;
        newListTail = newListTail.next;
    }
    // copy random
    let cur = dummy.next;
    while (cur) {
        if (cur.random) {
            cur.random = old2new.get(cur.random);
        }
        cur = cur.next;
    }
    return dummy.next;
};

```

## Reference
