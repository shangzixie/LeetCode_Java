# 895. Maximum Frequency Stack

[LeetCode 895](https://leetcode.com/problems/maximum-frequency-stack/)


## Methods

### Method 1

`pop()` could pop the most frequent element. So we could use a `PriorityQueue<int[]>`, 
each element contains (the num, frequency, index).  when their `frequency` is same, could sort by `index`. 
### Key Points

### Code

```java
class FreqStack {
    Map<Integer, Integer> map;
    PriorityQueue<int[]> heap;
    int index = 0; 
    
    public FreqStack() {
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

```


## Reference