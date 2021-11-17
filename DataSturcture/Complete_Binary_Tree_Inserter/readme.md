# [LeetCode 919. Complete Binary Tree Inserter](https://leetcode-cn.com/problems/complete-binary-tree-inserter/)

## Methods

### Method 1

* `Time Complexity`: insert: O(1), init: O(n)
* `Space Complexity`:
* `Intuition`: bfs + array
* `Key Points`:
* `Algorithm`:

just like implement `heap`, using array to store treeNode
the 1st element in array is length of array

### Code1

* `Code Design`:

```python
class CBTInserter:

    def __init__(self, root: TreeNode):
        self.arr = [TreeNode(0)]
        self.bfs(root)

    def insert(self, v: int) -> int:
        insertedNode = TreeNode(v)
        self.arr.append(insertedNode)
        self.arr[0].val += 1
        insertedIndex = self.arr[0].val
        parent = self.arr[insertedIndex // 2]
        if insertedIndex % 2 == 0:
            parent.left = insertedNode
        else:
            parent.right = insertedNode
        return parent.val

    def get_root(self) -> TreeNode:
        return self.arr[1]

    def bfs(self, root) -> None:
        queue = [root]
        while len(queue) > 0:
            cur = queue.pop(0)
            self.arr.append(cur)
            self.arr[0].val += 1
            if cur.left:
                queue.append(cur.left)
            if cur.right:
                queue.append(cur.right)



```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code2

* `Code Design`:

```java


```

## Reference2
