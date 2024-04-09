# [LeetCode https://www.youtube.com/watch?v=670Gn4e89B8](https://leetcode.cn/problems/is-graph-bipartite/description/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`:
* `Intuition`: BFS
* `Key Points`:
* `Algorithm`:

we set 2 groups, for begin nodes, we set them to group 1, and then we set their neighbors to group 2, and then we set their neighbors to group 1, and so on.
If we find a node that is at other group, we return False.

### Code1

* `Code Design`:

```python
class Solution(object):
    def isBipartite(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: bool
        """
        visited = [0] * len(graph) # 0 means not visited, 1 means at group1, 2 means at group2

        for i in range(len(graph)):
            if visited[i] != 0:
                continue
            queue = deque([i])
            neiborhoods = graph[i]
            visited[i] = 1 # the 1st node is marked as 1
            while len(queue) > 0:
                cur = queue.popleft()
                neiborhoodGroup = 2 if visited[cur] == 1 else 1
                neiborhoods = graph[cur]
                for j in neiborhoods:
                    if visited[j] == 0:
                        visited[j] = neiborhoodGroup
                        queue.append(j)
                    elif visited[j] != neiborhoodGroup:
                        return False
        return True
```

## Reference1

[Youtube](https://www.youtube.com/watch?v=670Gn4e89B8)