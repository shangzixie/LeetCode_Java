# [LeetCode 380. Insert Delete GetRandom O(1)](https://leetcode-cn.com/problems/insert-delete-getrandom-o1/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

要想得到一个随机的`val`, 只能用数组存储, 然后随机得到一个index, 去取该index对应的值.
但是仅用数组做不到remove为O(1): 因为 每次移走一个element, 所有该element后面的元素都要往前移动.
此时, 可以将移除的element和数组最后一个元素交换, 然后pop()最后一个元素就行

但是, 仅一个数组, 是无法在插入和删除时候快速判断该数在组数中的的位置的, 所以还需要一个map, key为该数数值, value为在数组中的index

### Code1

* `Code Design`:

```python
from random import choice

class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.valToIndex = {}
        self.arr = []


    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val in self.valToIndex:
            return False
        index = len(self.arr)
        self.valToIndex[val] = index
        self.arr.append(val)
        return True
    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val not in self.valToIndex:
            return False
        # update array
        lastElementVal = self.arr[-1]
        index = self.valToIndex[val]
        self.arr[index] = lastElementVal
        # update map
        self.valToIndex[lastElementVal] = index
        # remvoe
        self.arr.pop()
        del self.valToIndex[val]
        return True
    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        return choice(self.arr)
```

## Reference1

[leetcode ans](https://leetcode-cn.com/problems/insert-delete-getrandom-o1/solution/chang-shu-shi-jian-cha-ru-shan-chu-he-huo-qu-sui-j/)