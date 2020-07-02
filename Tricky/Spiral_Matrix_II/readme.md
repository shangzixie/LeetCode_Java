# 59. Spiral Matrix II

[LeetCode 59](https://leetcode.com/problems/spiral-matrix-ii/)


## Methods

### Method 1
* `Time Complexity`: O(n)
* `Intuition`: the same to [Spiral Matrix I](../Spiral_Matrix), use `left`, `right`, `top`, `bottom`.
* `Algorithm`: 


### Key Points
If `n` is odd, the last center number need to be added. 

### Code
```java
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n]; 
        int left = 0, right = n - 1; 
        int top = 0, bottom = n - 1; 
        int ele = 1; 
        
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) ans[top][i] = ele++; //top
            for (int i = top; i < bottom; i++) ans[i][right] = ele++; //right
            for (int i = right; i > left; i--) ans[bottom][i] = ele++; //bottom
            for (int i = bottom; i > top; i--) ans[i][left] = ele++; //left 
            left++; 
            right--; 
            top++; 
            bottom--; 
        }
        // don't forget the center of the square if n is odd 
        if (n % 2 == 1)ans[left][top] = ele; 
        
        return ans; 
    }
}

```


## Reference