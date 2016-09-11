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
        
        String str = justifyForLast(cur, curLen, maxWidth);
        list.add(str);
        
        return list;
    }
    
    private String justify(List<String> list, int len, int maxWidth) {
        if (list.size() == 1) {
            String str = list.get(0);
            str = padRight(str, maxWidth - str.length());
            return str;
        }
        int remain = maxWidth - len;
        while (remain > 0) {
            for (int i = 0; i < list.size() - 1 && remain-- > 0; i++) {
                String str = list.get(i);
                str += " ";
                list.set(i, str);
            }
        }
        return merge(list);
    }
    
    private String justifyForLast(List<String> list, int len, int maxWidth) {
        if (list.size() == 1) {
            String str = list.get(0);
            str = padRight(str, maxWidth - str.length());
            return str;
        }
        int remain = maxWidth - len;
        for (int i = 0; i < list.size() - 1; i++) {
            String str = list.get(i);
            str += " ";
            list.set(i, str);
            remain--;
        }
        String str = list.get(list.size() - 1);
        str = padRight(str, remain);
        list.set(list.size() - 1, str);
        return merge(list);        
    }
    
    private String merge(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    private String padRight(String str, int num) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}