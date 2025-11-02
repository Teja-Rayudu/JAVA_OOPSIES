package DSA.STRINGS;

import java.util.Scanner;

public class Anagram {
    private static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++){
            chars[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a']--;
            if(chars[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        if(isAnagram(word1, word2)) System.out.println("Both Strings are Anagrams.");
        else System.out.println("Both strings are not Anagrams");
    }
}
