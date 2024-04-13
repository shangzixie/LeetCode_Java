# [LeetCode 510. Inorder Successor in BST II](https://leetcode.cn/problems/inorder-successor-in-bst-ii/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

相当于一个数组起始位置为p, 然后找比p大的那个后继节点. 但是数组中比p大的后继节点一定在p的右边, 而在bst中并不一定. 这时候我们就要分类讨论了:

声明两个定义:

后继 = "后节点"，即在中序遍历中的下一个节点， 或者是当前节点的下一个最小的节点。

前驱 = "前节点"，即在中序遍历中的上一个节点， 或者是当前节点的上一个最大的节点。

情况1:

![147](/Image/147.png)

情况2:

![148](/Image/148.png)
怎么理解情况2呢? 要找比p节点大的后继节点, 没有右子树的情况, 那就要向上找. 向上一层, 分两种情况:

![149](/Image/149.png)

### Code1

* `Code Design`:

```python

class Solution(object):
    def inorderSuccessor(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        if node.right:
            node = node.right
            while node.left:
                node = node.left
            return node

        while node and node.parent:
            if node.parent.left == node:
                return node.parent
            node = node.parent
        return None
```

## Reference1
