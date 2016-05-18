public class Solution {
    public void moveZeroes(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cur++] = nums[i];
            }
        }
        for (; cur < nums.length; cur++) {
            nums[cur] = 0;
        }
    }
}