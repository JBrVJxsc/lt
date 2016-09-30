public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int sum = 0;
        int rotation = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            rotation += i * A[i];
        }
        
        int max = rotation;
        
        for (int i = 1; i < A.length; i++) {
            rotation = rotation + A.length * A[i - 1] - sum;
            max = Math.max(max, rotation);
        }
        
        return max;
    }
}