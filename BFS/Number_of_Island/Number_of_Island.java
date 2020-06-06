package LeetCode_Java.BFS.Number_of_Island;

import java.util.LinkedList;

public class Number_of_Island {
    public boolean[][] visited;
    int[] dx = new int[]{1, -1, 0 ,0};
    int[] dy = new int[]{0, 0, -1, 1};
    class Points{
        int x;
        int y;
        Points(int i, int j){
            x = i;
            y = j;
        }
    }
    //
    public int numIslands(boolean[][] grid) {
        if (grid.length == 0) return 0;

        visited = new boolean[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (visited[i][j] == true || grid[i][j] == false) continue;
                visited[i][j] = true;
                bfs(grid, i, j);
                count++;
            }
        }
        return count;

    }


    private void bfs(boolean[][] grid, int i, int j){
        LinkedList<Points> queue = new LinkedList<>();
        Points point = new Points(i ,j);
        queue.add(point);


        while (!queue.isEmpty()){
            Points curPoint = queue.removeFirst();
            int curX = curPoint.x;
            int curY = curPoint.y;

            for (int index = 0; index < 4; index++){
                int nextX = curX + dx[index];
                int nextY = curY + dy[index];
                if (nextX < 0 || nextX >= grid.length || nextY <0 || nextY >= grid[0].length || visited[nextX][nextY] == true || grid[nextX][nextY] == false){
                    continue;
                }
                visited[nextX][nextY] = true;
                queue.add(new Points(nextX, nextY));
            }

        }
    }
}
