package DSA.STRINGS;

import java.util.Scanner;

public class LCP { //longest Common prefix
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");

        String prefix = words[0];
        for(String str : words){
            while (str.indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        System.out.println(prefix);
    }
}
