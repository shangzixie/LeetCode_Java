# [LeetCode 138. Copy List with Random Pointer](https://leetcode-cn.com/problems/copy-list-with-random-pointer/)

## Methods

### Method 1

* `Time Complexity`:
* `Intuition`: copy linkedlist as usual, but use a map to store node
* `Key Points`:
* `Algorithm`:

本题要求我们对一个特殊的链表进行深拷贝。如果是普通链表，我们可以直接按照遍历的顺序创建链表节点。而本题中因为随机指针的存在，当我们拷贝节点时，「当前节点的随机指针指向的节点」可能还没创建，因此我们需要变换思路。
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

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

![154](/Image//154.png)
![155](/Image//155.png)
![156](/Image//156.png)

### Code2

* `Code Design`:

```python
class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if head is None:
            return None
        p = head
        while p:
            copyNode = Node(p.val, p.next)
            p.next = copyNode
            p = p.next.next
        p = head
        while p:
            if p.random:
                p.next.random = p.random.next
            p = p.next.next
        p = head
        newP = head.next
        while p and p.next:
            nextNode = p.next
            p.next = p.next.next
            p = nextNode
        return newP
```

## Reference2

[LeetCode Solution](https://leetcode.cn/problems/copy-list-with-random-pointer/solutions/889166/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-rblsf/)
