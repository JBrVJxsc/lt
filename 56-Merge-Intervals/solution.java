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
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        List<Interval> result = new ArrayList<>();
        
        for (Interval i : intervals) {
            if (result.size() == 0) {
                result.add(i);
            } else {
                Interval last = result.get(result.size() - 1);
                if (i.start > last.end) {
                    result.add(i);
                } else if (i.end <= last.end) {
                    continue;
                } else {
                    last.end = i.end;
                }
            }
        }
        
        return result;
    }
}