# [LeetCode 899. Orderly Queue](https://leetcode.cn/problems/orderly-queue/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

if k > 1, assume the string is `a[bcdef]`, we could insert `a` into any position of the string, we just keep moving the 2nd letter to the end of the string. In other words, we could insert the 1st letter into any position of the string
-> we could let any letter to be the 1st letter, therefore, we could insert any letter into any position of the string just let the letter be the 1st letter then insert it. so if k > 2, we must be able to get the smallest string, we just sort the string to get the ans.

if k == 1, we just could move the 1st letter to the end, so we could get the smallest string by moving the 1st letter to the end one by one, then we could get the smallest string.

### Code1

* `Code Design`:

```python
class Solution(object):
    def orderlyQueue(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        if k > 1:
            return ''.join(sorted(s))
        ans = s
        for i in range(len(s) - 1):
            ans = min(ans, s[i + 1:] + s[:i + 1])
        return ans
```

## Reference1

[LeetCode Solution](https://leetcode.cn/problems/orderly-queue/solutions/1715592/you-xu-dui-lie-by-leetcode-solution-p6gv/)