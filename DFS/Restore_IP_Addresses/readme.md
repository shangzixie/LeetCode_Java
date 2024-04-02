# [LeetCode 93. Restore IP Addresses](https://leetcode-cn.com/problems/restore-ip-addresses/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

![157](/Image/157.png)

和[Palindrome_Partitioning](DFS/Palindrome_Partitioning/readme.md)类似, 但是需要注意几个点:

1. 先用一个数组记录path, 最后再拼接
2. for循环是从1到3, 所以要写`range(1,4), 因为字符串最长为3个数字拼接

### Code1

* `Code Design`:

```python
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        self.results = []
        self.dfs(s, [], 0)
        return self.results

    def dfs(self, s, path, startIndex):
        if len(path) == 4 and startIndex == len(s):
            self.results.append('.'.join(path))
            return
        if len(path) >= 4 and startIndex < len(s):
            return

        for length in range(1, 4):
            subString = s[startIndex: startIndex + length]
            if startIndex + length > len(s) + 1:
                continue
            if not subString:
                continue
            if len(subString) > 1 and subString[0] == '0':
                continue
            if int(subString) > 255:
                continue
            path.append(subString)
            self.dfs(s, path, startIndex + length)
            path.pop()
```

## Reference1

[leetcode ans](https://leetcode-cn.com/problems/restore-ip-addresses/solution/shou-hua-tu-jie-huan-yuan-dfs-hui-su-de-xi-jie-by-/)