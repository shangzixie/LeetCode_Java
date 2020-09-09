# 225. Implement Stack using Queues

[LeetCode 225](https://leetcode.com/problems/implement-stack-using-queues/)


## Methods

### Method 1
* `Time Complexity`: 
* `Intuition`: queue1 store data and pop. every time call pop, check queue1.
* `Key Points`: 
* `Algorithm`: 


### Code
* `Code Design`: 
```java
class MyStack {

    /** Initialize your data structure here. */
    Deque<Integer> queue1;
    Deque<Integer> queue2;
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.addLast(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() > 1) {
            queue2.addLast(queue1.removeFirst());
        }

        int ans = queue1.removeFirst();
        Deque<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return ans;
    }
    
    /** Get the top element. */
    public int top() {
        return queue1.getLast();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

```


## Reference