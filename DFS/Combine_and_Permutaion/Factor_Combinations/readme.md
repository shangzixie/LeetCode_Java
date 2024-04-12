# [LeetCode 254. Factor Combinations](https://leetcode.cn/problems/factor-combinations/)

## Methods

### Method 1

An answer that took a lot of effort to write. But it is wrong. consider `n = 32`, the ans could be `[[2,2,2,2,2],[2,2,2,4],[2,2,4,2],[2,2,8],[2,4,2,2],[2,4,4],[2,8,2],[2,16],[4,2,2,2],[4,2,4],[4,4,2],[4,8],[8,2,2],[8,4],[16,2]]`, notice that the `[2,2,2,4] and [2,2,4,2]` are the same, but the code will output both of them. So the code is wrong. we need to consider to remove duplicate.
If you were to tackle these questions, how would you address the issue of duplication? It's hard to figure out! so let's change our method

![165](/Image/165.png)

### Code1

* `Code Design`:

```python
class Solution(object):
    def getFactors(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        nums = self.getFactorsNums(n)
        nums.sort()
        self.ans = []

        self.dfs(nums, [], 0, [0] * len(nums))
        return self.ans

    def dfs(self, nums, path, startIndex, visited):
        if startIndex > len(nums):
            return
        if startIndex == len(nums):
            if len(path) > 0:
                self.ans.append(copy.deepcopy(path))
            return

        for length in range(1, len(nums)):
            if startIndex + length > len(nums):
                return
            if visited
            product = self.getProduct(startIndex, startIndex + length, nums, visited)
            path.append(product)
            self.dfs(nums, path, length + startIndex)
            path.pop()
    def getProduct(self, start, end, nums, visited):
        product = 1
        while start != end:
            product *= nums[start]
            visited[start]
            start += 1
        return product
    def getFactorsNums(self, n):
        ans = []
        a = n
        b = 2
        while b < n and a != 1:
            if a % b == 0:
                ans.append(b)
                a = a // b
            else:
                b += 1
        return ans
```

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

what if we change the dfs tree, every time dfs, instead of `n` to `n / i`? the terminate base case is `n == 1`?

then take the `30` as an example, to draw a tree, the node is the dividend.
there is a core point:

every dfs level, the dividend is larger than its parent dividend. for example, the node `10`, no need to divide `2` again when dfs, because we have already divided `3` in the level, we need to guarantee that the dividend is larger than its parent dividend. Because, when we dfs to `10`, previous path is `[[2,3,5], [2, 15]]`, if we divide `2` again, the path will be `[3,2,5]`, which is duplicate.

![166](/Image/166.png)

### Code2

* `Code Design`:

```python
class Solution(object):
    def getFactors(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        self.ans = []
        self.dfs(n, 2, [])
        return self.ans
    def dfs(self, n, start, path):f
        if len(path) > 1 and n == 1:
            self.ans.append(copy.deepcopy(path))
            return

        for i in range(start, n + 1):
            if n % i != 0:
                continue
            path.append(i)
            self.dfs(n // i, i, path)
            path.pop()

```

## Reference2
