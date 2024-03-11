package LeetCode_Java.Topological_Graph_BFS;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class number_of_Insland {

    class Coordinate{
        int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(boolean[][] grid) {

        if (grid.length == 0 || grid == null) return 0;

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int island = 0;


        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == true && visited[i][j] == false){
                    visited[i][j] = true;
                    bfs(i, j, grid, visited);
                    island += 1;
                }
            }
        }
        return island;
    }

    public void bfs(int i, int j, boolean[][] grid, boolean[][] visited) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(i, j));

        while (!queue.isEmpty()){
            Coordinate coordinate = queue.poll();
            for (i = 0; i < dx.length ; i++){
                int nextX = dx[i] + coordinate.x;
                int nextY = dy[i] + coordinate.y;
                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || grid[nextX][nextY] == false || visited[nextX][nextY] == true) continue;
                queue.add(new Coordinate(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
    }



}
