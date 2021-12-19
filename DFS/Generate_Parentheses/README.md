# 22. Generate_Parentheses

[LeetCode 22](https://leetcode.com/problems/generate-parentheses/)

## Methods

### Method 1

1. generate all combinations--using dfs
2. from example, could get a restriction:
    1. every time, `(` appears more or equals to `)`

![generate_parentheses](../../Image/generate_parentheses.png)

### Key Points

two variable `left` and `right` to record left bracket and right bracket

### Code

```python
from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:

        res = []
        cur_str = ''

        def dfs(cur_str, left, right):
            """
            :param cur_str: 从根结点到叶子结点的路径字符串
            :param left: 左括号还可以使用的个数
            :param right: 右括号还可以使用的个数
            :return:
            """
            if left == 0 and right == 0:
                res.append(cur_str)
                return
            if right < left:
                return
            if left > 0:
                dfs(cur_str + '(', left - 1, right)
            if right > 0:
                dfs(cur_str + ')', left, right - 1)

        dfs(cur_str, n, n)
        return res
```

## Reference