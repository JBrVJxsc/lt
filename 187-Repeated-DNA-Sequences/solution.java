public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return list;
        }
        
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
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
            
            num = (num << 2) + n;
            if (i >= 9) {
                num &= (1 << 20) - 1;
                if (first.contains(num) && !second.contains(num)) {
                    list.add(s.substring(i - 9, i + 1));
                    second.add(num);
                } else {
                    first.add(num);
                }
            }
        }
        
        return list;
    }
}