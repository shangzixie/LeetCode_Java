# [LeetCode 199. Binary Tree Right Side View](https://leetcode-cn.com/problems/binary-tree-right-side-view/)

## Methods

### Method 1

* `Time Complexity`: O(N)，每个节点都入队出队了 1 次。
* `Intuition`: BFS
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```javascript
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
    if (!root) return [];
    const results = [];
    const queue = [root];

    while (queue.length > 0) {
        // 其实可以考虑不用level
        const level = [];
        const len = queue.length;
        for (let i = 0; i < len; i++) {
            const node = queue.shift();
            level.push(node);
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        results.push(level.pop().val);
    }

    return results;
};

// 不用level

var rightSideView = function(root) {
    if (!root) return [];
    const results = [];
    const queue = [root];

    while (queue.length > 0) {
        const len = queue.length;
        for (let i = 0; i < len; i++) {
            const node = queue.shift();
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
            if (i === len - 1) results.push(node.val);
        }
    }

    return results;
};
```

### Method 2

* `Time Complexity`: O(N)
* `Intuition`: dfs
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```javascript
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
const results = [];

var rightSideView = function(root) {
    dfs(root, 0);
    return results;
};

var dfs = function(root, depth) {
    if (!root) return;

    if (depth === results.length) results.push(root.val);
    dfs(root.right, depth + 1);
    dfs(root.left, depth + 1);
}
```

## Reference
