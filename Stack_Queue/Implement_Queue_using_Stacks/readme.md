# 232. Implement_Queue_using_Stacks

[LeetCode 232](https://leetcode.com/problems/implement-queue-using-stacks/)


## Methods

### Method 1
* `Time Complexity`: 
* `Intuition`: Use stack1 to store num, use stack2 to pop(). Every time using pop(), check the stack2 is empty or not.
* `Key Points`: 
* `Algorithm`: 


### Code
* `Code Design`: 
```java
class MyQueue {

    /** Initialize your data structure here. */
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int num) {
        stack1.addLast(num);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.removeLast());
            }
        }
        return stack2.removeLast();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) return stack1.getFirst();
        return stack2.getLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

```


## Reference