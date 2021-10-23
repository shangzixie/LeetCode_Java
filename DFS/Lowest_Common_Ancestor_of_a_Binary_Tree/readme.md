# [LeetCode 236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

## Methods

### Method 1

* `Time Complexity`:
* `Intuition`: 分治法
* `Key Points`: 要考虑如果这两个数`p`,`q` 其中一个是答案common ancestor怎么办
* `Algorithm`:

针对上述`key point`, 如果在某一层`curNode`中, 只拿到了left节点, 而right节点为空. 此时`q`找不到, 说明`q`在`p`的子节点中, 这时候只能拿到一个p节点, 就是想要的答案; 直接返回它

### Code

* `Code Design`:

```javascript
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    return dfs(root, p, q);
};

var dfs = function(root, p, q) {
    if (!root) return null;
    if (root.val === p.val) return p;
    if (root.val === q.val) return q;

    const left = dfs(root.left, p, q);
    const right = dfs(root.right, p, q);

    if (left && right) return root;
    if (left) return left;
    if (right) return right;

    return null;
}

```

## Reference
