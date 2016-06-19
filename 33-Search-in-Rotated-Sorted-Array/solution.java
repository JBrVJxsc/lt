public class Solution {
  public int search(int[] nums, int target) {
    return binary(nums, target, 0, nums.length - 1);
  }
  
  private int binary(int[] nums, int target, int left, int right) {
    if (left > right) {
      return -1;
    }
    
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
      return mid;
    }
    
    if (nums[left] <= nums[mid]) {
      if (nums[left] <= target && target < nums[mid]) {
        return binary(nums, target, left, mid - 1);
      } else {
        return binary(nums, target, mid + 1, right);
      }
    } else {
      if (nums[mid] < target && target <= nums[right]) {
        return binary(nums, target, mid + 1, right);
      } else {
        return binary(nums, target, left, mid - 1);        
      }      
    }
  }
}




// 567891234
  
// ^   ^

// 51238

// 1. smallest one will ALWAYS be right of the largest one.
// 2. 
