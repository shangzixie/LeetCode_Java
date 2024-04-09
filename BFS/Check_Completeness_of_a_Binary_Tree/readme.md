# [LeetCode 958. Check Completeness of a Binary Tree](https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: for a completeness tree, the right of a null node couldn't exists other non-none node at every level
* `Key Points`:
* `Algorithm`:

层序遍历的过程中遇到第一个空节点之后不应该再出现非空节点

Iterate by level, if there is a null node, it couldn't appear a non-node in future iterate. for example, the `2`'s right son is null, the non-node couldn't exists after the `7`. the `11` node must at the right of `2` node.

![161](/Image/161.png)

### Code1

* `Code Design`:

```python
class Solution(object):
    def isCompleteTree(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        queue = deque([root])
        reachEnd = False

        while queue:
            node = queue.popleft()
            if reachEnd and node is not None:
                return False
            if node is None:
                reachEnd = True
            else:
                queue.append(node.left)
                queue.append(node.right)

        return True
```

## Reference1

[LeetCode Solution](https://leetcode.cn/problems/check-completeness-of-a-binary-tree/solutions/614651/ceng-xu-bian-li-by-dian-dao-de-hu-die-681d/)