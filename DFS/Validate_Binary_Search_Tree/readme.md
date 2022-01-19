# [LeetCode 98. Validate Binary Search Tree](https://leetcode-cn.com/problems/validate-binary-search-tree/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

中序遍历, 遍历节点递增才能说明是个BST.
但是要考虑, 下图:

![115](../../Image/115.png)

遍历到位置3时候, 我们要判断它是否比位置2处的数大, 这时候只能用一个变量记住该位置.
遍历到4位置时候同理, 要有变量记住位置3

### Code1

* `Code Design`:

```python
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        self.pre = float('-inf')
        return self.dfs(root)

    def dfs(self, root):
        if root is None:
            return True

        left = self.dfs(root.left)

        if root.val <= self.pre: return False
        self.pre = root.val

        right = self.dfs(root.right)
        return left and right
```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

use stack to iterate, and also needs to use `pre`

### Code2

* `Code Design`:

```python
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack = []
        node = root

        while node:
            stack.append(node)
            node = node.left
            prev = float('-inf')

        while stack:
            node = stack.pop()
            if node.val <= prev:
                return False
            prev = node.val
            if node.right:
                node1 = node.right
                while node1:
                    stack.append(node1)
                    node1 = node1.left
        return True
```

after optimized

```python
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack, prev = [], float('-inf')

        # 初始状态stack本来就是空
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            # 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if root.val <= prev:
                return False
            prev = root.val
            root = root.right

        return True
```

## Reference2
