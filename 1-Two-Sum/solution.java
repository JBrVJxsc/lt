public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            Integer index = map.get(dif);
            if (index != null && index != i) {
                return new int[]{Math.min(i, index), Math.max(i, index)};
            }
        }
        
        return null;
    }
}