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
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, (a, b) -> {
      return Integer.compare(a.start, b.start);
    });
    
    PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> {
      return Integer.compare(a.end, b.end);
    });
    pq.add(intervals[0]);
    
    for (int i = 1; i < intervals.length; i++) {
      Interval interval = intervals[i];
      Interval temp = pq.remove();
      if (temp.end <= interval.start) {
        temp.end = interval.end;
      } else {
        pq.add(interval);
      }
      pq.add(temp);
    }
    
    return pq.size();
  }
}