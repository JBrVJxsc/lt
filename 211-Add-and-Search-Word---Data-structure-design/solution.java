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
    return dfs(word, 0, root);
  }
  
  private boolean dfs(String word, int index, Node node) {
    if (node == null) {
      return false;
    }          
    if (index == word.length()) {
      return node.isWord;
    }
    char c = word.charAt(index);
    if (c == '.') {
      for (Node n : node.nodes) {
        if (dfs(word, index + 1, n)) {
          return true;
        }
      }
      return false;
    } else {
      if (node.nodes[c - 'a'] == null) {
        return false;
      }
      return dfs(word, index + 1, node.nodes[c - 'a']);
    }
  }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

