package DSA.LINKED_LISTS;

import java.util.Scanner;

public class IntersectionOfList {
    private static Node intersection(Node A, Node B){
        if(A == null || B == null) return null;
        Node pointerA = A, pointerB = B;
        while (pointerA != pointerB){
            pointerA = (pointerA == null)? B : pointerA.next;
            pointerB = (pointerB == null)? A : pointerB.next;
        }
        return pointerA;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes1 = sc.nextLine().split(" ");
        String[] nodes2 = sc.nextLine().split(" ");
        Node A = makeLL(nodes1);
        Node B = makeLL(nodes2);
        Node interNode = intersection(A, B);
        if(interNode != null) System.out.println("The intersection at :" + interNode.data);
        else System.out.println("The two lists has no intersection");
    }

    public static Node makeLL(String[] nodes){
        int n = nodes.length;
        if(n == 0) return null;
        Node head = new Node(Integer.parseInt(nodes[0]));
        Node curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new Node(Integer.parseInt(nodes[i]));
            curr = curr.next;
        }
        return head;
    }
}
