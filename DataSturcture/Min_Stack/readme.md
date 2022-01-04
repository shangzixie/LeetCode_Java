# [LeetCode 155. Min Stack](https://leetcode-cn.com/problems/min-stack/)

## Methods

### Method 1

* `Time Complexity`: 所有操作都是O(1)
* `Space Complexity`: O(n)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

![101](../../Image/101.png)
维护两个栈, 另一个栈维护当前的最小值

### Code1

* `Code Design`:

```python
class MinStack:
    def __init__(self):
        self.stack = []
        self.min_stack = [math.inf]

    def push(self, x: int) -> None:
        self.stack.append(x)
        self.min_stack.append(min(x, self.min_stack[-1]))

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]

```

## Reference1

[leetcode solution](https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/)

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

是否可以考虑优化第二个栈?


### Code2

* `Code Design`:

```java


```

## Reference2
