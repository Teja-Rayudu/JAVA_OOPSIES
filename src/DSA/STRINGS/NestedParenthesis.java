package DSA.STRINGS;

import java.util.Scanner;

public class NestedParenthesis {
    private static int findNested(String s){
        int max = 0;
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                count++;
                max = Math.max(max, count);
            }
            else{
                count--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int nested = findNested(s);
        System.out.println(nested);
    }
}
