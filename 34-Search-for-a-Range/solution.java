public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left(nums, target, 0, nums.length - 1), right(nums, target, 0, nums.length - 1)};
    }
    
    private int left(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (nums[m] == target) {
            if (m == 0 || nums[m - 1] != target) {
                return m;
            } else {
                return left(nums, target, l, m - 1);
            }
        } else if (nums[m] > target) {
            return left(nums, target, l, m - 1);
        } else {
            return left(nums, target, m + 1, r);
        }
    }
    
    private int right(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }        
        int m = l + (r - l) / 2;
        if (nums[m] == target) {
            if (m == nums.length - 1 || nums[m + 1] != target) {
                return m;
            } else {
                return right(nums, target, m + 1, r);
            }
        } else if (nums[m] > target) {
            return right(nums, target, l, m - 1);
        } else {
            return right(nums, target, m + 1, r);
        }        
    }    
}