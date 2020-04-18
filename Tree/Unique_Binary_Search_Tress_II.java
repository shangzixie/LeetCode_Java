package LeetCode_Java.Tree;


/*
    1. choose every number as root
    2. helper -> list of left BST
              -> list of right BST
    3. list of BSTs
    4. add into results
 */


import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Tress_II {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static List<TreeNode> generateTrees(int n) {

        return helper(1, n);
    }

    public static List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;

        }

        for (int i = start; i <= end; i++){
            List<TreeNode> leftList = helper(start, i-1);
            List<TreeNode> rightList = helper(i+1, end);

            for (TreeNode leftNode : leftList){
                for (TreeNode rightNode : rightList){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        generateTrees(3);
    }


}
