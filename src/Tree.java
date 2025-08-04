import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree {
    static Tnode buildTree(String[] s){
        if(s.length == 0 || s[0].equals("null")) return null;
        Queue<Tnode> q = new LinkedList<>();
        Tnode root = new Tnode(Integer.parseInt(s[0]));
        q.add(root);
        int i = 1;
        while (!q.isEmpty()){
            Tnode node = q.poll();
            if(i < s.length && !s[i].equals("null")){
                node.left = new Tnode(Integer.parseInt(s[i]));
                q.add(node.left);
            }
            i++;
            if(i < s.length && !s[i].equals("null")){
                node.right = new Tnode(Integer.parseInt(s[i]));
                q.add(node.right);
            }
            i++;
        }

        return root;
    }

    private static void display(Tnode root){
        if(root == null) return;
        display(root.left);
        display(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        Tnode root = buildTree(s);
        display(root);
    }
}
