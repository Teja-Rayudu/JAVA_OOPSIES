package DSA.LINKED_LISTS;

import java.util.Scanner;
import static DSA.LINKED_LISTS.ReverseLL.display;

public class RotateList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split(" ");
        int n = nodes.length;
        if(n == 0) return;
        Node head = new Node(Integer.parseInt(nodes[0]));
        Node curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new Node(Integer.parseInt(nodes[i]));
            curr = curr.next;
        }
        int r = sc.nextInt();
        Node list = rotate(head, r);
        display(list);
    }

    private static Node rotate(Node head, int r) {
        Node first = head;
        Node last = head;
        for (int i = 0; i < r; i++) {
            if(first.next != null) first = first.next;
            else first = head;
        }
        if(first == last) return head;

        while (first.next != null){
            last = last.next;
            first = first.next;
        }

        Node A = last.next;
        last.next = null;
        first.next = head;
        return A;
    }
}
