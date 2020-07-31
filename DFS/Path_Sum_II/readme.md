# 113. Path Sum II

[LeetCode 113](https://leetcode.com/problems/path-sum-ii/)


## Methods

### Method 1
* `Time Complexity`: 
* `Intuition`: dfs
* `Key Points`: Leaf Node is the node that doesn's have any child. 
So `tree: [1]`, root is leaf node, the path could be `1`. But `tree [1,2]`, root isn't leaf node， path must be `1,2`.
* `Algorithm`: 


### Code
* `Code Design`: 
```java
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        if (root == null) return ans;

        dfs(root, sum, new ArrayList<>());
        return ans;
    }
    private void dfs(TreeNode root, int sum, List<Integer> path) {
        if (root.left == null && root.right == null) { // current node is leaf node 
            if (sum - root.val == 0) {
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1); // in leaf node if return, need to remove the last element
                return;
            }
            return;
        }

        if (root.left != null) {
            path.add(root.val);
            dfs(root.left, sum - root.val, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.val);
            dfs(root.right, sum - root.val, path);
            path.remove(path.size() - 1);
        }
        return;
    }
}

```


## Reference