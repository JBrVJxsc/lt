public class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] map = new boolean[n];
        map[0] = true;
        map[1] = true;
        
        int i = 2;
        while (i < n) {
            while (i < n && map[i] == true) {
                i++;
            }
            for (int j = 2; i * j < n; j++) {
                map[i * j] = true;
            }
            i++;
        }
        
        int count = 0;
        for (boolean b : map) {
            if (!b) {
                count++;
            }
        }
        return count;
    }
}