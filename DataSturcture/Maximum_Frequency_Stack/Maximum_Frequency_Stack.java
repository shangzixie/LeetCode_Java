package DataSturcture.Maximum_Frequency_Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Maximum_Frequency_Stack {
    Map<Integer, Integer> map;
    PriorityQueue<int[]> heap;
    int index = 0;

    public Maximum_Frequency_Stack() {
        map = new HashMap<>();
        heap = new PriorityQueue<>((int[] a, int[] b) ->(a[1] != b[1] ? b[1] - a[1] : b[2] - a[2]));
    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        heap.add(new int[]{x, map.get(x), ++index});
    }

    public int pop() {
        int x = heap.poll()[0];
        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0) map.remove(x);
        return x;
    }
}
