package LeetCode_Java.Tree;



import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II {

    class TreeNode{
        public int val;
        public TreeNode left, right;
        TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }

    }


    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        helper(root, sum, path);
        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> path){
        if (root == null) return;
        if (root.left == null && root.right == null && sum == root.val){
            path.add(root.val);
            result.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }


        path.add(root.val);
        helper(root.left, sum - root.val, path);
        helper(root.right, sum- root.val, path);
        path.remove(path.size() -1 );
    }
}
