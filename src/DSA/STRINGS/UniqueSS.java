package DSA.STRINGS;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueSS { // Longest Unique substring without repeating characters.
    static void longestUniqueSubstr(String s){
        int n = s.length();
        String longest = "", current = "";
        Set<Character> seen = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++){

            while (seen.contains(s.charAt(right))){
                seen.remove(s.charAt(left));
                current = current.substring(1);
                left++;
            }
            seen.add(s.charAt(right));
            current += s.charAt(right);
            longest = (current.length() > longest.length())? current : longest;

        }
        System.out.println("The longest unique substring is :" + longest);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        longestUniqueSubstr(s);
    }
}
