# [LeetCode 886. Possible Bipartition](https://leetcode.cn/problems/possible-bipartition/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

need to do [LeetCode 785. Is Graph Bipartite?](/BFS/Is_Graph_Bipartite/readme.md) first

### Code1

* `Code Design`:

```python
class Solution(object):
    def possibleBipartition(self, n, dislikes):
        """
        :type n: int
        :type dislikes: List[List[int]]
        :rtype: bool
        """
        adjacencyList = [[] for _ in range(n + 1)]
        for i, j in dislikes:
            adjacencyList[i].append(j)
            adjacencyList[j].append(i)
        visited = [0] * (n + 1)

        for i in range(1, n + 1):
            if visited[i] != 0:
                continue
            visited[i] = 1
            queue = deque([i])
            while queue:
                cur = queue.popleft()
                neiborhoodGroup = 2 if visited[cur] == 1 else 1
                for neibor in adjacencyList[cur]:
                    if visited[neibor] != 0:
                        if visited[neibor] != neiborhoodGroup:
                            return False
                    else:
                        visited[neibor] = neiborhoodGroup
                        queue.append(neibor)
        return True
```

## Reference1

[LeetCode 785. Is Graph Bipartite?](/BFS/Is_Graph_Bipartite/readme.md)
