package DSA.BACK_TRACKING;

public class ValidSudoku {
    private static boolean isValidSudoku(char[][] board) {
        // Create arrays to keep track of seen numbers for row, col, and boxes
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int num = board[i][j] - '1'; // 0-based index for digits 1-9
                    int boxIdx = (i/3)*3 + j/3;

                    if(row[i][num] || col[j][num] || box[boxIdx][num]) {
                        return false;
                    }

                    row[i][num] = true;
                    col[j][num] = true;
                    box[boxIdx][num] = true;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {
                    {'5','3','.','.','7','.','.','.','.'},
                    {'6','.','.','1','9','5','.','.','.'},
                    {'.','9','8','.','.','.','.','6','.'},
                    {'8','.','.','.','6','.','.','.','3'},
                    {'4','.','.','8','.','3','.','.','1'},
                    {'7','.','.','.','2','.','.','.','6'},
                    {'.','6','.','.','.','.','2','8','.'},
                    {'.','.','.','4','1','9','.','.','5'},
                    {'.','.','.','.','8','.','.','7','9'}
        };

        boolean result = isValidSudoku(board);

        System.out.println("Is the board valid? " + result);
    }

}

