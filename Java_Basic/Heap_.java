package LeetCode_Java.Java_Basic;

import java.util.PriorityQueue;

public class Heap_ {
    public static void main(String[] args) {
        /*
        add()
        poll--pop min or max value (depends on min-heap or max-heap)
        peek
         */
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //lambda 
        heap.add(1);
        heap.add(3);
        heap.add(3);
        heap.add(3);
        heap.add(4);
        heap.add(2);

        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }

}
