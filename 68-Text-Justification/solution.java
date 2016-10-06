public class Solution {
    public List<String> fullJustify(String[] words, int max) {
        List<String> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        int curLen = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (curLen + words[i].length() + cur.size() <= max) {
                cur.add(words[i]);
                curLen += words[i].length();
            } else {
                result.add(justify(cur, curLen, max));
                cur = new ArrayList<>();
                curLen = 0;
                i--;
            }
        }
        
        result.add(justifyLast(cur, max));
        return result;
    }
    
    private String justify(List<String> list, int len, int max) {
        if (list.size() == 1) {
            return padRight(list.get(0), max);
        } else {
            int remain = max - len;
            while (remain > 0) {
                for (int i = 0; i < list.size() - 1 && remain > 0; i++) {
                    String str = list.get(i) + " ";
                    list.set(i, str);
                    remain--;
                }
            }
            return merge(list);
        }
    }
    
    private String justifyLast(List<String> list, int max) {
        String str = list.get(0);
        if (list.size() > 1) {
            for (int i = 0; i < list.size() - 1; i++) {
                str = list.get(i) + " ";
                list.set(i, str);
            }
            str = merge(list);
        }
        return padRight(str, max);
    }
    
    private String padRight(String str, int len) {
        while (len != str.length()) {
            str += " ";
        }
        return str;
    }
    
    private String merge(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}