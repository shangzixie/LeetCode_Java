# 85. Maximal Rectangle

[LeetCode 85](https://leetcode.com/problems/maximal-rectangle/)


## Methods

### Method 1
* `Time Complexity`: 
* `Intuition`: This problem is just like [Largest_Rectangle_in_Histogram](../Largest_Rectangle_in_Histogram). We treat every row as a ` Largest_Rectangle_in_Histogram` problem. Just treat each row as the bottom of a rectangle. 
* `Algorithm`: 
for a `Largest_Rectangle_in_Histogram` question, there are different height. In this question, it is the same: 
for every row, we maintain a height for itself. 
``` 
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]

```
for `1st` row, the input is `[1 0 1 0 0]`, for `2nd` row, the input is `[2, 0, 2, 1, 1], 
for `3rd` row, the input is `[3, 1, 3, 2, 2], for `4th` row, the array is `[4, 0 , 0, 3, 0]`; 
 
For every row, calculate their area separately. 

### Key Points


### Code
```java
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        
        //create a height[][] to count every row's height
        int[][] height = new int[matrix.length][matrix[0].length]; 
        computeHeight(matrix, height);
        
        //traverse the height[][] to calculate area 
        int ans = 0; 
        for (int i = 0; i < height.length; i++) {
            ans = Math.max(areaForRow(height[i]), ans); 
        }
        return ans; 
    }
    
    private void computeHeight(char[][] matrix, int[][] height) {
        for (int j = 0; j < height[0].length; j++){
            height[0][j] = matrix[0][j] == '1' ? 1 : 0; 
        }
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < height[0].length; j++) {
                if (height[i - 1][j] != 0 && matrix[i][j] == '1') height[i][j] = height[i - 1][j] + 1; 
                else if(matrix[i][j] == '1') height[i][j] = 1;
                else height[i][j] = 0;
            }
        }
    } 
    private int areaForRow(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        //求每个柱子的左边第一个小的柱子的下标
        int[] leftLessMin = new int[heights.length]; // leftLess[j] denotes the index smaller than height[i]
        leftLessMin[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) {
                l = leftLessMin[l];
            }
            leftLessMin[i] = l;
        }
    
        //求每个柱子的右边第一个小的柱子的下标
        int[] rightLessMin = new int[heights.length];
        rightLessMin[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int r = i + 1;
            while (r <= heights.length - 1 && heights[r] >= heights[i]) {
                r = rightLessMin[r];
            }
            rightLessMin[i] = r;
        }
    
        //求包含每个柱子的矩形区域的最大面积，选出最大的
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (rightLessMin[i] - leftLessMin[i] - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}

```


## Reference
https://www.youtube.com/watch?v=9NZuhGL0SlU