# [LeetCode 261. Graph Valid Tree](https://leetcode.cn/problems/graph-valid-tree/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

![168](/Image/168.png)

根据树的特点: n个节点一定有n-1个边. 但是n个节点n-1个边不一定就是树:

![169](/Image/169.png)

所以我们通过以下代码只能排除图中:

情况4, 边数过多的图（有环的图）; 情况2, 边数过少的图（非连通图或孤立点）

```python
if len(edges) != n - 1:
    return False
```

其他情况, 我们通过bfs来遍历, 当我们遍历完发现所有的节点都访问过一遍了, 就排除图中第三种情况.
BFS作用是, 每个节点只访问一遍, 遍数就是`len(seen)`. 那么这个`遍数`应该就等于`n`如果是tree

### Code1

* `Code Design`:

```python
class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n - 1:
            return False

        adj_list = [[] for _ in range(n)]
        for A, B in edges:
            adj_list[A].append(B)
            adj_list[B].append(A)

        seen = {0}
        queue = collections.deque([0])
        while queue:
            node = queue.popleft()
            for neighbour in adj_list[node]:
                if neighbour in seen:
                    continue
                seen.add(neighbour)
                queue.append(neighbour)
        return len(seen) == n
```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

用并查集Union Find. 

Union Find

### Code2

* `Code Design`:

```java


```

## Reference2
