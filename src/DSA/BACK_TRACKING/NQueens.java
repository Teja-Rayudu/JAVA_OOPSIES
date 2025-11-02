package DSA.BACK_TRACKING;

import java.util.Scanner;

public class NQueens {
    static int[][] board;

    public static void initialize(int n){
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
    }

    private static void print(){
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solveBoard(int col){
        int n = board.length;
        if(col >= n) return true;
        for (int i = 0; i < n; i++) {
            if(isSafe(i,col)) {
                board[i][col] = 1;
                if(solveBoard(col + 1)) return true;
                board[i][col] = 0; //BACK TRACKING
            }

        }
        return false;
    }

    private static boolean isSafe(int row, int col) {
        int n = board.length;
        for(int i = 0; i < col; i++){
            if(board[row][i] == 1) return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0 ; i--, j--) {
            if(board[i][j] == 1) return false;
        }

        for (int i = row, j = col; i < n && j >= 0 ; i++, j--) {
            if(board[i][j] == 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        initialize(n);
        if(solveBoard(0)) {
            print();
        }
        else {
            System.out.println("Solution doesn't exist");
        }
    }
}
