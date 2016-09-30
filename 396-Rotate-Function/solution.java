public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            int index = i;
            for (int j = 0; j < A.length; j++) {
                sum += j * A[index];
                index++;
                if (index == A.length) {
                    index = 0;
                }
            }
            max = Math.max(max, sum);
        }
        
        return max;
    }
}