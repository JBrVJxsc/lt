public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = -1;
        int right = -1;
        
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                if (m != 0 && nums[m - 1] == target) {
                    r = m - 1;
                } else {
                    left = m;
                    break;
                }
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        if (left == -1) {
            return new int[]{-1, -1};
        }
        
        l = 0;
        r = nums.length - 1;
        
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                if (m != nums.length - 1 && nums[m + 1] == target) {
                    l = m + 1;
                } else {
                    right = m;
                    break;
                }
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }        
                
        return new int[]{left, right};
    }
}