# [LeetCode 173. Binary Search Tree Iterator](https://leetcode.cn/problems/binary-search-tree-iterator/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

BST通过Stack遍历的改变版本

### Code1

* `Code Design`:

```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        cur = root
        while cur:
            self.stack.append(cur)
            cur = cur.left
    def next(self):
        """
        :rtype: int
        """
        ans = None
        if len(self.stack) > 0:
            cur = self.stack.pop()
            ans = cur
            cur = cur.right
            while cur:
                self.stack.append(cur)
                cur = cur.left
        return ans.val

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
```

## Reference1


