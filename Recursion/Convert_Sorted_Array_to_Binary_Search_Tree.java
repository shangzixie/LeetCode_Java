package LeetCode_Java.Recursion;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode convertSortedArrayToBinarySearchTree(int[] nums) {
        List<Integer> nums1 = new LinkedList<>();
        for (int num: nums){
            nums1.add(num);
        }
        return dfs(nums1);
    }

    private TreeNode dfs(List<Integer> nums){
        if (nums.size() == 0) return null;

        int mid = (nums.size() -1) / 2 ;
        TreeNode root = new TreeNode(nums.get(mid));

        root.left = dfs(nums.subList(0, nums.size()-1));
        root.right = dfs(nums.subList(mid+1, nums.size()-1));

        return root;
    }



}
