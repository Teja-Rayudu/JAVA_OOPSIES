package DSA.STRINGS;

import java.util.*;

public class Isomorphic {
    private static boolean areIsomorphic(String s, String t){
        if(s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(map.containsKey(cs)){
                if(map.get(cs) != ct) return false;
            }
            else{
                if(set.contains(ct)) return false;
                map.put(cs, ct);
                set.add(ct);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        if(areIsomorphic(word1, word2)) System.out.println("Given words are isomorphic.");
        else System.out.println("Given words are not isomorphic");
    }
}
