# [LeetCode 897. Increasing Order Search Tree](https://leetcode-cn.com/problems/increasing-order-search-tree/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: DFS
* `Key Points`:
* `Algorithm`:

please read slides to understand it

### Code1

* `Code Design`:

```python
class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        self.dummyNode = TreeNode(0)
        self.lastNode = self.dummyNode
        self.dfs(root)

        return self.dummyNode.right

    def dfs(self, node):
        if node is None:
            return
        self.dfs(node.left)

        self.lastNode.right = node
        node.left = None
        self.lastNode = node
        self.dfs(node.right)

```

## Reference1

[leetcode ans slides](https://leetcode-cn.com/problems/increasing-order-search-tree/solution/di-zeng-shun-xu-cha-zhao-shu-by-leetcode-dfrr/)