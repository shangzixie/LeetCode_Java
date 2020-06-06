# 23. Merge k Sorted Lists   

[LeetCode 23](https://leetcode.com/problems/merge-k-sorted-lists/)


## Methods

### Method 1
Every time we need to compare k nodes to get a min one. So could use heap to optimize it.
### Key Points
java lambda `PriorityQueue<ListNode> heap = new PriorityQueue<>((h1, h2)-> h1.val - h2.val);`

### Code
```java

public class Merge_K_Sorted_Lists {
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((h1, h2)-> h1.val - h2.val);
        for (ListNode node : lists){
            if (node == null) continue;
            heap.add(node);
        }

        while (!heap.isEmpty()){
            ListNode top = heap.poll();
            tail.next = top;
            tail = tail.next;
            top = top.next;
            if (top != null){
                heap.add(top);
            }
        }


        return dummy.next;
    }
}
```

## Reference