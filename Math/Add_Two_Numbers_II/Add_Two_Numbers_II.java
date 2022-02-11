package LeetCode_Java.Math.Add_Two_Numbers_II;

import java.util.LinkedList;

public class Add_Two_Numbers_II {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            next = null;
        }
    }

    /*

    Solution1:
    convert l1 and l2 to number and add them, then convert them to linkedlist

    bug;
    if number is huge, long or double cannot ac
    */
    public ListNode addLists(ListNode l1, ListNode l2) {

        // convert l1 and l2 to long
        double num1 = convert(l1);
        double num2 = convert(l2);
        String sum = String.valueOf(num1 + num2);


        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int i = 0; i < sum.length(); i++){
            tail.next = new ListNode(Integer.valueOf(sum.charAt(i)) - 48);
            tail = tail.next;
        }
        return dummy.next;

    }

    private double convert(ListNode head){
        int digits = -1;
        ListNode tail = head;
        while (tail != null){
            digits += 1;
            tail = tail.next;
        }

        tail = head;
        double num = 0;
        while (tail != null){
            num = num + tail.val * Math.pow(10, digits);
            tail = tail.next;
            digits -= 1;
        }
        return num;
    }
//----------------------------------------------------------------------------//
    /*
    Solution2: the best solution
        three stack
    */

    public ListNode addLists2(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        LinkedList<Integer> stack3 = new LinkedList<>();

        //push into stack
        while (l1 != null){
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.add(l2.val);
            l2 = l2.next;
        }

        //add and push into stack3
        int num = 0;
        int carry = 0;
        while( !stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            num = carry;
            if (!stack1.isEmpty()){
                num += stack1.removeLast();
            }
            if (!stack2.isEmpty()){
                num += stack2.removeLast();
            }

            carry = num / 10;
            stack3.add(num % 10);
        }


        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!stack3.isEmpty()){
            tail.next = new ListNode(stack3.removeLast());
            tail = tail.next;
        }
        return dummy.next;
    }

}
