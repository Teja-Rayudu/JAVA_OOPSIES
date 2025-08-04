import java.util.*;

public class MinimalString {

    static String lexicoMinimal(String s, List<Integer> arr, List<Integer> brr) {
        String bestString = s;

        for (int i = 0; i < arr.size(); i++) {
            char[] st = s.toCharArray();
            swap(st, arr.get(i), brr.get(i));
            String newString = new String(st);

            if (newString.compareTo(bestString) < 0) {
                bestString = newString;
            }
        }
        return bestString;
    }

    private static void swap(char[] st, int i, int j) {
        char temp = st[i];
        st[i] = st[j];
        st[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int m = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            arr.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            brr.add(sc.nextInt());
        }

        String ans = lexicoMinimal(s, arr, brr);
        System.out.println(ans);

        sc.close();
    }
}