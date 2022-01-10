# [No LeetCode, just GeeksforGeeks](https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/)

## Methods

### Method 1

* `Time Complexity`: O(n^2)
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

`[1,3,2,2,4]`

global_min记录将所有stack内的数pop到tempStack时候的最小值, count为该最小值的次数

1. 把stack所有元素都pop到tempStack, 然后记录最小值`global_min = 1`和数量`count = 1`
2. 然后把所有tempStack的数再pop到stack内, 但是global_min不pop回去, 而是放入tempStack.
3. 清空global_min和count. 此时`stack = [3,2,2,4], tempstack = [1]`
4. 把stack所有元素都pop到tempStack, 然后记录最小值`global_min = 2`和数量`count = 2`
5. 然后把所有tempStack的数再pop到stack内, 但是global_min不pop回去, 而是放入tempStack.
6. 清空global_min和count. 此时`stack = [3,4], tempstack = [2]`
7. 略

### Code1

* `Code Design`:

```python
class Solution:
    def ans(self, inputStack):
        tempStack = []
        n = len(inputStack)
        tempStackLen = 0

        while tempStackLen < n:
            globalMin = sys.maxsize
            count = 0

            while len(inputStack) > 0:
                temp = inputStack.pop()
                if temp < globalMin:
                    globalMin = temp
                    count = 1
                elif temp == globalMin:
                    count += 1
                tempStack.append(temp)
            while len(tempStack) > tempStackLen:
                if tempStack[-1] != globalMin:
                    inputStack.append(tempStack.pop())
                else:
                    tempStack.pop()
            while count > 0:
                tempStack.append(globalMin)
                count -= 1
                tempStackLen += 1
        print(tempStack)

```

----------------------

### Method 2

* `Time Complexity`: O(n^2)
* `Space Complexity`: O(n)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

We follow this algorithm.

1. Create a temporary stack say tmpStack.
2. While input stack is NOT empty do this:
    * Pop an element from input stack call it temp
    * while temporary stack is NOT empty and top of temporary stack is greater than temp, pop from temporary stack and push it to the input stack
    * push temp in temporary stack
3. The sorted numbers are in tmpStack

tmpStack的物理意义是: 访问到stack.peek为止, stack.peek以外pop的所有元素在tempStack是呈递增排列
最糟糕情况, stack内所有元素已经是升序

### Code2

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

## Reference2

[geeksforgeeks](https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/)
