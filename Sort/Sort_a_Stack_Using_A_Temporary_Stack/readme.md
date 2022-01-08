# [No LeetCode, just GeeksforGeeks](https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/)

## Methods

### Method 1

* `Time Complexity`: O(n^2)
* `Space Complexity`: O(n)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

利用 selection sort的原理:

We follow this algorithm.

1. Create a temporary stack say tmpStack.
2. While input stack is NOT empty do this:
    * Pop an element from input stack call it temp
    * while temporary stack is NOT empty and top of temporary stack is greater than temp, pop from temporary stack and push it to the input stack
    * push temp in temporary stack
3. The sorted numbers are in tmpStack

### Code1

* `Code Design`:

```python
class Solution:
    def solution(sef, inputStack):
        if inputStack is None or len(inputStack) <= 1:
            return inputStack

        tempStack = []
        n = len(inputStack)

        while len(tempStack) < n:
            temp = inputStack.pop()
            if len(tempStack) == 0:
                tempStack.append(temp)
            elif len(tempStack) > 0 and tempStack[-1] <= temp:
                tempStack.append(temp)
            else:
                while len(tempStack) != 0 and tempStack[-1] > temp:
                    inputStack.append(tempStack.pop())
                tempStack.append(temp)
        return tempStack
```

优化:

```python
class Solution:
    def solution(sef, inputStack):
        if inputStack is None or len(inputStack) <= 1:
            return inputStack

        tempStack = []
        n = len(inputStack)

        while len(tempStack) < n:
            temp = inputStack.pop()
            while len(tempStack) != 0 and tempStack[-1] > temp:
                inputStack.append(tempStack.pop())
            tempStack.append(temp)

        return tempStack

```

## Reference1

[geeksforgeeks](https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/)
