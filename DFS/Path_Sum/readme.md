# 112. Path Sum

[LeetCode 112](https://leetcode.com/problems/path-sum/)


## Methods

### Method 1

* `Time Complexity`:
* `Intuition`:
* `Key Points`: Leaf Node is the node that doesn's have any child.
So `tree: [1]`, root is leaf node, the path could be `1`. But `tree [1,2]`, root isn't leaf node， path must be `1,2`.

* `Algorithm`:


### Code

`Code Design`:

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, sum, 0);
    }
    private boolean dfs(TreeNode root, int sum, int pathSum) {
        if (root.left == null && root.right == null) { //current is leaf node
            if (pathSum + root.val == sum) return true;
            return false;
        }

        boolean left = false, right = false;
        if (root.left != null) left = dfs(root.left, sum, pathSum + root.val);
        if (root.right != null) right = dfs(root.right, sum, pathSum + root.val);

        return (left || right);
    }
}

```

### Method 2

* `Time Complexity`:
* `Intuition`: bfs
* `Key Points`:
* `Algorithm`:


### Code

`Code Design`:

```javascript
var hasPathSum = function(root, targetSum) {
  if (!root) return false;

  const queue = [[root, root.val]];
  while (queue.length) {
    const [node, pathSum] = queue.shift();
    if (!node.left && !node.right && pathSum === targetSum) return true;
    if (node.left) queue.push([node.left, node.left.val + pathSum]);
    if (node.right) queue.push([node.right, node.right.val + pathSum]);
  }

  return false;
};
```

## Reference