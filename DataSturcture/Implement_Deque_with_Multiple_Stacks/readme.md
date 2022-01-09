# Implement_Deque_with_Multiple_Stacks

implement Deque, which have the flowing APIs:

```java
popLeft()
popRight()
pushLeft()
pushRight()
```

## Methods

### Method 1

* `Time Complexity`: O(1) 或 O(n)
* `Space Complexity`: O(n)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

一开始想到最粗暴的方法就是用两个stack, `stackRight`定义为常规的stack, 用来执行`popRight()``pushRight()`用, `stackLeft`定义为反向的stack, 用来执行`pushLeft()``popLeft()`用, 示意图:

```
   stackLeft     stackRight
____________     _____________
____________|   |_____________
```

该方法有个特点, 如果一组数在`stackRight`中是`[1,2,3,4]`, 只能从右边pop, 则挪到`stackLeft`还是`[1,2,3,4]`, 变成只能从左边pop, 数字顺序是没变的. 意味着, `pushLeft`时候不用管`stackRight`, `pushRight`时候不用管`stackLeft`

1. `pushRight()`: 将数字push到`stackRight`内
2. `popRight()`: 如果`stackRight`为空, 就把`stackLeft`的数全都挪到`stackRight`中再pop
3. `pushLeft()`: 直接将数字push到`stackLeft`内
4. `popLeft()`: 如果`stackLeft`为空, 将`stackRight`数全挪到`stackLeft`再pop

但是会出现极端情况: `popLeft` 和 `popRight` 交替调用, 导致数组的数来回倒腾, 时间复杂度就是O(n)

### Code1

* `Code Design`:

```cpp
Stack<E> stackLeft;
Stack<E> stackRight;

public NewDeque() {

    stackLeft = new Stack<>();
    stackRight = new Stack<>();

}

void pushLeft(E e) {
    stackLeft.push(e);
}

E popLeft() {
    if (stackLeft.isEmpty()) {
        while (!stackRight.isEmpty()) {
            stackLeft.push(stackRight.pop());
        }
    }
    return stackLeft.pop();
}

void pushRight(E e) {

    stackRight.push(e);
}

E popRight() {
    if (stackRight.isEmpty()) {
        while (!stackLeft.isEmpty()) {
            stackRight.push(stackLeft.pop());
        }
    }
    return stackRight.pop();
}

E get(int i) {
    if (i < stackRight.size()) {
        return stackRight.get(stackRight.size() - i - 1);
    } else {
        return stackLeft.get(i - stackRight.size());
    }

}
```

## Reference1

[stackOverFlow](https://stackoverflow.com/questions/12337278/how-to-implement-a-dequeue-using-two-stacks#:~:text=enqueue(q%2C%20x)%201,from%20stack2%20and%20return%20it.)

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

利用均摊时间复杂度进行优化. 每次调用popLeft或popRight, stack为空时候, 就从另一个栈挪一半的数出来, 例如: `stackLeft = null, stackRight = [1,2,3,4]`, 调用`popLeft()`, 则先`stackLeft = [1,2], stackRight = [3,4]`, 再`popLeft`. 这样可以把pop操作时间复杂度均摊到O(1):

假设n个数全在stackRight, pop一半到temp: `O(0.5n) + O(0.5n)`, pop一半到leftStack: `O(0.5n) + O(0.5n)`, 再pop一半从temp到rightStack: `O(0.5n) + O(0.5n)`, 总共`O(3n)`

然后每次执行pop操作是O(1), 执行了n次, 所以: `O(3n) / n = O(1)`


### Code2

* `Code Design`:

```python

class Solution:
    def __init__(self) -> None:
        self.leftStack = []
        self.rightStack = []
        self.tempStack = []

    def pushRight(self, num) -> None:
        self.rightStack.append(num)

    def pushLeft(self, num):
        self.leftStack.append(num)

    def popLeft(self):
        if len(self.leftStack) == 0:
            length = len(self.rightStack)
            # rigthtStack右半部分暂存起来
            while len(self.rightStack) >= (length // 2):
                self.tempStack.append(self.rightStack.pop())
            # rightStack左半部分移入self.leftStack
            while len(self.rightStack) > 0:
                self.leftStack.append(self.rightStack.pop())
            # 暂存的还给rightStack
            while len(self.tempStack) > 0:
                self.rightStack.append(self.tempStack.pop())
        self.leftStack.pop()

    def popRight(self):
        同理popLeft
```

## Reference2
