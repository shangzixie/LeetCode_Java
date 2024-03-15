# 54.Spiral Matrix

[LeetCode 54](https://leetcode.com/problems/spiral-matrix/)

## Methods

### Method 1

* `Time Complexity`: O(m*n)
* `Intuition`: directly simulate the scan
* `Algorithm`: 4 variable -- `left` `right` `top` `bottom` to form sides of rectangular. every loop, reduce the size;  

### Key Points

don't forget if the matrix is rectangular, after finishing the loop, it will left a col or row need to be added into `res`

### Code

```java
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while (top < bottom && left < right) {
            for (int i = left; i < right; i++) result.add(matrix[top][i]); // top
            for (int i = top; i < bottom; i++) result.add(matrix[i][right]); //right
            for (int i = right; i > left; i--) result.add(matrix[bottom][i]); // bottom
            for (int i = bottom; i > top; i--) result.add(matrix[i][left]); // left
            left++;
            right--;
            top++;
            bottom--;
        }
        // if matrix is not square, just rectangular.
        // key point
        if (top == bottom) {
            for (int i = left; i <= right; i++) result.add(matrix[top][i]);
        } else if (left == right) {
            for (int i = top; i <= bottom; i++) result.add(matrix[i][left]);
        }
        return result;
    }
}

```

## Reference
