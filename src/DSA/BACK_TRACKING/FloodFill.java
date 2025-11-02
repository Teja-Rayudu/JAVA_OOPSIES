package DSA.BACK_TRACKING;

import java.util.Scanner;

public class FloodFill { // Fill the color with given color
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt(), c = sc.nextInt();
        int newColor = sc.nextInt();
        int[][] image = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                image[i][j] = sc.nextInt();
            }
        }
        int[][] fill = flood(image, r, c, newColor);

        System.out.println();

        for(int[] i : fill){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    private static int[][] flood(int[][] image, int r, int c, int newColor) {
        int n = image.length, m = image[0].length;
        int old = image[r][c];
        if(old == newColor) return image;
        dfs(image, r, c, n, m, old, newColor);
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int n, int m, int old, int newColor) {
        if(r < 0 || c < 0 || r >= n || c >= m || image[r][c] != old) return;
        image[r][c] = newColor;
        dfs(image, r - 1, c, n, m, old, newColor);
        dfs(image, r + 1, c, n, m, old, newColor);
        dfs(image, r, c - 1, n, m, old, newColor);
        dfs(image, r, c + 1, n, m, old, newColor);
    }


}
