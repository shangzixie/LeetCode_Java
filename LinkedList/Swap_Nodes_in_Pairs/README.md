# 24. Swap Nodes in Pairs    

[LeetCode 24](https://leetcode.com/problems/swap-nodes-in-pairs/)


## Methods

### Method 1
1.  swap 2 nodes
2. use a pointer `p` to iterator all nodes, everytime, swap 2 nodes


### Key Points
terminal condition is: 
`p.next.next == null && p.next == null`

because: 
```
when :

                p  
dummy->1->2->3->4->null
 
          p
dummy->1->2->3->null

there is no need to swap
```

### Code
```java
public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        
        while (p.next != null && p.next.next != null ){//terminal condition
            swapTwoNode(p, p.next, p.next.next);
            p = p.next.next;
        }
        return dummy.next;

    }
    
    //use 3 nodes to swap 2 nodes
    private void swapTwoNode(ListNode pre, ListNode p1, ListNode p2){
        p1.next = p2.next;
        p2.next = p1;
        pre.next = p2;
    }
}

```

## Reference