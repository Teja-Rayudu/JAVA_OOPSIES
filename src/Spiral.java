import java.util.*;
public class Spiral {

    static List<Integer> printSpiral(int[][] matrix){
        int n = matrix.length, m = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int top_row = -1, bottom_row = n, left_col = -1, right_col = m;
        int k = 0;
        while (k < n*m){
            int current_row = top_row + 1;
            if(current_row < bottom_row){
                for(int curr_col = left_col + 1; curr_col < right_col; curr_col++) {
                    k++;
                    list.add(matrix[current_row][curr_col]);
                }
            }
            top_row = current_row;
            int current_col = right_col-1;
            if(current_col > left_col){
                for (int curr_row = top_row + 1; curr_row < bottom_row; curr_row++) {
                    k++;
                    list.add(matrix[curr_row][current_col]);
                }
            }
            right_col = current_col;
            current_row = bottom_row - 1;
            if(current_row > top_row){
                for(int curr_col = right_col - 1; curr_col > left_col; curr_col--){
                    k++;
                    list.add(matrix[current_row][curr_col]);
                }
            }
            bottom_row = current_row;
            current_col = left_col + 1;
            if(current_col < right_col){
                for(int curr_row = bottom_row-1; curr_row > top_row; curr_row--){
                    k++;
                    list.add(matrix[curr_row][current_col]);
                }
            }
            left_col = current_col;
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        List<Integer> ans = printSpiral(arr);

        for(int i : ans){
            System.out.print(i + " ");
        }
        sc.close();
    }
}
