# [LeetCode 99. Recover Binary Search Tree](https://leetcode.cn/problems/recover-binary-search-tree/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

我们需要考虑两个节点被错误地交换后对原二叉搜索树造成了什么影响。对于二叉搜索树，我们知道如果对其进行中序遍历，得到的值序列是递增有序的，而如果我们错误地交换了两个节点，等价于在这个值序列中交换了两个值，破坏了值序列的递增性。我们来看下如果在一个递增的序列中交换两个值会造成什么影响。假设有一个递增序列 `a=[1,2,3,4,5,6,7]`。如果我们交换两个不相邻的数字，例如 `2` 和 `6`，原序列变成了 `a=[1,6,3,4,5,2,7]`, 对于`2`和`6`, 出现了一个波峰和一个波谷, 也就是波峰:`1 < 6 > 3`, 波谷`5 > 2 < 7`. 但是因为是非递减序列, 所以`6`大于`1`和`7`大于`2`是合理的. 所以不合理的地方是`6 > 3`, 波谷`5 > 2`, 假设被置换的下标是`i`和`j`, 则一个是a<sub>i</sub> > a<sub>i + 1</sub>, 另一个是a<sub>j - 1</sub> > a<sub>j</sub>. 所以我们只需要找到这两个点, 然后交换即可.

如果我们交换两个相邻的数字，例如 `1` 和 `3`，此时交换后的序列只有一个位置不满足 a<sub>i</sub> < a<sub>i+1</sub>。因此整个值序列中不满足条件的位置或者有两个，或者有一个。

### Code1

* `Code Design`:

```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        self.lastNode = None
        self.p, self.q = None, None
        self.dfs(root)
        self.p.val, self.q.val = self.q.val, self.p.val
        return None
    def dfs(self, root):
        if root is None:
            return
        self.dfs(root.left)
        if self.lastNode and self.lastNode.val > root.val:
            if self.p is None:
                self.p = self.lastNode
                # 当相邻时候
                self.q = root
            else:
                self.q = root
        else:
            self.lastNode = root
        self.dfs(root.right)
```

## Reference1

[Youtube](https://www.youtube.com/watch?v=sDQhHZJkNh0)