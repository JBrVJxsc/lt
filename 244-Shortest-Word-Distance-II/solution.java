public class WordDistance {

    Map<String, ArrayList<Integer>> map = new HashMap<>();
    
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (map.get(words[i]) == null) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        
        while (i < l1.size() && j < l2.size()) {
            min = Math.min(min, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) < l2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");