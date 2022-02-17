# [LeetCode 240. Search a 2D Matrix II](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)

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
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        x = 0
        y = len(matrix[0]) - 1
        while x < len(matrix) and y >= 0:
            if x < 0 or y > len(matrix[0]):
                return False
            if matrix[x][y] == target:
                return True
            if matrix[x][y] > target:
                y -= 1
            if matrix[x][y] < target:
                x += 1
        return False
```

## Reference1