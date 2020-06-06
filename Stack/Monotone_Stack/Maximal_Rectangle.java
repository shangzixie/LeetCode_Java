package LeetCode_Java.Stack.Monotone_Stack;
import java.util.Stack;

/*
it is the same to Largest Rectangle in Histogram.
every row in matrix is a LRH problem.

https://www.youtube.com/watch?v=9NZuhGL0SlU
 */

public class Maximal_Rectangle {
    public int maximalRectangle(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] grid = new int[m][n];

        buildGridHistogram(grid, matrix);
        int maxArea = 0;
        for (int i =0; i < m; i++){
            maxArea = Math.max(maxArea, getArea(grid[i]));
        }
        return maxArea;
    }

    private int getArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxRes = 0;
        for (int i = 0; i<heights.length;i++){
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxRes = Math.max(maxRes, height * width);
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            maxRes = Math.max(maxRes, heights[stack.pop()] * (heights.length - stack.peek() -1));
        }
        return maxRes;
    }


    private void buildGridHistogram(int[][] grid, boolean[][] matrix){

        for (int j =0; j < matrix[0].length; j++){
            grid[0][j] = (matrix[0][j] == true? 1:0);
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j =0 ; j < matrix[0].length; j++){
                grid[i][j] = (matrix[i][j] == false? 0: grid[i-1][j] + 1);
            }
        }
    }



}
