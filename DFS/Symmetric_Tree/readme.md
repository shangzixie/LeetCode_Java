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
* `Intuition`: queue + iterate
* `Key Points`: traverse tree symmetric, 具体参考 [对称遍历tree](../readme.md)
* `Algorithm`:

### Code2

* `Code Design`:

```python
class Solution(object):
def isSymmetric(self, root):
    """
    :type root: TreeNode
    :rtype: bool
    """
    if not root or not (root.left or root.right):
        return True
    # 用队列保存节点
    queue = [root.left,root.right]
    while queue:
        # 从队列中取出两个节点，再比较这两个节点
        left = queue.pop(0)
        right = queue.pop(0)
        # 如果两个节点都为空就继续循环，两者有一个为空就返回false
        if not (left or right):
            continue
        if not (left and right):
            return False
        if left.val!=right.val:
            return False
        # 将左节点的左孩子， 右节点的右孩子放入队列
        queue.append(left.left)
        queue.append(right.right)
        # 将左节点的右孩子，右节点的左孩子放入队列
        queue.append(left.right)
        queue.append(right.left)
    return True
```

## Reference2
