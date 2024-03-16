# [LeetCode 103. Binary Tree Zigzag Level Order Traversal](https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/)

## Methods

### Method 1

* `Time Complexity`: 大于O(n)
* `Space Complexity`:
* `Intuition`: brute force: BFS + reverse
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

```python
class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return None
        level = []
        queue = [root]
        ans = []
        while len(queue) > 0:
            for _ in range(len(queue)):
                node = queue.pop(0)
                level.append(node.val)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            print(level)
            if len(ans) % 2 == 0:
                ans.append(level)
            else:
                ans.append(level[::-1])
            level = []
        return ans
```

## Reference1

----------------------

### Method 2

* `Time Complexity`: O(n)
* `Space Complexity`:
* `Intuition`:
* `Key Points`: bfs + deque
* `Algorithm`:

every level, check it's odd or even, then append the item into `level` list from left or right

### Code2

* `Code Design`:

```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return None
        level = deque()
        queue = [root]
        ans = []
        fromLeft = True
        while len(queue) > 0:
            for _ in range(len(queue)):
                node = queue.pop(0)
                if len(ans) % 2 == 0:
                    level.append(node.val)
                else:
                    level.appendleft(node.val)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            ans.append(level)
            level = deque()
        return ans
```

## Reference2

[LeetCode Solution](https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/)