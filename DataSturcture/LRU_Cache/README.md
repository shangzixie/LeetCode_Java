# 146. LRU Cache

[LeetCode 146](https://leetcode.com/problems/lru-cache/)


## Methods
### Method 1
the point is which data used recently, its priority is the highest.

so use: `DoubleLinkedList + map`
### Algorithm
need a `node` class to store `key`, `value` and build `double linkedlist`

need 3 functions:
``` 
1. add to tail: add a node to tail
2. move to tail: move a middle node to tail 
3. delete head: delete head node 
```


### Code
```java

public class LRUCache {
    /*
    * @param capacity: An integer
    */
    class Node {
        int key; 
        int val;
        Node pre; 
        Node next; 
        Node () {}
        Node (int key, int value) {
            this.key = key; 
            this.val = value;
        }
    }
    private Map<Integer, Node> map;
    private int maxSize;
    private int size; 
    private Node dummy, tail; 
    
    public LRUCache(int capacity) {
        maxSize = capacity; 
        size = 0; 
        map = new HashMap<>();
        
        //build head and tail null nodes; 
        dummy = new Node(); 
        tail = new Node();
        dummy.next = tail; 
        tail.pre = dummy; 
    }


    public int get(int key) {
        if (!map.containsKey(key)) return -1; 
        moveToTail(map.get(key)); 
        return map.get(key).val; 
    }


    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            //build this node and size + 1
            size++;
            Node newNode = new Node(key, value); 
            //add to map 
            map.put(key, newNode); 
            //add to linkedlist
            addToTail(newNode); 
            //if capacity is overflow 
            if (size > maxSize) {
                // delete map and linkedlist
                map.remove(deleteHead().key);
            }
        }else {
            map.get(key).val = value; 
            moveToTail(map.get(key)); 
        }
    }
    private void addToTail(Node newNode) {
        Node preNode = tail.pre; 
        preNode.next = newNode; 
        newNode.pre = preNode; 
        tail.pre = newNode; 
        newNode.next = tail;
    }
    private void moveToTail(Node node) {
        node.pre.next = node.next; 
        node.next.pre = node.pre; 
        addToTail(node); 
    }
    private Node deleteHead() {
        Node nodeRemoved = dummy.next; 
        Node t = nodeRemoved.next; 
        dummy.next = t; 
        t.pre = dummy; 
        return nodeRemoved; 
        
    }
}
```


## Reference