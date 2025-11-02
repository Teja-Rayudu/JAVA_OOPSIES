package DSA.DP;

import java.util.Scanner;

public class MCM { // Matrix chain Multiplication;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dimensions = new int[n];
        for (int i = 0; i < n; i++) {
            dimensions[i] = sc.nextInt();
        }
        System.out.println(chain(dimensions));
    }

    private static int chain(int[] dimensions) {
        int n = dimensions.length;
        int[][] dp = new int[n][n];
        for (int L = 2; L < n ; L++) {
            for(int i = 0; i < n-L; i++){
                int j = i +  L;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i+1; k < j; k++){
                    int cost = dp[i][k] + dp[k][j] + (dimensions[i]*dimensions[j]*dimensions[k]);
                    dp[i][j] = Math.min(cost, dp[i][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
