# [LeetCode 199. Binary Tree Right Side View](https://leetcode-cn.com/problems/binary-tree-right-side-view/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: DFS
* `Key Points`:
* `Algorithm`:

右视图, 当然先遍历右边优先级更高

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

