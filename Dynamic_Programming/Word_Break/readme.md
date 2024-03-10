# [LeetCode 139. Word Break](https://leetcode.cn/problems/word-break/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: dfs + memo
* `Key Points`:
* `Algorithm`:

![142](/Image/142.png)

### Code1

* `Code Design`:

```python
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        word = {}
        visited = {}
        for string in wordDict:
            word[string] = True
        return self.dfs(0, s, word, visited)
    def dfs(self, start, s, word, visited):
        if start == len(s):
            return True
        if start in visited:
            return visited[start]
        for end in range(start + 1, len(s) + 1):
            subStr = s[start : end]
            subResult = self.dfs(end, s, word, visited)
            if subStr in word and subResult:
                visited[start] = True
                return True
        visited[start] = False
        return False
```

## Reference1

[LeetCode Solution](https://leetcode.cn/problems/word-break/solutions/302779/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/)

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: dp
* `Key Points`:
* `Algorithm`:

### Code2

* `Code Design`:

```java


```

## Reference2
