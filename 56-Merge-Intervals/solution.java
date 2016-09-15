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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return list;
        }
        
        Collections.sort(intervals, (a, b) -> {
            return Integer.compare(a.start, b.start);
        });
        list.add(intervals.get(0));
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval pre = list.get(list.size() - 1);
            Interval cur = intervals.get(i);
            if (cur.end <= pre.end) {
                continue;
            } else if (cur.start > pre.end) {
                list.add(cur);
            } else {
                pre.end = cur.end;
            }
        }
        return list;
    }
}