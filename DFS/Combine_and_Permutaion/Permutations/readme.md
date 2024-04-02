# [LeetCode 46. Permutations](https://leetcode.cn/problems/permutations/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:

don't forget `deepcopy`
![159](/Image/159.png)

* `Intuition`:
* `Key Points`:
* `Algorithm`:

![160](/Image/160.png)

### Code1

* `Code Design`:

```python

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        visited = [0] * len(nums)
        self.ans = []
        self.dfs(nums, visited, [])
        return self.ans
    def dfs(self, nums, visited, subArray):
        if len(subArray) == len(nums):
            self.ans.append(copy.deepcopy(subArray))
            return
        for i in range(len(nums)):
            if visited[i]:
                continue
            subArray.append(nums[i])
            visited[i] = 1
            self.dfs(nums, visited, subArray)
            visited[i] = 0
            subArray.pop()
```

## Reference1
