/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        // if (intervals == null || intervals.size() == 0) {
        //     result.add(newInterval);
        //     return result;
        // }
        
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (newInterval != null) {
                if (newInterval.start > cur.end) {
                    result.add(cur);
                } else if (newInterval.end < cur.start) {
                    result.add(newInterval);
                    newInterval = null;
                    i--;
                } else {
                    cur.start = Math.min(cur.start, newInterval.start);
                    cur.end = Math.max(cur.end, newInterval.end);
                    result.add(cur);
                    newInterval = null;
                }
            } else {
                Interval pre = result.get(result.size() - 1);
                if (cur.start > pre.end) {
                    result.add(cur);
                } else if (cur.end <= pre.end) {
                    continue;
                } else {
                    pre.end = cur.end;
                }
            }
        }
        
        if (newInterval != null) {
            result.add(newInterval);
        }
        
        return result;
    }
}