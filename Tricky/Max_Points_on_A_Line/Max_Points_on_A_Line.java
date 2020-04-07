package LeetCode_Java.Tricky.Max_Points_on_A_Line;

import java.util.HashMap;
import java.util.Map;

// 首相我们需要知道一个定理： 经过同一个点，斜率相同的直线是同一条。
// 所以固定一个点不动，然后for循环其他点，如果跟这个点斜率相同，那么这些点就在同一条直线上。
// 最后我们可以得到和该点同一直线的最大点的数量。
// 之后我们更换该固定点，计算
// 最后得到全局最大数量
public class Max_Points_on_A_Line {
      class Point {
          int x;
          int y;
          Point() { x = 0; y = 0; }
          Point(int a, int b) { x = a; y = b; }
      }

    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;

        Map<Double, Integer> slopeToCount = new HashMap<>();
        int n = points.length;
        int res = 0;

        for (int i = 0; i < n; i++){
            Point point1 = points[i];
            int samePoint = 0;
            int maxNum = 0;
            for (int j = i + 1; j < n; j++){
                Point point2 = points[j];
                if (point1.x == point2.x && point1.y == point2.y){
                    samePoint += 1;
                    continue;
                }

                double slope = getSlope(point1, point2);
                slopeToCount.put(slope, slopeToCount.getOrDefault(slope, 0) +1);
                maxNum = Math.max(maxNum, slopeToCount.get(slope));
            }
            slopeToCount.clear();
            res = Math.max(res, samePoint + maxNum + 1);
        }
        return res;
    }



    public double getSlope(Point p1, Point p2){
        if (p1.x == p2.x && p1.y != p2.y){
            return Double.MAX_VALUE;
        }

        return (double) (p1.y - p2.y) /(double) (p1.x - p2.x);
    }
}

