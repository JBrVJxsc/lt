public class WordDictionary {
  class Node {
    Node[] nodes = new Node[26];
    boolean isWord = false;
  }
  
  private Node root = new Node();
  
  public void addWord(String word) {
    Node next = root;
    for (char c : word.toCharArray()) {
      int pos = c - 'a';
      if (next.nodes[pos] == null) {
        next.nodes[pos] = new Node();
      }
      next = next.nodes[pos];
    }
    next.isWord = true;
  }
  
  public boolean search(String word) {
    return dfs(root, word, 0);
  }
  
  private boolean dfs(Node node, String word, int index) {
    if (node == null) {
      return false;
    }
    if (index == word.length()) {
      return node.isWord;
    }
    char c = word.charAt(index);
    if (c == '.') {
      for (Node n : node.nodes) {
        if (dfs(n, word, index + 1)) {
          return true;
        }
      }
    } else {
      int pos = c - 'a';
      return dfs(node.nodes[pos], word, index + 1);
    }
    return false;
  }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");