# 40. Implement Queue by Two Stacks


[LeetCode 40](https://www.lintcode.com/problem/implement-queue-by-two-stacks/description?_from=ladder&&fromId=1)

## Methods

### Method 1
every time, pop elemetns of `stack1` to `stack2`. Then when use `pop()`, we could pop the elements of `stack2`
until the `stack2` is empty, we push `stack1` to `stack2` again. 

### Key Points


### Code
```java
public class MyQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public MyQueue() {
        // do intialization if necessary
        stack1 = new ArrayDeque(); 
        stack2 = new ArrayDeque(); 
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stack1.add(element); 
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.add(stack1.removeLast()); 
            }    
        }
        
        return stack2.removeLast(); 
        
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.add(stack1.removeLast()); 
            }    
        }
        return stack2.getLast();
    }
}


```


## Reference