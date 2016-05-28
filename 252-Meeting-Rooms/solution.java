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
  public boolean canAttendMeetings(Interval[] list) {
    Arrays.sort(list, (a, b) -> {
      return Integer.compare(a.start, b.start);
    });
      
    for (int i = 1; i < list.length; i++) {
      if (list[i].start < list[i - 1].end) {
        return false;
      }
    }
    
    return true;
  }
}