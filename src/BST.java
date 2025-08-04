import java.util.*;
public class BST {
    public static  Tnode insert(Tnode root, int key){
        if(root == null){
            root = new Tnode(key);
            return  root;
        }

        if(key < root.data){
            root.left =insert(root.left, key);
        }
        else root.right = insert(root.right, key);
        return root;
    }

    private static void display(Tnode root){
        if(root != null) {
            Queue<Tnode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i < size; i++){
                    Tnode n = q.poll();
                    assert n != null;
                    System.out.print(n.data + " ");
                    if(n.left != null) q.add(n.left);
                    if(n.right != null) q.add(n.right);
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Tnode root = null;
        for(int i = 0; i < n; i++){
            root = insert(root, sc.nextInt());
        }

        display(root);
    }
}
