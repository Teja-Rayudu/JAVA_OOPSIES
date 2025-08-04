public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode(){
        isEndOfWord = false;
        children = new TrieNode[26];
    }
}

