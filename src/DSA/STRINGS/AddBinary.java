package DSA.STRINGS;

import java.util.Scanner;

public class AddBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(addBin(s1, s2));
    }

    private static String addBin(String s1, String s2) {
        s1 = trimZeros(s1);
        s2 = trimZeros(s2);
        int n = s1.length(), m = s2.length();
        if(n < m){
            return addBin(s2, s1);
        }
        int carry = 0, j = m - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0 ; i--) {
            int bit1 = s1.charAt(i) - '0';
            int sum = carry + bit1;

            if(j >= 0){
                int bit2 = s2.charAt(j) - '0';
                sum += bit2;
                j--;
            }
            int bit = sum & 1;
            carry = sum >> 1;
            sb.append(bit);
        }
        if(carry > 0){
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    private static String trimZeros(String s) {
        int first_One = s.indexOf("1");
        return (first_One == -1)? "0" : s.substring(first_One);
    }
}
