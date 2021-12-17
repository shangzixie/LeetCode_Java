# [LeetCode 40. Combination Sum II](https://leetcode-cn.com/problems/combination-sum-ii/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

这道题主要就是去重, 对于[0,1,1,2,2,5], target = 8, 需要取[0,1',2',5'], 而不能取[0,1',2",5']等
也就是说, 相同的数, 比如`2`, 如果第一个`2`没被取, 其他的`2`都不应该被取

### Code1

* `Code Design`:

```python
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        self.results = []
        candidates.sort()
        self.dfs(0, candidates, target, 0, [])

        return self.results

    def dfs(self, index, candidates, target, sum, path):
        if sum == target:
            self.results.append(copy.deepcopy(path))
            return
        if sum > target:
            return

        for i in range(index, len(candidates)):
            if i > 0 and i > index and candidates[i - 1] == candidates[i]: # 去重
                continue
            sum += candidates[i]
            path.append(candidates[i])
            self.dfs(i + 1, candidates, target, sum, path)
            sum -= candidates[i]
            path.pop()
```

## Reference1
