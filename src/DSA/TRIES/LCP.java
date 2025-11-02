package DSA.TRIES;

import java.util.Scanner;

public class LCP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");

        System.out.println(longestCommonPrefix(words));

    }

    private static String longestCommonPrefix(String[] words) {
        TrieNode root = new TrieNode();

        for(String key : words){
            insert(root, key);
        }
        return walkTrie(root, words[0]);
    }

    private static void insert(TrieNode root, String key){
        TrieNode curr = root;
        for (char c : key.toCharArray()){
            int idx = c -'a';
            if(curr.children.get(idx) == null){
                curr.children.set(idx,new TrieNode());
                curr.childCount++;
            }
            curr = curr.children.get(idx);
        }
        curr.isEndOfWord = true;
    }
    private static String walkTrie(TrieNode root, String word) {
        TrieNode curr = root;
        int i = 0;
        while (curr.childCount == 1 && !curr.isEndOfWord){
            int idx = word.charAt(i) - 'a';
            i++;
            curr = curr.children.get(idx);
        }
        return word.substring(0, i);
    }
}
