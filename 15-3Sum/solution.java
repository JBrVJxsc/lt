public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int dif = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == dif) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left++]);
                        list.add(nums[right--]);
                        lists.add(list);
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum > dif) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        
        return lists;
    }
}