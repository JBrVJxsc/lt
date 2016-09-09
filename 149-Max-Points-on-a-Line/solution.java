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
        if (points == null) {
            return 0;
        }
        if (points.length < 3) {
            return points.length;
        }
        
        int max = 0;
        
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int temp = 1;
            int same = 0;
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    same++;
                    continue;
                }
                double slope = slope(points[i], points[j]);
                Integer count = map.get(slope);
                if (count == null) {
                    count = 2;
                } else {
                    count += 1;
                }
                map.put(slope, count);
                temp = Math.max(temp, count);
            }
            max = Math.max(max, temp + same);
        }
        
        return max;
    }
    
    private double slope(Point a, Point b) {
        if (a.x == b.x) {
            return Double.MAX_VALUE;
        }
        double y = (double)(a.y - b.y);
        double x = (double)(a.x - b.x);
        return y / x;
    }
}