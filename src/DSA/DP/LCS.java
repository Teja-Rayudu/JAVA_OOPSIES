package DSA.DP;

import java.util.Scanner;

public class LCS { // Longest Common Subsequence
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(lcs(s1,s2));
    }

    public static String lcs(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j  - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n, j = m;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]){
                i--;
            }
            else {
                j--;
            }
        }
        return sb.reverse().toString();
    }
}
