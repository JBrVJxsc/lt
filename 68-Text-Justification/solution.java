public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0) {
            return list;
        }
        
        int i = 0;
        List<String> cur = new ArrayList<>();
        int curLen = 0;
        
        while (i < words.length) {
            String str = words[i];
            if (curLen + str.length() + cur.size() > maxWidth) {
                str = justify(cur, curLen, maxWidth);
                list.add(str);
                cur = new ArrayList<>();
                curLen = 0;
                i--;
            } else {
                cur.add(str);
                curLen += str.length();
            }
            i++;
        }
        
        String str = justifyLast(cur, curLen, maxWidth);
        list.add(str);
        
        return list;
    }
    
    private String justify(List<String> list, int len, int max) {
        int remain = max - len;
        if (list.size() == 1) {
            String str = list.get(0);
            return padRight(str, remain);
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
        String str = padRight(list.get(list.size() - 1), remain);
        list.set(list.size() - 1, str);
        return merge(list);
    }
    
    private String padRight(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        while (len-- > 0) {
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