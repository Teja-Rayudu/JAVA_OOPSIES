
import java.util.Scanner;

public class LCA extends BST { //Least Common Ancestor of Tree Nodes

    static Tnode lca(Tnode root, int p, int q){
        if(root == null) return null;
        if(p < root.data && q < root.data) return lca(root.left, p, q);
        if(p > root.data && q > root.data) return lca(root.right, p, q);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Tnode root = null;
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }
        int p = sc.nextInt(), q = sc.nextInt();
        Tnode ancestor = lca(root, p, q) == null? new Tnode(-1) : lca(root, p, q);
        System.out.printf("The least common ancestor of %d and %d is %d", p, q, ancestor.data);
    }
}
