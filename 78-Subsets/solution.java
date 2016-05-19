public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums cannot be null.");
        }
        
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : lists) {
                List<Integer> l = new ArrayList<>(list);
                l.add(i);
                temp.add(l);
            }
            List<Integer> l = new ArrayList<>();
            l.add(i);
            temp.add(l);
            lists.addAll(temp);
        }
        
        lists.add(new ArrayList<>());
        return lists;
    }
}