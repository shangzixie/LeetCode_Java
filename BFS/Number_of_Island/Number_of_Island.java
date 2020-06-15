package BFS.Number_of_Island;

import java.util.Arrays;
import java.util.LinkedList;

public class Number_of_Island {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++){
                    if (grid[i][j] == '0') continue;
                    dfs(grid, i, j);
                    count++;
                }
            }
            System.out.println(Arrays.deepToString(grid));
            return count;
    }

    private void dfs(char[][] grid, int i, int j){
            if (grid[i][j] == '0') return;

            grid[i][j] = '0';
            for (int next = 0; next < 4; next++){
                int nextI =i + dx[next];
                int nextJ = j + dy[next];
                if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length) continue;
                dfs(grid, nextI, nextJ);
            }


    }
}
