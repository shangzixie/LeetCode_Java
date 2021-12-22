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
* `Intuition`: 使用小根堆对 方法1 进行优化，每次 O(logK) 比较 K个指针求 min
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

### Method 3

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

两两合并对 1 进行优化，时间复杂度：O(NlogK)
时间复杂度分析：K 条链表的总结点数是 N，平均每条链表有 N/K 个节点，因此合并两条链表的时间复杂度是 O(N/K)。从 K 条链表开始两两合并成 1 条链表，因此每条链表都会被合并 logK 次，因此 K 条链表会被合并 `K * logK` 次，因此总共的时间复杂度是 `K * logK * N/K` 即 `O（NlogK)`

下面分别贴出「两两合并」的「递归」 和 「迭代」两种实现 ：

两两合并 - 迭代

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int k = lists.length;
        while (k > 1) {
            int idx = 0;
            for (int i = 0; i < k; i += 2) {
                if (i == k - 1) {
                    lists[idx++] = lists[i];
                } else {
                    lists[idx++] = merge2Lists(lists[i], lists[i + 1]);
                }
            }
            k = idx;
        }
        return lists[0];
    }
}
```

两两合并 - 递归

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divided(lists, 0, lists.length - 1);
    }

    private ListNode divided(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = divided(lists, left, mid);
        ListNode l2 = divided(lists, mid + 1, right);

        return merge2Lists(l1, l2);
    }

```

## Reference

[LeetCode China](https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/)
