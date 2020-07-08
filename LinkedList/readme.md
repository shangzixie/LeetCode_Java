# Basic Knowledge Must know about LinkedList

## Find the middle of a LikedList 

if use dummy: 
```java
class solution{
    public void middle(ListNode head) {
        ListNode dummy = new ListNode(); 
        dummy.next = head; 

        ListNode slow = dummy, fast = dummy; 
        while (fast != null && fast.next != null) { // fast == null for odd, fast.next == null for even 
            slow = slow.next; 
            fast = fast.next.next; 
        }
    }
}

``` 
if not use dummy 

```java
class solution{
    public void middle(ListNode head) {
       
        ListNode slow = head, fast = head.next; // if not use dummy, fast = slow.next;  
        while (fast != null && fast.next != null) { // fast == null for odd, fast.next == null for even 
            slow = slow.next; 
            fast = fast.next.next; 
        }
    }
}

```

## [Reverse a LinkedList](./Reverse_Linked_List)

```java
class solution{
    public ListNode reverseLinkedList(ListNode head) {
        
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode tempNext = cur.next; // the third point is used for moving of the second pointer  
            cur.next = prev;
            prev = cur; 
            cur = tempNext;
        }
        return prev;
    }
}
```