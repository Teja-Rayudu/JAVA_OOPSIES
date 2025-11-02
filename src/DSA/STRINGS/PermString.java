package DSA.STRINGS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermString { //Permutations of a string
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> permutations = permutation(s);
        System.out.println(permutations);
    }

    private static List<String> permutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        permute(sb, 0, res);
        return res;
    }

    private static void permute(StringBuilder sb, int index, List<String> res) {
        if(index == sb.length()){
            res.add(sb.toString());
        }

        for (int i = index; i < sb.length(); i++){
            swap(sb, i, index);
            permute(sb, index + 1, res);
            swap(sb, i, index);
        }
    }

    private static void swap(StringBuilder sb, int i, int index) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(index));
        sb.setCharAt(index,temp);
    }


}
