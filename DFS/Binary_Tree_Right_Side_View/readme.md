# [LeetCode 199. Binary Tree Right Side View](https://leetcode-cn.com/problems/binary-tree-right-side-view/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: DFS. 如何保证结果为每层右边的一个节点呢? -> 右边 && 当前层第一个节点 -> 先遍历右节点 && level记录当前层 && 当前层没有其他节点在结果里面
* `Key Points`: DFS + 优先遍历右节点
* `Algorithm`:

### Code1

* `Code Design`:

```python

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.ans = []
        self.dfs(root, 1)
        return self.ans

    def dfs(self, node, level):
        if node is None:
            return
        if level > len(self.ans):
            self.ans.append(node.val)
        self.dfs(node.right, level + 1)
        self.dfs(node.left, level + 1)
```

## Reference1
