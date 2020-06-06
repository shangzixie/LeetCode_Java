package LeetCode_Java.Java_Basic;

import java.util.LinkedList;
import java.util.Stack;

public class Stack_ {
    public static void main(String[] args) {
        /*
        peek()
        add()
        pop()
        isEmpty()
         */
        Stack<Integer> stack = new Stack<>();
        stack.add(3);
        stack.add(2);
        stack.add(1);
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            System.out.println(stack.pop());
        }

        LinkedList<Integer> stackLinkedList = new LinkedList<>();
        stackLinkedList.add(3);
        stackLinkedList.add(2);
        stackLinkedList.add(1);
        while(!stackLinkedList.isEmpty()){
            System.out.println(stackLinkedList.removeLast()); //不能用pop，因为linkedlist的pop是首位
        }
    }
}
