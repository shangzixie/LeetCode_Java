package LeetCode_Java.Tricky.Sliding_Window_Maximum;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        while (!list.isEmpty()){
            System.out.println(list.pop());
        }

    }

}
