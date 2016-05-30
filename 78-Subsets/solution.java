public class Solution {

public List<List<Integer>> subsets(int[] nums) {
  if (nums == null) {
    throw new IllegalArgumentException("nums cannot be null.");
  }
  
  List<List<Integer>> lists = new ArrayList<>();
  if (nums.length == 0) {
    return lists;
  }
  
  lists.add(new ArrayList<>());
  
  Arrays.sort(nums);
  
  for (int i : nums) {
    List<List<Integer>> copy = new ArrayList<>();
    for (List<Integer> list : lists) {
      List<Integer> l = new ArrayList<>(list);
      l.add(i);
      copy.add(l);
    }
    
    // List<Integer> l = new ArrayList<>();
    // l.add(i);
    // copy.add(l);
    
    lists.addAll(copy);
  }
  
  return lists;
}
}