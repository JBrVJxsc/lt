public class Solution {
    public void sortColors(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, cur++, i);
            }
        }
        for (int i = cur; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, cur++, i);
            }
        }        
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}