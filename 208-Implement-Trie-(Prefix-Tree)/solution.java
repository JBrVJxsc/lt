class TrieNode {
  
  boolean isWord = false;
  TrieNode[] nodes = new TrieNode[26];
  
  // Initialize your data structure here.
  public TrieNode() {

  }
}

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      int pos = c - 'a';
      if (node.nodes[pos] == null) {
        node.nodes[pos] = new TrieNode();
      }
      node = node.nodes[pos];
    }
    node.isWord = true;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode node = find(word);
    if (node == null) {
      return false;
    }
    return node.isWord;
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String word) {
    return find(word) != null;
  }
  
  private TrieNode find(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      int pos = c - 'a';
      if (node.nodes[pos] == null) {
        return null;
      }
      node = node.nodes[pos];
    }
    return node;    
  }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");