public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> lists = new ArrayList<>();
    if (nums == null) {
      return lists;
    }
    Arrays.sort(nums);
    Set<List<Integer>> set = new HashSet<>();
    for (int i : nums) {
      List<List<Integer>> temp = new ArrayList<>();
      for (List<Integer> list : lists) {
        List<Integer> l = new ArrayList<>(list);
        l.add(i);
        if (!set.contains(l)) {
          set.add(l);
          temp.add(l);
        }
      }
      List<Integer> l = new ArrayList<>();
      l.add(i);
      if (!set.contains(l)) {
        set.add(l);
        temp.add(l);
      }
      lists.addAll(temp);
    }
    lists.add(new ArrayList<>());
    return lists;
  }
}