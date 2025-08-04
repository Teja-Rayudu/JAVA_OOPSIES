import java.util.Scanner;
import java.util.Stack;

public class LongestValidParenthesis {
    private static int findValid(String s){
        Stack<Integer> st = new Stack<>();
        int max_length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push(i);
            else{
                st.pop();
                if(st.isEmpty()) st.push(i);
                else max_length = Math.max(max_length, i - st.peek());
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int length = findValid(s);
        System.out.println("The longest valid parenthesis is: "+length);
    }
}
