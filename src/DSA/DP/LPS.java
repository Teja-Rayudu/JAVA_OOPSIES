package DSA.DP;

import java.util.Scanner;

import static DSA.DP.LCS.lcs;

public class LPS { //Longest palindromic subsequence
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = new StringBuilder(s1).reverse().toString();
        System.out.println(lcs(s1,s2));
    }
}
