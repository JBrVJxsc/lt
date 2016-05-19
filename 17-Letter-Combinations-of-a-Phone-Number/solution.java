public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null) {
            throw new IllegalArgumentException("digits cannot be null.");
        }
        if (digits.length() == 0) {
            return list;
        }
        for (int i = 0; i < digits.length(); i++) {
            list = merge(list, convert(digits.charAt(i)));
        }
        return list;
    }
    
    private List<String> merge(List<String> l1, String[] l2) {
        if (l1.size() == 0) {
            for (String s2 : l2) {
                l1.add(s2);
            }
            return l1;
        } else {
            List<String> list = new ArrayList<>();
            for (String s2 : l2) {
                for (String s1: l1) {
                    list.add(s1 + s2);
                }
            }
            return list;
        }
    }
    
    private String[] convert(char c) {
        if (c == '2') {
            return new String[]{"a", "b", "c"};
        } else if (c == '3') {
            return new String[]{"d", "e", "f"};
        } else if (c == '4') {
            return new String[]{"g", "h", "i"};
        } else if (c == '5') {
            return new String[]{"j", "k", "l"};
        } else if (c == '6') {
            return new String[]{"m", "n", "o"};
        } else if (c == '7') {
            return new String[]{"p", "q", "r", "s"};
        } else if (c == '8') {
            return new String[]{"t", "u", "v"};
        } else if (c == '9') {
            return new String[]{"w", "x", "y", "z"};
        }
        return null;
    }
}