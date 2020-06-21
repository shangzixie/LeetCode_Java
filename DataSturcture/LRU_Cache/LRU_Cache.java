package DataSturcture.LRU_Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRU_Cache {

    Map<Integer, int[]> map;
    PriorityQueue<int[]> heap;
    int size;
    int maxSize;

    public LRU_Cache(int capacity) {
        map = new HashMap<>();
        heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        size = 0;
        maxSize = capacity;
    }

    public int get(int key) {
        int x = map.containsKey(key) == true ? map.get(key)[0] : -1;
        if (x != -1) map.get(key)[1]++;
        return x;

    }

    public void set(int key, int value) {
        size++;
        if (size > maxSize) {
            map.remove(heap.poll()[0]);
            size--;
        }
        map.put(key, new int[]{value, 1});
        heap.add(new int[] {key, value, map.get(key)[1]});

    }
}
