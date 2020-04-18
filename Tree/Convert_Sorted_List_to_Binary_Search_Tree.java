package LeetCode_Java.Tree;


public class Convert_Sorted_List_to_Binary_Search_Tree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head);
    }


    public TreeNode dfs(ListNode start){
        if (start == null) return null;
        if (start.next == null) return new TreeNode(start.val);


        //build root
        ListNode preMid = findMiddle(start);
        ListNode mid = preMid.next;

        TreeNode root = new TreeNode(mid.val);

        // cut the tail
        preMid.next = null;

        //dfs
        root.left = dfs(start);
        root.right = dfs(mid.next);

        return root;

    }



    // find Middle
    public ListNode findMiddle(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
