package LeetCode_Java.DFS.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;


import LeetCode_Java.buildinClass.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {




    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, 0, inorder.length -1, map);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int rootIndex, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (rootIndex >= preorder.length || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[rootIndex]);
        int rootIndexInInorder = map.get(preorder[rootIndex]);


        root.left = dfs(preorder, inorder, rootIndex + 1, inStart, rootIndexInInorder-1, map);

        root.right = dfs(preorder, inorder, rootIndex + rootIndexInInorder - inStart + 1, rootIndexInInorder +1, inEnd, map);

        return root;

    }
    //----------------------optimize--------------------------
    int rootIndex1 = 0;
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper1(map, preorder, inorder, 0, inorder.length);
    }
    private TreeNode helper1(Map<Integer, Integer> map, int[] preorder, int[] inorder, int inStart, int inEnd){
        if (inStart > inEnd || rootIndex1 >= preorder.length) return null;


        TreeNode root = new TreeNode(preorder[rootIndex1]);

        rootIndex1++;

        int rootIndexInInOrder1 = map.get(root.val);
        root.left = helper1(map, preorder, inorder, inStart, map.get(root.val) - 1);
        root.right = helper1(map, preorder, inorder, rootIndexInInOrder1 + 1, inEnd);

        return root;
    }
}
