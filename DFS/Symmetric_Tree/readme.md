# [LeetCode 101. Symmetric Tree](https://leetcode-cn.com/problems/symmetric-tree/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: dfs
* `Key Points`: traverse tree symmetric, 具体参考 [对称遍历tree](../readme.md)
* `Algorithm`:

### Code1

* `Code Design`:

```python
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.dfs(root, root)

    def dfs(self, p, q):
        if p is None and q is None:
            return True
        if p is None or q is None:
            return False

        left = self.dfs(p.left, q.right)
        right = self.dfs(p.right, q.left)
        return left and right and p.val == q.val
```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: stack + iterate
* `Key Points`:
* `Algorithm`:

### Code2

* `Code Design`:

```java


```

## Reference2
