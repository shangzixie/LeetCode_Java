# 437. Path Sum III

[LeetCode 437](https://leetcode.com/problems/path-sum-iii/)

## Methods

### Method 1 -- prefix sum + dfs -- just use dfs once

* `Time Complexity`: O(n)
* `Intuition`:
* `Key Points`: backtracking is important, because some `prefix sum` isn't some nodes' path, need be cut 
* `Algorithm`: The idea is similar as [Maximum Subarray](../../Prefix_Sum/Maximum_Subarray), using HashMap to store ( key : the prefix sum, value : how many ways get to this prefix sum) , and whenever reach a node, we check if `prefix sum - target` exists in hashmap or not, if it does, we added up the ways of `prefix sum - target` into res.
For instance : in one path we have 1,2,-1,-1,2, then the prefix sum will be: 1, 3, 2, 1, 3, let's say we want to find target sum is 2, then we will have{2}, {1,2,-1}, {2,-1,-1,2} and {2}ways.

### Code

* `Code Design`:

```java

class Solution {
    int ans;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, sum, 0, map);
    }
    private int dfs(TreeNode root, int sum, int pathSumFromRoot, HashMap<Integer, Integer> map) {
        if (root == null) return 0;

        // update the map
        pathSumFromRoot += root.val;
        int count = map.getOrDefault(pathSumFromRoot, 0);
        map.put(pathSumFromRoot, count + 1);
        // recursion
        int left = dfs(root.left, sum, pathSumFromRoot, map);
        int right = dfs(root.right, sum, pathSumFromRoot, map);
        // back tracking
        map.put(pathSumFromRoot, map.get(pathSumFromRoot) - 1);

        return left + right + map.getOrDefault(pathSumFromRoot - sum, 0);
    }
}
```

### Method 2 -- double DFS -- not the best method

* `Time Complexity`:
* `Intuition`: DFS
* `Key Points`:
* `Algorithm`:
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