# [LeetCode 827. Making A Large Island](https://leetcode.cn/problems/making-a-large-island/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

![179](/Image/179.png)
![179](/Image/180.png)

这里我用bfs，而不是dfs做。

### Code1

* `Code Design`:

```python
from collections import deque
class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        if n == 0: 
            return 1

        # 从2开始计数
        idx, area_dic = 2, dict()
        # 给岛屿编号，只计算未编号的岛屿
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    area_dic[idx] = self.bfs(grid, idx, i, j)
                    idx += 1

        # 无岛屿，全是海洋
        if len(area_dic) == 0: 
            return 1
        res, sea = 0, False
        for i in range(n):
            for j in range(n):
                # area面积，cover避免重复计算
                area, cover = 0, []
                if grid[i][j] != 0:
                    continue
                area += 1 # change current 0 to 1, so size plus 1
                for ni, nj in [(i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)]:
                    if 0 <= ni < n and 0 <= nj < n and grid[ni][nj] != 0 and grid[ni][nj] not in cover:
                        area += area_dic[grid[ni][nj]]
                        cover.append(grid[ni][nj])
                sea = True
                res = max(res, area)

        if not sea: 
            return n * n

        return res

    def bfs(self, grid, idx, i, j):
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        size = 1
        queue = deque([(i, j)])
        grid[i][j] = idx
        while queue:
            cur_x, cur_y = queue.popleft()
            for i in range(4):
                next_x = cur_x + dx[i]
                next_y = cur_y + dy[i]
                if next_x < 0 or next_x >= len(grid) or next_y < 0 or next_y >= len(grid[0]):
                    continue
                if grid[next_x][next_y] == 1:
                    queue.append((next_x, next_y))
                    grid[next_x][next_y] = idx
                    size += 1
        return size

```

## Reference1

[LeetCode Ans](https://leetcode.cn/problems/making-a-large-island/solutions/1830957/by-muse-77-37hi/)