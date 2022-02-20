# [LeetCode 57. Insert Interval](https://leetcode.com/problems/insert-interval/)


## Methods
this question is the hard version of [Merge_Intervals](../Merge_Intervals)
### Method 1
* `Time Complexity`: O(n)
* `Intuition`: find an appropriate position to insert the `newInterval`, then merge them.
* `Algorithm`: 

### Key Points


### Code
```java

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
     //insert
        // add all intervals starting before newInterval   
        int index = 0;
        LinkedList<int[]> intervalsList = new LinkedList<>(); 
        for (int[] interval : intervals) {
            if (interval[0] < newInterval[0]) {
                intervalsList.add(interval); 
                index++;
            }
            else break; 
        }
        // add newInterval
        // if there is no overlap, just add the interval
        // if there is an overlap, merge with the last interval
        if (intervalsList.isEmpty() || intervalsList.getLast()[1] < newInterval[0]) intervalsList.add(newInterval); 
        else intervalsList.getLast()[1] = Math.max(newInterval[1], intervalsList.getLast()[1]); 
        
        while (index < intervals.length) intervalsList.add(intervals[index++]); // add the rest intervals 
        
     //merge 
        LinkedList<int[]> ans = new LinkedList<>(); 
        for (int[] interval : intervalsList) {
            if (ans.isEmpty() || interval[0] > ans.getLast()[1]) ans.add(interval); 
            else ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]); 
        }
        
        return ans.toArray(new int[0][0]);
    }
}
```


## Reference