# [LeetCode 200. Number of Islands](https://leetcode-cn.com/problems/number-of-islands/)

## Methods

### Method 1

* `Time Complexity`: O(mn)
* `Space Complexity`: O(min(m, n))
* `Intuition`: BFS
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

```python
import collections

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        visited = [[0 for _ in range(len(grid[0]))] for _ in range(len(grid))]
        count = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if visited[i][j] == 1 or grid[i][j] == '0':
                    continue
                self.bfs(grid, i, j, visited, dx, dy)
                count += 1

        return count


    def bfs(self, grid, i, j, visited, dx, dy):
        deque = collections.deque([(i, j)])

        while len(deque) > 0:
            point = deque.popleft()
            x = point[0]
            y = point[1]
            visited[x][y] = 1
            # 遍历当前节点的四周
            for index in range(4):
                nextX = x + dx[index]
                nextY = y + dy[index]
                if nextY < 0 or nextX < 0 or nextX >= len(grid) or nextY >= len(grid[0]):
                    continue
                if grid[nextX][nextY] == '1' and visited[nextX][nextY] == 0:
                    deque.append([nextX, nextY])
```

```java
public class Solution {
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

            for (int index = 0; index < 4; index++) {
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
```

## Reference1
