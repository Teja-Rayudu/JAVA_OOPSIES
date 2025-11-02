package DSA.DP;

import java.util.Arrays;
import java.util.Scanner;

public class LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(lis(arr));

    }

    private static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return dp[n - 1];
    }
}
