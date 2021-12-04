# 133. Clone Graph

[LeetCode 133](https://leetcode.com/problems/clone-graph/)


## Methods

### Method 1

use `map` , key is oldNode, value is newNode.
BFS to traverse the graph and, then use `map` to clone `node` one by one.

### Code

```java
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;

        Set<Node> visited = new HashSet<>();
        Deque<Node> queue = new ArrayDeque<>();
        Map<Node, Node> map = new HashMap<>();

        //initial
        visited.add(node);
        queue.add(node);
        // bfs
        while (!queue.isEmpty()){
            Node curNode = queue.removeFirst();
            Node newNode = new Node(curNode.val);
            map.put(curNode, newNode);
            for (Node nei : curNode.neighbors){
                if (visited.contains(nei)) continue;
                queue.add(nei);
                visited.add(nei);
            }
        }

        //clone
        for (Node oldNode : map.keySet()){
            Node newNode = map.get(oldNode);
            for (Node oldNei : oldNode.neighbors){
                newNode.neighbors.add(map.get(oldNei));
            }
        }
        return map.get(node);
    }
}

```

### Method 2

use `map` , key is oldNode, value is newNode.
DFS to traverse the graph.

`map` has two features. 1. record new node and old node 2. as `visited`

### Code2

```java
class solution{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return dfs(map, node);
    }

    private UndirectedGraphNode dfs(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if (map.containsKey(node)) return map.get(node) ;

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(map, neighbor));
        }
        return newNode;
    }
}
```

## Reference