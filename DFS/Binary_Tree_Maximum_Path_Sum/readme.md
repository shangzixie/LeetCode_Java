# [LeetCode 124. Binary Tree Maximum Path Sum](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

到达当前`node`的路径和一定要经过当前的`node`. 为了保证这个条件, 每次都要让`left`和`right`的递归返回的和都要带有当前`node`

### Code1

* `Code Design`:

```python

class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.maxSum = -sys.maxsize - 1
        self.dfs(root)
        return self.maxSum

    def dfs(self, node):
        if node is None:
            return 0

        left = max(self.dfs(node.left), 0) # 左子树提供的最大路径和, 该和一定包含该层node的左儿子, 负数直接舍弃,不要了
        right = max(self.dfs(node.right), 0) # 右子树提供的最大路径和, 该和一定包含该层node的右儿子
        self.maxSum = max(self.maxSum, node.val + left + right) # 挑战最大纪录

        # 返回的值只跟当前node有关
        maxPathSum = max(left, right) + node.val
        return maxPathSum
```

## Reference1
