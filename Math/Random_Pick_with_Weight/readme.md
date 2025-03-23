# [LeetCode 528. Random Pick with Weight](https://leetcode.cn/problems/random-pick-with-weight/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

我们首先需要借助接口`random.randint(a, b)`, 该接口表明返回一个在区间`[a, b]`内的随机整数。

但是我们如何将该接口和权重结合应用到本题呢?

我们是不是可以转换为图像的形式。 例如`w=[3,1,2,4]`, 权重和为`10`。we could build a length 10's line segment. its length is `[3,1,2,4]`.

![183](/Image/183.png)

so when we call `num = random.randint(1,10)`, we could get a `num`, if `num` is `1、2、3`, it is `3`; if `num` is `4`, it is `1`; if `num` is `5、6` it is 2; if num is `7、8、9、10`， it is `4`;

but how to map the random num to real ans? If we consider brute force. when call `num = random.randint(1, 10)`, we get `5`. `5`意味着第五个线段，我们从`w = [3,1,2,4]`每个元素累加，`3 + 1 = 4` < 5, 发现第五个线段是落在index=2的位置，也就是2.所以答案是2

所以每次我们拿到一个random num，然后累加前面所有数，找到最后一个比num小的和，index就是答案 -> prefix + 二分法

### Code1

* `Code Design`:

```python
class Solution:

    def __init__(self, w: List[int]):
        self.pre = list(accumulate(w))
        self.total = sum(w)

    def pickIndex(self) -> int:
        x = random.randint(1, self.total)
        return bisect_left(self.pre, x)

```

## Reference1
