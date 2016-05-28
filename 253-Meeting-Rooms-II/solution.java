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
  public int minMeetingRooms(Interval[] list) {
    Arrays.sort(list, (a, b) -> {
      return Integer.compare(a.start, b.start);
    });
    
    List<Interval> l = new ArrayList<>();
    int min = 0;
    
    for (Interval interval : list) {
      List<Interval> newList = new ArrayList<>();
      newList.add(interval);
      for (Interval i : l) {
        if (i.end > interval.start) {
          newList.add(i);
        }
      }
      l = newList;
      min = Math.max(min, l.size());
    }
    
    return min;
  }
}