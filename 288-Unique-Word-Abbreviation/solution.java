public class ValidWordAbbr {

    private Map<String, Set<String>> map = new HashMap<>();

    public ValidWordAbbr(String[] dict) {
        for (String str : dict) {
            String abbr = abbr(str);
            if (map.get(abbr) == null) {
                map.put(abbr, new HashSet<>());
            }
            map.get(abbr).add(str);
        }
    }

    public boolean isUnique(String word) {
        Set<String> set = map.get(abbr(word));
        if (set == null) {
            return true;
        }
        if (set.size() > 1) {
            return false;
        }
        return set.contains(word);
    }
    
    private String abbr(String str) {
        int len = str.length();
        if (len < 3) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        sb.append(len - 2);
        sb.append(str.charAt(len - 1));
        return sb.toString();
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");