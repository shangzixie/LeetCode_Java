package LeetCode_Java.Tree.Binary_Search_Tree_Iterator;



import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Binary_Search_Tree_Iterator {

    //LeetCode_Java.buildinClass.TreeNode
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    LinkedList<TreeNode> stack;


    public Binary_Search_Tree_Iterator(TreeNode root) {
        stack = new LinkedList<>();
        while (root != null){
            stack.add(root);
            root = root.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode node = stack.removeLast();

        TreeNode nodeRight = node.right;
        while(nodeRight != null){
            stack.add(nodeRight);
            nodeRight = nodeRight.left;
        }

        return node;
    }
}
