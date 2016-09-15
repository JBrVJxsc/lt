/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        Map<Double, Integer> map = null;
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            map = new HashMap<>();
            int same = 0;
            int curMax = 1;
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                Point p1 = points[i];
                Point p2 = points[j];
                if (p1.y == p2.y && p1.x == p2.x) {
                    same++;
                    continue;
                }
                double slope = getSlope(p1, p2);
                Integer count = map.getOrDefault(slope, 1) + 1;
                map.put(slope, count);
                curMax = Math.max(curMax, count);
            }
            max = Math.max(max, curMax + same);
        }
        return max;
    }
    
    
    private double getSlope(Point a, Point b) {
        if (a.x == b.x) {
            return Double.MAX_VALUE;
        }
        return (double)(a.y - b.y) / (double)(a.x - b.x);
    }
}