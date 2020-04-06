package LeetCode_Java.Tricky.Max_Points_on_A_Line;

import java.util.HashMap;
import java.util.Map;

public class Max_Points_on_A_Line {




      class Point {
          int x;
          int y;
          Point() { x = 0; y = 0; }
          Point(int a, int b) { x = a; y = b; }
      }

    public int maxPoints(Point[] points) {
        Map<Double, Integer> slopeToCount = new HashMap<>();
        int n = points.length;
        int maxNum = 0;

        for (int i = 0; i < n; i++){
            Point point1 = points[i];
            int samePoint = 1;
            for (int j = i + 1; j < n; j++){
                Point point2 = points[j];
                if (point1.x == point2.x && point1.y == point2.y){
                    samePoint += 1;
                    continue;
                }

                double slope = getSlope(point1, point2);
                slopeToCount.put(slope, slopeToCount.getOrDefault(slope,0) + samePoint);
                maxNum = Math.max(maxNum, slopeToCount.get(slope));
            }
            slopeToCount.clear();
        }
        return maxNum;
    }



    public double getSlope(Point p1, Point p2){
        if (p1.x == p2.x && p1.y != p2.y){
            return Double.MAX_VALUE;
        }

        return (double) (p1.y - p2.y) /(double) (p1.x - p2.x);
    }
}
