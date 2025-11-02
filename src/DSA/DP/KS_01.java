package DSA.DP;

import java.util.Scanner;

public class KS_01 { // Binary Knapsack
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profits = new int[n];
        int[] weights = new int[n];
        for(int i = 0; i < n; i++){
            profits[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        int sack_weight = sc.nextInt();
        knapsack(profits, weights, sack_weight);
    }

    private static void knapsack(int[] profits, int[] weights, int sackWeight) {
        int[][] dp = new int[profits.length + 1][sackWeight + 1];
        for(int p = 1; p <= profits.length; p++){
            for(int w = 0; w <= sackWeight; w++){
                if(p == 0 || w == 0) dp[p][w] = 0;
                else if (weights[p - 1] <= w) {
                    dp[p][w] = Math.max(profits[p - 1] + dp[p - 1][w - weights[p - 1]], dp[p - 1][w]);
                }
                else {
                    dp[p][w] = dp[p - 1][w];
                }
            }
        }
        System.out.println(dp[profits.length][sackWeight]);
    }
}
