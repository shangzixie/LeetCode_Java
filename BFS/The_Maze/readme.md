# [LeetCode 490. The Maze](https://leetcode.cn/problems/the-maze/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

easy to use BFS. But, how to reach to wall is the key point.
for other direction bfs problem, we use: `if nextX < 0 or nextY < 0 or nextX >= len(maze) or nextY >= len(maze[0])`, we `continue`.
but for this problem, we reverse the condition: `while nextX >= 0 and nextY >= 0 and nextX < len(maze) and nextY < len(maze[0]) and maze[nextX][nextY] == 0:`

### Code1

* `Code Design`:

```python
class Solution(object):
    def hasPath(self, maze, start, destination):
        """
        :type maze: List[List[int]]
        :type start: List[int]
        :type destination: List[int]
        :rtype: bool
        """
        queue = deque([start])
        visited = [[0 for _ in range(len(maze[0]))] for _ in range(len(maze))]
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        while len(queue) > 0:
            x, y = queue.popleft()
            if destination[0] == x and destination[1] == y:
                return True
            for i in range(4):
                nextX = x + dx[i]
                nextY = y + dy[i]
                while nextX >= 0 and nextY >= 0 and nextX < len(maze) and nextY < len(maze[0]) and maze[nextX][nextY] == 0:
                    nextX += dx[i]
                    nextY += dy[i]
                nextX = nextX - dx[i]
                nextY = nextY - dy[i]
                if visited[nextX][nextY] == 1:
                    continue
                queue.append([nextX, nextY])
                visited[nextX][nextY] = 1
        return False
```

## Reference1

[LeetCode Solution](https://leetcode.cn/problems/the-maze/)