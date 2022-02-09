# [LeetCode 938. Range Sum of BST](https://leetcode-cn.com/problems/range-sum-of-bst/)

## Methods

### Method 1

* `Time Complexity`: O(n), n是节点个数
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:
遍历整个树找到对应的节点

### Code1

* `Code Design`:

```python
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if root is None:
            return 0

        left = self.rangeSumBST(root.left, low, high)
        right = self.rangeSumBST(root.right, low, high)
        if root.val >= low and root.val <= high:
            return root.val + left + right
        else:
            return left + right
```

## Reference1

----------------------

### Method 2

如果这道题不是求和, 而是改下题目, [具体题目](https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/):

给定一个范围`[low, high]`, 要求按照**升序**打印该范围内的所有节点. 应该怎么做?

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: 中序遍历
* `Key Points`:
* `Algorithm`:

**中序遍历**保证了升序, 只要在符合的范围内打印即可

### Code2

* `Code Design`:

```python
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if root is None:
            return

        self.rangeSumBST(root.left, low, high)
        if low <= root.val <= high:
            print(root.val)
        self.rangeSumBST(root.right, low, high)
```

如何剪枝优化?
给个例子:
```
          10
        /   \
       5    15
      / \  /  \
     2  7  11 20
                \
                25
low = 16, high = 20
```

```python
 class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if root is None:
            return
        # 中序遍历的dfs(node.left)就是为了找到起始点, 这里在找起始点的时候给了限定条件: 只有大于low时候才有必要向左遍历找起始点
        if root.val > low:
            self.rangeSumBST(root.left, low, high)
        if low <= root.val <= high:
            print(root.val)
        # 中序遍历的dfs(node.right)是为了从起始点开始,能顺利向右遍历
        if root.val < high:
            self.rangeSumBST(root.right, low, high)
```