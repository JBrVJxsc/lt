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
        List<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            list.add(newInterval);
            return list;
        }
        
        int i = 0;
        while (i < intervals.size() && newInterval.start > intervals.get(i).start) {
            i++;
        }
        intervals.add(i, newInterval);
        
        list.add(intervals.get(0));
        for (i = 1; i < intervals.size(); i++) {
            Interval pre = list.get(list.size() - 1);
            Interval cur = intervals.get(i);
            if (cur.start > pre.end) {
                list.add(cur);
            } else if (cur.end <= pre.end) {
                continue;
            } else {
                pre.end = cur.end;
            }
        }
        return list;
    }
}