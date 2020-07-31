package buildinClass;
import LeetCode_Java.buildinClass.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, sum, 0);
    }
    private boolean dfs(TreeNode root, int sum, int pathSum) {
        if (root.left == null && root.right == null) {
            if (pathSum + root.val == sum) return true;
            return false;
        }

        boolean left = false, right = false;
        if (root.left != null) left = dfs(root.left, sum, pathSum + root.val);
        if (root.right != null) right = dfs(root.right, sum, pathSum + root.val);

        return (left || right);
    }
}
