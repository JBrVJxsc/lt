public class Solution {
  public void moveZeroes(int[] nums) {
    int cur = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        swap(nums, i, cur++);
      }
    }
  }
  
  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}