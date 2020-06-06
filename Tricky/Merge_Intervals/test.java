package LeetCode_Java.Tricky.Merge_Intervals;

import LeetCode_Java.buildinClass.Interval;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        Merge_Intervals a = new Merge_Intervals();
        a.merge1(intervals);
    }
}
