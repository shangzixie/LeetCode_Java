package LeetCode_Java.BFS.Union_Find.Number_of_Islands_II;

import java.util.ArrayList;
import java.util.List;

public class Union_of_Island_II {
    //build union find
    class unionFind{
        private int[] father;
        private int size;

        unionFind(int n){
            this.father = new int[n];
            for (int i =0; i < n; i++){
                father[i] = i;
            }
            this.size = 0;
        }
        public int find(int x){
            if (father[x] == x) return x;
            return father[x] = find(father[x]);
        }
        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB){
                father[rootA] = rootB;
                this.size--;
            }
        }
    }
    // this question


    class Point {
         int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b) { x = a; y = b; }
    }


    public List<Integer> numIslands2(int m, int n, Point[] operators) {
        List<Integer> res = new ArrayList<>();
        if (operators == null || operators.length == 0) return res;

        int[] direction = {-1, 0, 1, 0, -1};
        unionFind uf = new unionFind(m * n);
        int[][] grid = new int[m][n];

        for (Point point : operators){
            //add a new island
            int x = point.x, y = point.y;
            if (grid[x][y] == 1){
                res.add(uf.size);
                continue;
            }
            grid[x][y] = 1;
            uf.size ++;

            for (int k = 0; k < 4; k++){
                int nextX = x + direction[k];
                int nextY = y + direction[k+1];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || grid[nextX][nextY] == 0) continue;

                uf.union(x * n + y, nextX * n + nextY);
                grid[nextX][nextY] = 1;
            }
            res.add(uf.size);
        }
        return res;
    }


}
