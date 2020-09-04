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
* `Code Design`: 
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


## Reference