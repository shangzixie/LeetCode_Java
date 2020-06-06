# 19. Remove_Nth_Node_From_End_of_List

[LeetCode 19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)


## Methods

### Method 1
1. Intuitively, need to consider how to get the Nth node from end. Recursion? or traverse two times, the 1st time, use count to the number of all nodes, 
the second time to remove the Nth?

2. But in fact, we could use 2 pointers instead traversing 2 times. 

3. we let p1 keep n distance from p2. Then when p2 traverse to the end, the p1.next is the node we want to move; 

### Key Points
 in order to consider edge case:`1-->null` or `1 --> 2 --> null`, need to use dummy node. 

### Code
```java
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
      
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // in order to consider edge case, we need nuse dummy node 
        
        ListNode dummy = new ListNode(0); 
        dummy.next = head;               //avoid edge case
        ListNode p1 = dummy, p2 = dummy;
        
        for (int i = 0; i < n; i++){
            p2 = p2.next; 
        }
        
        while (p2.next != null){ //avoid edge case
            p1 = p1.next; 
            p2 = p2.next;
        }
        p1.next = p1.next.next; 
        
        return dummy.next; 
    }
}

```

## Reference