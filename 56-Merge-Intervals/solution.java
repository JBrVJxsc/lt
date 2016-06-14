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
    List<Interval> result = new ArrayList<>();
    if (intervals == null || intervals.size() < 1) {
      return result;
    }
    
    Collections.sort(intervals, (a, b) -> {
      return Integer.compare(a.start, b.start);
    });
    
    result.add(intervals.get(0));
    
    for (int i = 1; i < intervals.size(); i++) {
      Interval pre = result.get(result.size() - 1);
      Interval cur = intervals.get(i);
      if (cur.end <= pre.end) {
        continue;
      }
      if (cur.start <= pre.end) {
        pre.end = cur.end;
      } else if (pre.end < cur.start) {
        result.add(cur);
      }
    }
    
    return result;
  }
}