package Java_Basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Deque_ {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(1);  // [1]
        deque.addFirst(2); // [2,1]
        deque.add(3);        //[2,1,3]
        System.out.println(Arrays.toString(deque.toArray()));
        deque.removeLast();
        deque.removeFirst();
        deque.getFirst();
        deque.getLast();

    }
}
