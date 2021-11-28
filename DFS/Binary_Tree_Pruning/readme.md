# [LeetCode 814. Binary Tree Pruning](https://leetcode-cn.com/problems/binary-tree-pruning/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: DFS
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

```python
class Solution:
    def pruneTree(self, root: TreeNode) -> TreeNode:
        ans = self.dfs(root)
        return None if ans else root

    def dfs(self, node):
        if node is None:
            return True

        left = self.dfs(node.left)
        right = self.dfs(node.right)

        if left and node.left:
            node.left = None
        if right and node.right:
            node.right = None
        if left and right and node.val == 0:
            return True
        return False
```

## Reference1
