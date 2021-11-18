# [LeetCode 129. Sum Root to Leaf Numbers](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: DFS
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

```python
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        self.ans = 0
        self.dfs(root, 0)
        return self.ans

    def dfs(self, node, sum):
        if node.left is None and node.right is None:
            curSum = sum * 10 + node.val
            self.ans += curSum
            return

        curSum = sum * 10 + node.val
        if node.left: self.dfs(node.left, curSum)
        if node.right: self.dfs(node.right, curSum)

```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: BFS
* `Key Points`:
* `Algorithm`:

使用广度优先搜索，需要维护两个队列，分别存储节点和节点对应的数字。

初始时，将根节点和根节点的值分别加入两个队列。每次从两个队列分别取出一个节点和一个数字，进行如下操作：

如果当前节点是叶子节点，则将该节点对应的数字加到数字之和；

如果当前节点不是叶子节点，则获得当前节点的非空子节点，并根据当前节点对应的数字和子节点的值计算子节点对应的数字，然后将子节点和子节点对应的数字分别加入两个队列。

搜索结束后，即可得到所有叶子节点对应的数字之和。

### Code2

* `Code Design`:

```python

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0

        total = 0
        nodeQueue = collections.deque([root])
        numQueue = collections.deque([root.val])

        while nodeQueue:
            node = nodeQueue.popleft()
            num = numQueue.popleft()
            left, right = node.left, node.right
            if not left and not right:
                total += num
            else:
                if left:
                    nodeQueue.append(left)
                    numQueue.append(num * 10 + left.val)
                if right:
                    nodeQueue.append(right)
                    numQueue.append(num * 10 + right.val)

        return total
```

## Reference2

[leetcode ans](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/)