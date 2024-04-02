# [LeetCode Subsets II](https://leetcode.cn/problems/subsets-ii/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
![158](/Image/158.png)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

```python
class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        self.ans = []
        visited = [0] * len(nums)
        self.dfs(nums, 0, [], visited)
        return self.ans
    def dfs(self, nums, startIndex, subArray, visited):
        self.ans.append(copy.deepcopy(subArray))
        for i in range(startIndex, len(nums)):
            if i > 0 and nums[i] == nums[i - 1] and visited[i - 1] == 0:
                continue
            subArray.append(nums[i])
            visited[i] = 1
            self.dfs(nums, i + 1, subArray, visited) # i + 1, not startIndex + 1 !!!
            subArray.pop()
            visited[i] = 0
```

using binary to represent the visited

```python
class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        self.ans = []
        visited = 0
        self.dfs(nums, 0, [], visited)
        return self.ans
    def dfs(self, nums, startIndex, subArray, visited):
        self.ans.append(copy.deepcopy(subArray))
        for i in range(startIndex, len(nums)):
            if i > 0 and nums[i] == nums[i - 1] and (visited >> i - 1) & 1 == 0:
                continue
            subArray.append(nums[i])
            visited |= (1 << i)
            self.dfs(nums, i + 1, subArray, visited)
            subArray.pop()
            visited &= (0 << i)

```

## Reference1

