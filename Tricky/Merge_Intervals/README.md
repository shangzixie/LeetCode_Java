# 56. Merge Intervals

[LeetCode 56](https://leetcode.com/problems/merge-intervals/)


## Methods

### Method 
If we sort the intervals by their start value, then each set of intervals that can be merged will appear as a contiguous "run" in the sorted list.

First, we sort the list as described. Then, we insert the first interval into our merged list and continue considering each interval in turn as follows: If the current interval begins after the previous interval ends, then they do not overlap and we can append the current interval to merged. Otherwise, they do overlap, and we merge them by updating the end of the previous interval if it is less than the end of the current interval.

### Key Points
every loop, modify and update the `merged.getLast()[1]`

------------
### My Intuitive Wrong Method
every loop, when current interval non-overlapping, append `(start, cur.end)` and update `start`;
if current interval is overlap, keep iterating to find appropriate `end`

###But
it couldn't deal with this case: 
```
[(1,10), (2,3),(4,5),(6,7),(8,9)]

Output
[(1,3),(4,5),(6,7),(8,9)]
Expected
[(1,10)]
```

-----------


### Code
```java
public class Merge_Intervals {

    // right method
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (h1, h2)-> h1[0] - h2[0]);

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }


    //wrong method:
    public List<Interval> merge1(List<Interval> intervals) {
        if (intervals.size() == 1 || intervals.size() == 0) return intervals;

        Collections.sort(intervals, (h1, h2)-> Integer.compare(h1.start, h2.start));
        int start = intervals.get(0).start;

        List<Interval> ans = new ArrayList<>();
        for (int i = 0; i < intervals.size() -1;i++){
            if ( intervals.get(i).end< intervals.get(i+1).start) {//non-overlapping
                Interval temp = new Interval(start, intervals.get(i).end);
                ans.add(temp);
                start = intervals.get(i+1).start;
            }

        }

        if (intervals.get(intervals.size() - 1).start < intervals.get(intervals.size() - 2).end){ //overlapping
            Interval temp = new Interval(start, intervals.get(intervals.size() - 1).end);
            ans.add(temp);
        }else{
            Interval temp = new Interval(intervals.get(intervals.size() - 1).start, intervals.get(intervals.size() - 1).end);
            ans.add(temp);
        }
        return ans;

    }
}

```

## Reference
https://leetcode.com/problems/merge-intervals/solution/