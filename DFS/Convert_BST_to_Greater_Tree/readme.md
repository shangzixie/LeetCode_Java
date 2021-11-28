# [LeetCode 538. Convert BST to Greater Tree](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: DFS
* `Key Points`: 第一遍dfs, 拿到所有节点的和; 第二遍dfs, `当前node的值 = 所有节点的和 - 当前节点之前中序遍历的所有节点的和`
* `Algorithm`:

### Code1

* `Code Design`:

```python

class Solution:
    def convertBST(self, root: TreeNode) -> TreeNode:
        self.totalSum = 0
        self.pathSum = 0
        self.dfs(root)
        self.changeTree(root)

        return root

    def dfs(self, node):
        if node is None:
            return

        self.dfs(node.left)
        self.totalSum += node.val
        self.dfs(node.right)

    def changeTree(self, node):
        if node is None:
            return

        self.changeTree(node.left)

        oldValue = node.val
        node.val = self.totalSum - self.pathSum
        self.pathSum += oldValue

        self.changeTree(node.right)

```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: 反中序遍历
* `Key Points`:
* `Algorithm`:

本题中要求我们将每个节点的值修改为原来的节点值加上所有大于它的节点值之和。这样我们只需要反序中序遍历该二叉搜索树，记录过程中的节点值之和，并不断更新当前遍历到的节点的节点值，即可得到题目要求的累加树。

### Code2

* `Code Design`:

```python
class Solution:
    def convertBST(self, root: TreeNode) -> TreeNode:
        self.totalSum = 0
        self.dfs(root)

        return root

    def dfs(self, node):
        if node is None:
            return

        self.dfs(node.right)
        self.totalSum += node.val
        node.val = self.totalSum
        self.dfs(node.left)
```

## Reference2
