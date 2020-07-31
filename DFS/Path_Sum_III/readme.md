# 437. Path Sum III

[LeetCode 437](https://leetcode.com/problems/path-sum-iii/)


## Methods
### Method 1
* `Time Complexity`: 
* `Intuition`: DFS
* `Key Points`: 
    * traverse the whole tree, every node as start node to use dfs to find the path. So nest a dfs with another dfs
    * the most important point is if code blow 
    ```
    if (node == null) {
        if (sum == 0) ans++;
        reutrn
    }
    ``` 
    It will count twice when leaf node is the end node. Besides, it is hard to  circumvent this problem when modify `if condition`.
    so on every node, we process `sum` first, then dfs. Instead of using `dfs(sum - root.val)`;  
* `Algorithm`: 


### Code
* `Code Design`: 
```java
class Solution {
    int ans;
    public int pathSum(TreeNode root, int sum) {
        ans = 0;
        if (root == null) return ans;
        // traverse every node, and set it as start node
        beginFromAnyNode(root, sum);
        return ans;
    }
    // traverse the whole tree
    private void beginFromAnyNode(TreeNode root, int sum) {
        if (root == null) return;

        // current node as start node
        findPath(root, sum);
        beginFromAnyNode(root.left, sum);
        beginFromAnyNode(root.right, sum);
    }
    
    // for every tree node, think of it as the beginning
    private void findPath(TreeNode root, int sum) {
        if (root == null) return;
        
        // process sum first
        sum -= root.val; 
        if (sum == 0) ans++;
        // then traverse 
        findPath(root.left, sum);
        findPath(root.right, sum);
    }

}

```


## Reference