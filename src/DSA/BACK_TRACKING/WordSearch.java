package DSA.BACK_TRACKING;

import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.next().charAt(0);
            }
        }
        String word = sc.next();

        System.out.println(wordExist(mat, word));
    }

    private static boolean wordExist(char[][] mat, String word) {
        int wlen = word.length();
        int n = mat.length;
        int m = mat[0].length;

        if(wlen > n*m) return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == word.charAt(0)){
                    if(find(mat, word, i, j, 0)){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private static boolean find(char[][] mat, String word, int x, int y, int idx) {
        int wlen = word.length();
        int n = mat.length;
        int m = mat[0].length;

        if(idx == word.length()) return true;

        if(x < 0 || y < 0 || x >= n || y >= m) return false;

        if(mat[x][y] == word.charAt(idx)){
            char temp = mat[x][y];
            mat[x][y] = '#';
            boolean res = find(mat, word,x - 1, y, idx + 1) ||
                    find(mat, word,x + 1, y, idx + 1) ||
                    find(mat, word, x, y - 1, idx + 1) ||
                    find(mat, word, x, y + 1, idx + 1);
            mat[x][y] = temp;
            return res;
        }
        return false;
    }
}
