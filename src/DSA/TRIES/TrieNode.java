package DSA.TRIES;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    List<TrieNode> children;
    boolean isEndOfWord;
    int childCount;

    public TrieNode(){
        isEndOfWord = false;
        children = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            children.add(null);
        }
    }
}

