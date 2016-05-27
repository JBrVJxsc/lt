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
    if (intervals.size() == 0) {
      intervals.add(newInterval);
      return intervals;
    }
    
    int i = 0;
    for (Interval interval : intervals) {
      if (interval.start >= newInterval.start) {
        break;
      }
      i++;
    }
    intervals.add(i, newInterval);
    
    return merge(intervals);
  }

  private List<Interval> merge(List<Interval> intervals) {
    List<Interval> list = new ArrayList<>();
    list.add(intervals.get(0));
    for (int i = 1; i < intervals.size(); i++) {
      Interval last = list.get(list.size() - 1);
      Interval interval = intervals.get(i);
      if (interval.end <= last.end) {
        continue;
      } else if (interval.start <= last.end) {
        last.end = interval.end;
      } else {
        list.add(interval);
      }
    }
    return list;
  }
}