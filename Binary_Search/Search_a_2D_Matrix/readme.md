# [LeetCode 74. Search a 2D Matrix](https://leetcode.cn/problems/search-a-2d-matrix/)

## Methods

### Method 1

* `Time Complexity`: log(m*n)
* `Space Complexity`: O(1)
* `Intuition`: treat the 2D matrix as a 1D array
* `Key Points`:
    The matrix is sorted, so we can use binary search
    The matrix is m*n, so we can treat it as a 1D array
* `Algorithm`:

### Code1

* `Code Design`:

```go
func searchMatrix(matrix [][]int, target int) bool {
    if len(matrix) == 0 {
        return false
    }
    total := len(matrix) * len(matrix[0])
    start := 0
    end := total - 1
    for start + 1 < end {
        mid := (start + end) / 2
        x := mid / len(matrix[0])
        y := mid % len(matrix[0])
        if matrix[x][y] < target {
            start = mid
        } else {
            end = mid
        }
    }
    x1 := start / len(matrix[0])
    y1 := start % len(matrix[0])
    x2 := end  / len(matrix[0])
    y2 := end % len(matrix[0])
    if x1 < len(matrix) && y1 < len(matrix[0]) && matrix[x1][y1] == target {
        return true
    }
    if x2 < len(matrix) && y2 < len(matrix[0]) && matrix[x2][y2] == target {
        return true
    }
    return false
}
```
