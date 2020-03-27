package LeetCode_Java.Recursion;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public class TreeNode{
         public int val;
         public TreeNode left, right;
         TreeNode(int val){
            this.val = val;
            this.left = this.right = null;
        }
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, 0, inorder.length -1, map);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (preStart >= preorder.length || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndexInInorder = map.get(preorder[preStart]);


        root.left = dfs(preorder, inorder, preStart + 1, inStart, rootIndexInInorder-1, map);

        root.right = dfs(preorder, inorder, preStart + rootIndexInInorder - inStart + 1, rootIndexInInorder +1, inEnd, map);

        return root;

    }
}
