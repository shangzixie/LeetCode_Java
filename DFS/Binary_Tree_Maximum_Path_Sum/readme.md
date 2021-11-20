# [LeetCode 124. Binary Tree Maximum Path Sum](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

到达当前`node`的路径和一定要经过当前的`node`. 为了保证这个条件, 每次都要让`left`和`right`的递归返回的和都要带有当前`node`

### Code1

* `Code Design`:

```javascript
let maxSum = Number.MIN_SAFE_INTEGER;

const maxPathSum = (root) => {
    maxSum = Number.MIN_SAFE_INTEGER; // 最大路径和

    dfs(root);  // 递归的入口

    return maxSum;
};

const dfs = (root) => {
    if (root == null) { // 遍历到null节点，收益0
        return 0;
    }
    const left = dfs(root.left);   // 左子树提供的最大路径和
    const right = dfs(root.right); // 右子树提供的最大路径和

    const innerMaxSum = left + root.val + right; // 当前子树内部的最大路径和
    maxSum = Math.max(maxSum, innerMaxSum);      // 挑战最大纪录

    // 返回的值只跟当前node有关
    const outputMaxSum = root.val + Math.max(0, left, right); // 当前子树对外提供的最大和
    // 如果对外提供的路径和为负，直接返回0。否则正常返回
    return outputMaxSum < 0 ? 0 : outputMaxSum;
};

```

## Reference1
