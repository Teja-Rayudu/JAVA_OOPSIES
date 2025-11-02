package DSA.BACK_TRACKING;

public class Sudoku {

    public static void main(String[] args) {
        int[][] mat = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        solve(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    private static void solve(int[][] mat) {
        solveSudokuRec(mat, 0, 0);
    }

    private static boolean solveSudokuRec(int[][] mat, int row, int col){
        if(row == 8 && col == 9){ //base condition.
            return true;
        }

        if(col == 9){
            row++;
            col = 0;
        }

        if(mat[row][col] != 0){
            return solveSudokuRec(mat, row, col + 1);
        }

        for(int num = 1; num <= 9; num++){
            if(isSafe(mat, row, num, col)){
                mat[row][col] = num;
                if(solveSudokuRec(mat, row, col + 1)) return true;
                mat[row][col] = 0;
            }

        }
        return false;
    }

    private static boolean isSafe(int[][] mat, int row, int num, int col) {
        //check same row
        for(int x = 0; x < 9; x++){
            if(mat[row][col] == num){
                return false;
            }
        }

        //check column
        for(int y = 0; y < 9; y++){
            if(mat[y][col] == num){
                return false;
            }
        }

        int grid_row = row - (row % 3);
        int grid_col = col - (col % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(mat[i + grid_row][j + grid_col] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
