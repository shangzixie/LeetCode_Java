package LeetCode_Java.Tree.Populating_Next_Right_Pointers_in_Each_Node_II;

public class Populating_Next_Right_Pointers_in_Each_Node_II {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


    public Node connect(Node root) {
        Node now = root;
        Node nextLevelCur = null;
        Node nextLevelHead = null;
        while (now != null){
            if (now.left != null ){
                if (nextLevelHead == null){
                    nextLevelHead = now.left;
                    nextLevelCur = now.left;
                }else{
                    nextLevelCur.next = now.left;
                    nextLevelCur = nextLevelCur.next;
                }
            }

            if (now.right != null){
                if (nextLevelHead == null){
                    nextLevelHead = now.right;
                    nextLevelCur = now.right;
                }else{
                    nextLevelCur.next = now.right;
                    nextLevelCur = nextLevelCur.next;
                }
            }
            now = now.next;
            if (now == null){ // cur level has finished traversing
                now = nextLevelHead; // move to next level
                nextLevelHead = null;
                nextLevelCur = null;
            }


        }
        return root;
    }
}
