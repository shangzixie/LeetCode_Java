package LeetCode_Java.Recursion;

import java.util.HashMap;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0;i < inorder.length ; i++){ map.put(inorder[i], i);}

        return dfs(inorder, postorder, postorder.length -1 , 0, inorder.length-1, map);
    }

    public TreeNode dfs(int[] inorder, int[] postorder, int rootIndexInPost, int inStart, int inEnd, HashMap<Integer,Integer> map){
        if (inStart > inEnd || rootIndexInPost < 0) return null;

        TreeNode root = new TreeNode(postorder[rootIndexInPost]);
        int rootIndexInInorder = map.get(postorder[rootIndexInPost]);

        root.left = dfs(inorder, postorder, rootIndexInPost - inEnd + rootIndexInInorder -1, inStart, rootIndexInInorder-1, map);
        root.right = dfs(inorder, postorder, rootIndexInPost - 1, rootIndexInInorder + 1, inEnd, map);

        return root;
    }
}
