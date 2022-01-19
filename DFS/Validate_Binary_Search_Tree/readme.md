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

### Code2

* `Code Design`:

```java


```

## Reference2
