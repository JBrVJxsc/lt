public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            boolean zero = true;
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] != 0) {
                    zero = false;
                    break;
                }
            }
            if (zero) {
                for (int k = 0; k < result[i].length; k++) {
                    result[i][k] = -1;
                }
            }
        }
        for (int i = 0; i < B[0].length; i++) {
            boolean zero = true;
            for (int j = 0; j < B.length; j++) {
                if (B[j][i] != 0) {
                    zero = false;
                    break;
                }
            }
            if (zero) {
                for (int k = 0; k < result.length; k++) {
                    result[k][i] = -1;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j] == -1) {
                    result[i][j] = 0;
                    continue;
                }
                result[i][j] = multi(A, B, i, j);
            }
        }
        return result;
    }
    
    private int multi(int[][] A, int[][] B, int row, int col) {
        int sum = 0;
        for (int i = 0; i < A[row].length; i++) {
            sum += A[row][i] * B[i][col];
        }
        return sum;
    }
}