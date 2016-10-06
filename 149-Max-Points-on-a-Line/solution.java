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
        
        int max = 1;
        
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int same = 0;
            int curMax = 1;
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSame(points[i], points[j])) {
                    same++;
                    continue;
                }
                double slope = getSlope(points[i], points[j]);
                int count = map.getOrDefault(slope, 1) + 1;
                map.put(slope, count);
                curMax = Math.max(curMax, count);
            }
            max = Math.max(max, curMax + same);
        }
        
        return max;
    }
    
    private double getSlope(Point p1, Point p2) {
        if (p1.x == p2.x) {
            return Integer.MAX_VALUE;
        }
        return (double)(p1.y - p2.y) / (p1.x - p2.x);
    }
    
    private boolean isSame(Point p1, Point p2) {
        return p1.x == p2.x && p1.y == p2.y;
    }
}