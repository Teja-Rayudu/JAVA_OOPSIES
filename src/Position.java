import java.util.Arrays;
import java.util.Scanner;

public class Position { // Return first and last position of element 'X' in 0-based index array.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int[] pos = new int[2];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            if( arr[i] == x){
                if( pos[0] == -1) pos[0] = i;
                else pos[1] = i;
            }
        }
        System.out.println(pos[0] + " " + pos[1]);
    }
}
