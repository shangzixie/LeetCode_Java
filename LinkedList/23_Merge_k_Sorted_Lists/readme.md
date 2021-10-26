# [LeetCode 23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)

## Methods

### Method 1

* `Time Complexity`: O(NK)
* `Intuition`: 每次 O(K)O(K) 比较 K个指针求 min
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (true) {
            ListNode minNode = null;
            int minPointer = -1;
            for (int i = 0; i < k; i++) {
                // 判空
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            // 所有linked list都已经遍历到最后
            if (minPointer == -1) {
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            // 别忘了把当前最小node往后移一位
            lists[minPointer] = lists[minPointer].next;
        }
        return dummyHead.next;
    }
}
```

### Method 2

* `Time Complexity`: O(N * LogK)
* `Intuition`: 使用小根堆对 方法1 进行优化，每次 O(logK)O(logK) 比较 K个指针求 min
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }
}
```

## Reference

[LeetCode China](https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/)
