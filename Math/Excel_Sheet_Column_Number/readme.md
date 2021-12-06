# [LeetCode 171. Excel Sheet Column Number](https://leetcode-cn.com/problems/excel-sheet-column-number/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

26进制转10进制

### Code1

* `Code Design`:

```python
class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        ans = 0
        power = 0
        for i in range(len(columnTitle) - 1, -1, -1): # 倒排
            curStr = columnTitle[i]
            ans += 26 ** power * (ord(curStr) - ord('A') + 1) #　记得加１
            power += 1　# 别忘了power + 1
        return ans
```

## Reference1
