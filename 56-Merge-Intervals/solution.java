public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> list = new ArrayList<>();
    
    Collections.sort(intervals, (a, b) -> {
      return Integer.compare(a.start, b.start);
    });
    
    for (Interval i : intervals) {
      if (list.size() == 0) {
        list.add(i);
      } else {
        Interval last = list.get(list.size() - 1);
        if (i.end <= last.end) {
          continue;
        } else if (i.start <= last.end) {
          last.end = i.end;
        } else {
          list.add(i);
        }
      }
    }
    
    return list;
  }
}