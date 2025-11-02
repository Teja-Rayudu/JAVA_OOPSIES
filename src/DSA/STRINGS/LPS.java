package DSA.STRINGS;

import java.util.Scanner;

public class LPS { //Longest Palindromic Substring
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        System.out.println(lps(st));
    }

    private static String lps(String st) {
        String ms = "@";
        for(char c : st.toCharArray()){
            ms += "#" + c;
        }
        ms += "#$";
        return manachers(ms);
    }

    private static String manachers(String ms) {
        int n = ms.length();
        int[] p = new int[n];
        int l = 0, r = 0;
        int maxLen = 0, center = 0;
        for(int i = 1; i < n; ++i){
            int mirror = l + r - i;
            if(mirror >= 0 && mirror < n){
                p[i] = Math.max(0, Math.min(r - i, p[mirror]));
            }
            else{
                p[i] = 0;
            }
            
            while ((i + 1 + p[i]) < n && (i - 1 - p[i]) >= 0 && ms.charAt(i + 1+ p[i]) == ms.charAt( i - 1 - p[i])){
                ++p[i];
            }
            if(i + p[i] > r){
                l = i - p[i];
                r = i + p[i];
            }

            if (p[i] > maxLen) {
                maxLen = p[i];
                center = i;
            }
        }
        int start = (center - maxLen) / 2;
        return ms.replaceAll("[@#$]", "").substring(start, start + maxLen);
    }
}
