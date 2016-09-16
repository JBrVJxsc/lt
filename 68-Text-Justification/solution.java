public class Solution {
    public List<String> fullJustify(String[] words, int max) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0) {
            return list;
        }
        
        List<String> cur = new ArrayList<>();
        int curLen = 0;
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (curLen + str.length() + cur.size() > max) {
                str = justify(cur, curLen, max);
                list.add(str);
                cur = new ArrayList<>();
                curLen = 0;
                i--;
            } else {
                cur.add(str);
                curLen += str.length();
            }
        }
        
        String str = justifyLast(cur, curLen, max);
        list.add(str);
        return list;
    }
    
    private String justify(List<String> list, int len, int max) {
        int remain = max - len;
        if (list.size() == 1) {
            return padRight(list.get(0), remain);
        } else {
            while (remain > 0) {
                for (int i = 0; i < list.size() - 1 && remain-- > 0; i++) {
                    list.set(i, list.get(i) + " ");
                }
            }
            return merge(list);
        }
    }
    
    private String justifyLast(List<String> list, int len, int max) {
        int remain = max - len;
        for (int i = 0; i < list.size() - 1; i++) {
            list.set(i, list.get(i) + " ");
            remain--;
        }
        list.set(list.size() - 1, padRight(list.get(list.size() - 1), remain));
        return merge(list);
    }
    
    private String padRight(String str, int num) {
        StringBuilder sb = new StringBuilder(str);
        while (num-- > 0) {
            sb.append(" ");
        }
        return sb.toString();
    }
    
    private String merge(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}