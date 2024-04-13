# [LeetCode 22. Generate Parentheses](https://leetcode.cn/problems/generate-parentheses/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

```python
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        self.ans = []
        self.dfs(n, n, "")
        return self.ans
    def dfs(self, left, right, subString):
        if left < 0:
            return
        if right < 0:
            return
        if left > right:
            return
        if left == 0 and right == 0:
            self.ans.append(subString)
            return

        self.dfs(left - 1, right, subString + "(")
        self.dfs(left, right - 1, subString + ")")

```

## Reference1
