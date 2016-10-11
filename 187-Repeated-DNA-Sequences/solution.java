public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        
        if (s == null || s.length() < 11) {
            return list;
        }
        
        Set<Integer> all = new HashSet<>();
        Set<Integer> added = new HashSet<>();
        int num = 0;
        
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
            
            num <<= 2;
            num += n;
            num &= (1 << 20) - 1;
            
            if (i > 8) {              
                if (!all.contains(num)) {
                    all.add(num);
                } else if (!added.contains(num)) {
                    added.add(num);
                    list.add(s.substring(i - 9, i + 1));                        
                }
            }
        }
        
        return list;
    }
}
