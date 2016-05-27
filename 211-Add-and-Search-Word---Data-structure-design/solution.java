public class WordDictionary {

  class Node {
    boolean isWord = false;
    Node[] nodes = new Node[26];
  }
  
  private Node root = new Node();
  
  // Adds a word into the data structure.
  public void addWord(String word) {
    Node node = root;
    for (char c : word.toCharArray()) {
      int pos = c - 'a';
      if (node.nodes[pos] == null) {
        node.nodes[pos] = new Node();
      }
      node = node.nodes[pos];
    }
    node.isWord = true;
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {
    return search(word, root, 0);
  }
  
  private boolean search(String word, Node node, int i) {
    if (i == word.length()) {
      return node.isWord;
    }
    if (word.charAt(i) == '.') {
      for (int j = 0; j < 26; j++) {
        if (node.nodes[j] != null) {
          if (search(word, node.nodes[j], i + 1)) {
            return true;
          }
        }
      }
      return false;
    } else {
      int pos = word.charAt(i) - 'a';
      if (node.nodes[pos] == null) {
        return false;
      }
      return search(word, node.nodes[pos], i + 1);
    }
  }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");