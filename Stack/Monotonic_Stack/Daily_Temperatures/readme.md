# [LeetCode 739. Daily Temperatures](https://leetcode-cn.com/problems/daily-temperatures/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`: O(n)
* `Intuition`: 单调栈
* `Key Points`: 递减单调栈
* `Algorithm`:

最暴力解法就是, 如果当前数为`nums[i]`, 则需要遍历`i`之后的所有数,找到比它大的某数`nums[j]`. 答案就是`j - i`
换个思路, 也可以说, 对于当前数`nums[j]`, 向前遍历, 找到第一个比它小的数`nums[i]`
我们用一个单调递减的单调栈, 用来记录之前的那些元素, 只要当前数比栈顶元素大, 当前数就是栈顶元素要找的答案, pop()掉该元素,继续比较栈内元素和当前数
具体看[视频](https://leetcode-cn.com/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/))

### Code1

* `Code Design`:

```python
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        ans = [0 for _ in range(len(temperatures))]
        for i in range(len(temperatures)):
            # 保持现在为单调递减stack
            if len(stack) > 0 and temperatures[i] <= stack[-1][1]:
                stack.append([i, temperatures[i]])
            # 当为空, 或当前温度大于栈顶元素时候, 需要pop stack
            if len(stack) == 0 or (len(stack) > 0 and temperatures[i] > stack[-1][1]):
                while len(stack) > 0 and  temperatures[i] > stack[-1][1]:
                    temp = stack.pop()
                    j, prevTem = temp[0], temp[1]
                    ans[j] = i - j
                stack.append([i, temperatures[i]])
        return ans

```

优化

```python
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        ans = [0 for _ in range(len(temperatures))]
        for i in range(len(temperatures)):
            while len(stack) > 0 and  temperatures[i] > stack[-1][1]:
                temp = stack.pop()
                j, prevTem = temp[0], temp[1]
                ans[j] = i - j
            stack.append([i, temperatures[i]])
        return ans
```

## Reference1

[leetcode ans](https://leetcode-cn.com/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/)
