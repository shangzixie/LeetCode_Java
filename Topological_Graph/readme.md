# topological graph

![143](/Image/143.png)
![144](/Image/144.png)

## BFS

```python
"""
Definition for a Directed graph node
class DirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []
"""

class Solution:
    """
    @param: graph: A list of Directed graph node
    @return: Any topological order for the given graph.
    """
    def topSort(self, graph):
        nodesToindegree = self.get_nodes_indegree(graph)
        # get nodes which in-degree is 0
        queue = []
        for node in graph:
            if nodesToindegree[node] == 0:
                queue.append(node)
        # bfs
        results = []
        while queue:
            node = queue.pop(0)
            results.append(node)
            for neighbor in node.neighbors:
                nodesToindegree[neighbor] -= 1
                if nodesToindegree[neighbor] == 0:
                    queue.append(neighbor)
        return results

    # calculate in-degree
    def get_nodes_indegree(self, graph):
        nodesToindegree = {x: 0 for x in graph}
        for node in graph:
            for neighbor in node.neighbors:
                nodesToindegree[neighbor] += 1
        return nodesToindegree
```

## DFS

```python
"""
Definition for a Directed graph node
class DirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []
"""

class Solution:
    """
    @param: graph: A list of Directed graph node
    @return: Any topological order for the given graph.
    """

    def topSort(self, graph):
        if not graph:
            return []

        self.visited = set()
        path = []

        for node in graph:
            if node in self.visited:
                continue
            self.helper(node, path)

        return path[::-1]

    def helper(self, node, path):
        for neighbor in node.neighbors:
            if neighbor in self.visited:
                continue
            self.helper(neighbor, path)

        self.visited.add(node)
        path.append(node)
```
