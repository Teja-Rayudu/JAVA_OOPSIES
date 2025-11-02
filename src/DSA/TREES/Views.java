package DSA.TREES;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static DSA.TREES.Tree.buildTree;

public class Views {

    public static void leftView(Tnode root){
        if(root == null) System.out.println("The tree is empty 🥲");
        Queue<Tnode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Tnode node = q.poll();
                if(i == 0) System.out.print(node.data + " ");
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        System.out.println();
    }

    public static void rightView(Tnode root){
        if(root == null) System.out.println("The tree is empty 🥲");
        Queue<Tnode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Tnode node = q.poll();
                if(i == size - 1) System.out.println(node.data + " ");
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split(" ");
        Tnode root = buildTree(nodes);

        System.out.println("Left view of the tree :");
        leftView(root);

        System.out.println("Right view of the tree :");
        rightView(root);
    }
}
