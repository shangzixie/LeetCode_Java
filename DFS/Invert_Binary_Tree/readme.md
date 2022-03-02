# [LeetCode 226. Invert Binary Tree](https://leetcode-cn.com/problems/invert-binary-tree/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

注意该二叉树会有空的场景

### Code1

* `Code Design`:

```python
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        self.dfs(root)
        return root

    def dfs(self, root):
        if root is None:
            return

        left = self.dfs(root.left)
        right = self.dfs(root.right)
        root.left, root.right = right, left
        return root
```