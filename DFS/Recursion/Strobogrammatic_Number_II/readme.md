# [LeetCode 247. Strobogrammatic Number II](https://leetcode.cn/problems/strobogrammatic-number-ii/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

这道题利用回溯, 从middle往两边扩散. 回溯的stop sign是长度为0或者1时候.

例如`n = 4`时候, 从中间开始, 此时中间为空`''`, `n=3`时候, 中间开始时候中间值可以为`'0'`, `'1'`, `'8'`

回溯回来后, 每次往两边加对称数字, 如果为首字母, 不能为`0`

### Code1

* `Code Design`:

```python
class Solution:
    def findStrobogrammatic(self, n: int) -> List[str]:
        self.rotate = {"0": "0", "1": "1", "6": "9", "8": "8", "9": "6"}
        return self.dfs(n, True)
    def dfs(self, n, is_head):
        if n == 0:
            return [""]
        if n == 1:
            return ["0", "1", "8"]
        ret = []
        mids = self.dfs(n - 2, False)
        for k, v in self.rotate.items():
            if is_head and k == "0":
                continue
            for mid in mids:
                ret.append(k + mid + v)
        return ret
```

## Reference1

[leetcode官方答案](https://leetcode.cn/problems/strobogrammatic-number-ii/solutions/2419830/zhong-xin-dui-cheng-shu-ii-by-leetcode-s-dn8u/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM)
