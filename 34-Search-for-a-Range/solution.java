public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int r1 = -1;
        int r2 = -1;
        
        if (nums != null && nums.length != 0) {
            int l = 0;
            int r = nums.length - 1;
            
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (nums[m] > target) {
                    r = m - 1;
                } else if (nums[m] < target) {
                    l = m + 1;
                } else {
                    if (m == 0 || nums[m - 1] != target) {
                        r1 = m;
                        break;
                    } else {
                        r = m - 1;
                    }
                }
            }
            
            l = 0;
            r = nums.length - 1;
            
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (nums[m] > target) {
                    r = m - 1;
                } else if (nums[m] < target) {
                    l = m + 1;
                } else {
                    if (m == nums.length - 1 || nums[m + 1] != target) {
                        r2 = m;
                        break;
                    } else {
                        l = m + 1;
                    }
                }
            }            
        }
        
        return new int[]{r1, r2};
    }
}