package DSA.STRINGS;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    private static String reverse(String s){
        s += " ";
        Stack<String> st = new Stack<>();
        String str = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                st.push(str);
                str = "";
            }
            else{
                str += s.charAt(i);
            }
        }
        String ans = "";
        while (st.size() != 1){
            ans += st.peek() + " ";
            st.pop();
        }
        ans += st.peek();
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverse(s));
    }
}
