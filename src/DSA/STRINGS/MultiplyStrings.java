package DSA.STRINGS;

import java.util.Scanner;

public class MultiplyStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n1 = sc.next();
        String n2 = sc.next();
        System.out.println(multiply(n1,n2));
    }

    private static String multiply(String n1, String n2) {
        if(n1.equals("0") || n2.equals("0")){
            return "0";
        }
        boolean neg = false;
        if(n1.contains("-")){
            neg = !neg;
            n1 = n1.substring(1);
        }
        if (n2.contains("-")){
            neg = !neg;
            n2 = n2.substring(1);
        }

        int len1= n1.length();
        int len2 = n2.length();
        int[] result = new int[len1 + len2];
        for(int i = len1 - 1; i >=0 ; i--){
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j] += sum/10;
                result[i + j + 1] = sum%10;

            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < result.length && result[i] == 0) i++;
        for (; i < result.length; i++) sb.append(result[i]);
        if (neg) sb.insert(0, '-');
        return sb.toString();
    }
}
