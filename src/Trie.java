import java.util.Scanner;

public class Trie
{
    static void insert(TrieNode root, String key)
    {
        TrieNode curr = root;
        for(char c : key.toCharArray()){
            if (curr.children[c - 'a'] == null){
                TrieNode newNode = new TrieNode();
                curr.children[c - 'a'] = newNode;
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    static boolean search(TrieNode root, String key){
        TrieNode curr = root;
        for(char c : key.toCharArray()){
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }

        return  curr.isEndOfWord;
    }

    static boolean isPrefix(TrieNode root, String key){
        TrieNode curr = root;
        for(char c : key.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        TrieNode root = new TrieNode();

        for(String word : words) insert(root, word);
        String search_word = sc.next();
        if(search(root, search_word)) System.out.println(search_word +" is found");
        else System.out.println(search_word+" is not found");

        String prefix = sc.next();
        if(isPrefix(root, prefix)) System.out.println(prefix+" is a prefix");
        else  System.out.println(prefix+" is not a prefix");
    }
}
