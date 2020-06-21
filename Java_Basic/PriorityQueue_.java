package Java_Basic;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueue_ {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //增
        heap.add(1);
        heap.add(2);
        heap.add(3);

        //删
        heap.remove(1);// remove exact element
        heap.poll();

        System.out.println(heap);
    }
}
