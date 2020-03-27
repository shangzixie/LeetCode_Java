package LeetCode_Java.Recursion;



public class Symmetric_Tree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

////////////////////////////////////////////////////////////
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right ;
        if (left.val != right.val) return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
