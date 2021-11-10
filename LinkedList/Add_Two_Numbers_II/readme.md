# [LeetCode 445. Add Two Numbers II](https://leetcode-cn.com/problems/add-two-numbers-ii/)

## Methods

### Method 1

* `Time Complexity`: O(4n) = O(n)
* `Space Complexity`: O(n) 新链表长度
* `Intuition`: 翻转链表
* `Key Points`:
* `Algorithm`:

自己的方法
翻转链表, 再翻转回去

### Code1

* `Code Design`:

```javascript
var addTwoNumbers = function(l1, l2) {
  // duild dummy
  const dummy = new ListNode();
  let p1 = reverse(l1), p2 = reverse(l2);
  let p3 = dummy, carry = 0, cur = 0;
  while (p1 !== null || p2 !== null) {
    // build new node
    const value1 = p1 ? p1.val : 0;
    const value2 = p2 ? p2.val : 0;
    cur = (value1 + value2 + carry) % 10;
    carry = Math.floor((value1 + value2 + carry) / 10);
    p3.next = new ListNode(cur);
    // move pointer
    p1 = p1 ? p1.next : null;
    p2 = p2 ? p2.next : null;
    p3 = p3.next;
  }
  if (carry !== 0) p3.next = new ListNode(carry);
  return reverse(dummy.next);
};

var reverse = function(head) {
  if (head.next === null) return head;
  const tail = reverse(head.next);
  head.next.next = head;
  head.next = null;
  return tail;
}
```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: stack
* `Key Points`: 两个 stack
* `Algorithm`:

### Code2

* `Code Design`:

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<Integer>();
        Deque<Integer> stack2 = new LinkedList<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}

```

## Reference2

[leetcode ans](https://leetcode-cn.com/problems/add-two-numbers-ii/solution/liang-shu-xiang-jia-ii-by-leetcode-solution/)