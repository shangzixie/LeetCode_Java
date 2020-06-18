package Java_Basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Deque_ {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(1); // == add
        deque.addFirst(2);
        deque.add(3);
        System.out.println(Arrays.toString(deque.toArray()));
        deque.removeLast();
        deque.removeFirst();
        deque.getFirst();
        deque.getLast();

    }
}
