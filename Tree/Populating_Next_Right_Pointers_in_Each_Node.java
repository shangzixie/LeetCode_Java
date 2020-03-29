package LeetCode_Java.Tree;




public class Populating_Next_Right_Pointers_in_Each_Node {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public void connect(Node root) {
        Node levelStart = root;
        while (levelStart != null){
            Node curNode = levelStart;
            while (curNode != null){
                if (curNode.left != null) curNode.left.next = curNode.right;
                if (curNode.right != null && curNode.next != null) curNode.right.next = curNode.next.left;
                curNode = curNode.next;
            }
            levelStart = levelStart.left;

        }
    }
}
