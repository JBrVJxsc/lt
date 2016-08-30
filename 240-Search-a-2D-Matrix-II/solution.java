public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        
        int bottom = matrix.length - 1;
        if (bottom < 0) {
            return false;
        }
        
        int right = matrix[0].length - 1;
        if (right < 0) {
            return false;
        }
        
        int left = 0;
        int top = 0;
        
        while (left <= right && top <= bottom) {
            // Top: left -> right. Find the first number that >= target.
            int l = left;
            int r = right;
            while (l <= r && left <= right && top <= bottom) {
                int mid = l + (r - l) / 2;
                int num = matrix[top][mid];
                if (num == target) {
                    return true;
                } else if (num < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                    right = r;
                }
            }
            
            // Right: top -> bottom. Find the first number that <= target.
            int t = top;
            int b = bottom;
            while (t <= b && left <= right && top <= bottom) {
                int mid = t + (b - t) / 2;
                int num = matrix[mid][right];
                if (num == target) {
                    return true;
                } else if (num < target) {
                    t = mid + 1;
                    top = t;
                } else {
                    b = mid - 1;
                }
            }
            
            // Bottom: right -> left. Find the first number that <= target.
            l = left;
            r = right;
            while (l <= r && left <= right && top <= bottom) {
                int mid = l + (r - l) / 2;
                int num = matrix[bottom][mid];
                if (num == target) {
                    return true;
                } else if (num < target) {
                    l = mid + 1;
                    left = l;
                } else {
                    r = mid - 1;
                }
            }
            
            // Left: bottom -> top. Find the first number that >= target.
            t = top;
            b = bottom;
            while (t <= b && left <= right && top <= bottom) {
                int mid = t + (b - t) / 2;
                int num = matrix[mid][left];
                if (num == target) {
                    return true;
                } else if (num < target) {
                    t = mid + 1;
                } else {
                    b = mid - 1;
                    bottom = b;
                }
            }            
        }
        
        return false;
    }
}