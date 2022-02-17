# [LeetCode 74. Search a 2D Matrix](https://leetcode-cn.com/problems/search-a-2d-matrix/)

## Methods

### Method 1

* `Time Complexity`: O(log(m*n))
* `Space Complexity`: O(1)
* `Intuition`: [transfer 2d array to 1d array](../../skills.md)
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

```python
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n - 1

        while left + 1 < right:
            mid = (left + right) // 2
            i = mid // n
            j = mid % n
            if matrix[i][j] < target:
                left = mid
            elif matrix[i][j] > target:
                right = mid
            else:
                return True

        # 根据模板, 这里需要单独再判断left和right, 防止`[[1]] target: 1`这种情况
        if matrix[left // n][left % n] == target:
            return True
        if matrix[right // n][right % n] == target:
            return True

        return False
```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code2

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

## Reference2

