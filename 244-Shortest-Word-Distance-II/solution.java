public class WordDistance {

    private Map<String, List<Integer>> map = new HashMap<>();
    
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (map.get(words[i]) == null) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        for (int i1 : l1) {
            for (int i2 : l2) {
                min = Math.min(min, Math.abs(i1 - i2));
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");