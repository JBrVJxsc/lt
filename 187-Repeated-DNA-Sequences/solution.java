public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() < 11) {
            return list;
        }
        
        int num = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> added = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = 0;
            if (c == 'C') {
                n = 1;
            } else if (c == 'G') {
                n = 2;
            } else if (c == 'T') {
                n = 3;
            }
            
            if (i < 9) {
                num = num << 2;
                num += n;
            } else {
                num = num << 2;
                num += n;                
                num &= (1 << 20) - 1;
                if (set.contains(num) && !added.contains(num)) {
                    list.add(s.substring(i - 9, i + 1));
                    added.add(num);
                } else {
                    set.add(num);
                }
            }
        }
        return list;
    }
}