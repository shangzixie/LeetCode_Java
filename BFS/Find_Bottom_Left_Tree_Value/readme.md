# [LeetCode 513. Find Bottom Left Tree Value](https://leetcode-cn.com/problems/find-bottom-left-tree-value/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`: O(n)
* `Intuition`: BFS
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

```python
class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        queue = collections.deque()
        queue.append(root)
        ans = root
        while len(queue) > 0:
            curLevelCount = len(queue)
            for i in range(curLevelCount):
                node = queue.popleft()
                if i == 0:
                    ans = node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return ans

```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: DFS
* `Key Points`:
* `Algorithm`:

### Code2

* `Code Design`:

```python
class Solution:
    def findBottomLeftValue(self, root: TreeNode) -> int:
        max_depth = -float("INF")
        leftmost_val = 0

        def __traverse(root, cur_depth): 
            nonlocal max_depth, leftmost_val
            if not root.left and not root.right: 
                if cur_depth > max_depth: 
                    max_depth = cur_depth
                    leftmost_val = root.val  
            if root.left: 
                cur_depth += 1
                __traverse(root.left, cur_depth)
                cur_depth -= 1
            if root.right: 
                cur_depth += 1
                __traverse(root.right, cur_depth)
                cur_depth -= 1

        __traverse(root, 0)
        return leftmost_val

```

## Reference2
